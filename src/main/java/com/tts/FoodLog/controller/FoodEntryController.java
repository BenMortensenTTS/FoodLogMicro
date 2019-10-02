package com.tts.FoodLog.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tts.FoodLog.model.FoodEntry;
import com.tts.FoodLog.service.FoodEntryServiceImpl;

@RestController
public class FoodEntryController {
	
	@Autowired
	FoodEntryServiceImpl foodEntryServiceImpl;
	
	@GetMapping("/foodentries")
	public ArrayList<FoodEntry> grabAllEntries() {
		return foodEntryServiceImpl.getEveryEntry();
	}
	
	@GetMapping("/foodentry/{id}")
	public FoodEntry grabEntry(@PathVariable Long id) {
		return foodEntryServiceImpl.getSingleEntry(id);
	}
	
	@GetMapping("/foodentries/washomecooked")
	public ArrayList<FoodEntry> grabHomeCooked(@RequestParam Boolean wasHomeCooked) {
		return foodEntryServiceImpl.getHomeCookedEntries(wasHomeCooked);
	}
	
	@GetMapping("/foodentries/wouldeatagain")
	public ArrayList<FoodEntry> grabEatAgain(@RequestParam Boolean wouldEatAgain) {
		return foodEntryServiceImpl.getWouldEats(wouldEatAgain);
	}
	
	@GetMapping("/foodentries/satisfactionscore")
	public ArrayList<FoodEntry> grabScoredEntries(@RequestParam Integer satisfactionScore) {
		return foodEntryServiceImpl.getScoredEntries(satisfactionScore);
	}
	
	@GetMapping("/foodentries/mealtype")
	public ArrayList<FoodEntry> grabMealTypes(@RequestParam String mealType) {
		return foodEntryServiceImpl.getMealTypes(mealType);
	}
	
	@GetMapping("/foodentries/meal")
	public ArrayList<FoodEntry> grabMeal(@RequestParam String meal) {
		return foodEntryServiceImpl.getMeal(meal);
	}
	
	@PostMapping("/foodentry")
	public void inputAnEntry(FoodEntry foodEntry) {
		foodEntryServiceImpl.saveSingleEntry(foodEntry);
	}
	
	@PutMapping("/foodentry/{id}")
	public void modifyAnEntry(@PathVariable Long id, FoodEntry foodEntry) {
		foodEntryServiceImpl.modifyEntry(id, foodEntry);
	}
	
	@DeleteMapping("/foodentries/deleteAll")
	public void deleteEveryEntry() {
		foodEntryServiceImpl.deleteEveryEntry();
	}
	
	@DeleteMapping("/foodentries/delete/{id}")
	public void deleteSingleEntry(@PathVariable Long id) {
		foodEntryServiceImpl.deleteEntry(id);
	}
	
}
