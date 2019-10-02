package com.tts.FoodLog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tts.FoodLog.model.FoodEntry;
import com.tts.FoodLog.repository.FoodEntryRepository;
import com.tts.FoodLog.service.FoodEntryServiceImpl;
import com.tts.FoodLog.service.FoodEntryServiceInt;

@RunWith(SpringRunner.class)
public class FoodEntryServiceTest {
	
	@Configuration
	static class ServiceConfiguration {
		@Bean
		public FoodEntryServiceInt configuration() {
			return new FoodEntryServiceImpl();
		}
	}
	
	@Autowired
	FoodEntryServiceInt foodEntryService;
	
	@MockBean
	FoodEntryRepository foodEntryRepository;
	
	private static FoodEntry tastyEntry1;
	private static FoodEntry tastyEntry2;
	private ArrayList<FoodEntry> listOfAllFood;
	private ArrayList<FoodEntry> listOfHomeCookedFood;

	@Before
	public void setUp() {
		tastyEntry1 = new FoodEntry("Snack", "Takis", 7, true, false);
		tastyEntry2 = new FoodEntry("Dinner", "Mashed Potatoes", 10, true, true);
		listOfAllFood = new ArrayList<>();
		listOfAllFood.add(tastyEntry1);
		listOfAllFood.add(tastyEntry2);
		
		listOfHomeCookedFood = new ArrayList<>();
		listOfHomeCookedFood.add(tastyEntry2);
		
	}

	@Test
	public void givenFoodEntryId_returnEntry() {
		Mockito.when(foodEntryRepository.findFoodEntryById(1L)).thenReturn(tastyEntry1);
		
		FoodEntry found = foodEntryService.getSingleEntry(1L);
		
		assertThat(tastyEntry1).isEqualToComparingFieldByField(found);
	}
	
	@Test
	public void ifFindAll_returnAllEntries() {
		
		Mockito.when(foodEntryRepository.findAll()).thenReturn(listOfAllFood);
		
		ArrayList<FoodEntry> found = foodEntryService.getEveryEntry();
		
		assertEquals(listOfAllFood, found);
	}
	
	@Test
	public void ifGetHomeCookedEntries_returnHomeCookedEntries() {
		Mockito.when(foodEntryRepository.findFoodEntryByWasHomeCooked(tastyEntry2.getWasHomeCooked())).thenReturn(listOfHomeCookedFood);
		
		ArrayList<FoodEntry> found = foodEntryService.getHomeCookedEntries(tastyEntry2.getWasHomeCooked());
		
		assertEquals(found, listOfHomeCookedFood);
	}
}
