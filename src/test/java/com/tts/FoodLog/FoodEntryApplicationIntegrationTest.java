package com.tts.FoodLog;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tts.FoodLog.model.FoodEntry;
import com.tts.FoodLog.repository.FoodEntryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
	webEnvironment = WebEnvironment.MOCK,
	classes = FoodLogApplication.class
)

@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")

public class FoodEntryApplicationIntegrationTest {
	
	@Autowired
	private FoodEntryRepository foodEntryRepository;
	
	@Autowired
	private MockMvc mvc;
	
	private FoodEntry tastyEntry;
	
	@Before
	public void setUp() {
		tastyEntry = new FoodEntry("Dinner", "Mild Hot Wings", 10, true, false);
		foodEntryRepository.save(tastyEntry);
	}
	
	@After
	public void tearDown() {
		foodEntryRepository.delete(tastyEntry);
	}

	@Test
	public void givenFoodEntryId_returnsFoodEntry() throws Exception {
		Long foodEntryId = tastyEntry.getId();
		
		mvc.perform(get("/foodentry" + foodEntryId)
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content()
		.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.meal", is("Mild Hot Wings")));
	}
	
	@Test
	public void findAll_returnAllFoodEntries() throws Exception {
		
		mvc.perform(get("/foodentries")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content()
		.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(5)))
		.andExpect(jsonPath("$[4].meal", is("Mild Hot Wings")));
	}

}
