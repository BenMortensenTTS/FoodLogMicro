package com.tts.FoodLog.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.FoodLog.model.FoodEntry;
import com.tts.FoodLog.repository.FoodEntryRepository;

@Service
public class FoodEntryServiceImpl implements FoodEntryServiceInt {
	
	@Autowired
	FoodEntryRepository foodEntryRepository;

	@Override
	public ArrayList<FoodEntry> getEveryEntry() {
		return foodEntryRepository.findAll();
	}
	
	@Override
	public FoodEntry getSingleEntry(Long id) {
		return foodEntryRepository.findFoodEntryById(id);
	}
	
	@Override
	public void saveSingleEntry(FoodEntry foodEntry) {
		foodEntryRepository.save(foodEntry);
	}
	
	@Override
	public void modifyEntry(Long id, FoodEntry newEntry) {
		FoodEntry currentEntry = foodEntryRepository.findFoodEntryById(id);
		String mealType = newEntry.getMealType();
		String meal = newEntry.getMeal();
		Integer satisfactionScore = newEntry.getSatisfactionScore();
		Boolean wouldEatAgain = newEntry.getWouldEatAgain();
		Boolean wasHomeCooked = newEntry.getWasHomeCooked();
		
		currentEntry.setMealType(mealType);
		currentEntry.setMeal(meal);
		currentEntry.setSatisfactionScore(satisfactionScore);
		currentEntry.setWouldEatAgain(wouldEatAgain);
		currentEntry.setWasHomeCooked(wasHomeCooked);
		
		foodEntryRepository.save(currentEntry);
	}
	
	@Override
	public void deleteEveryEntry() {
		foodEntryRepository.deleteAll();
	}

	@Override
	public void deleteEntry(Long id) {
		foodEntryRepository.deleteFoodEntryById(id);
	}

	@Override
	public ArrayList<FoodEntry> getHomeCookedEntries(Boolean wasHomeCooked) {
		return foodEntryRepository.findFoodEntryByWasHomeCooked(wasHomeCooked);
	}

	@Override
	public ArrayList<FoodEntry> getWouldEats(Boolean wouldEatAgain) {
		return foodEntryRepository.findFoodEntryByWouldEatAgain(wouldEatAgain);
	}

	@Override
	public ArrayList<FoodEntry> getScoredEntries(Integer satisfactionScore) {
		return foodEntryRepository.findFoodEntryBySatisfactionScore(satisfactionScore);
	}

	@Override
	public ArrayList<FoodEntry> getMealTypes(String mealType) {
		return foodEntryRepository.findFoodEntryByMealType(mealType);
	}

	@Override
	public ArrayList<FoodEntry> getMeal(String meal) {
		return foodEntryRepository.findFoodEntryByMeal(meal);
	}
	
}
