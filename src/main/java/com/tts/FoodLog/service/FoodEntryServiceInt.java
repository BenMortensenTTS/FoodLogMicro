package com.tts.FoodLog.service;

import java.util.ArrayList;

import com.tts.FoodLog.model.FoodEntry;

public interface FoodEntryServiceInt {

	public FoodEntry getSingleEntry(Long id);

	public ArrayList<FoodEntry> getEveryEntry();

	public void saveSingleEntry(FoodEntry foodEntry);

	public void modifyEntry(Long id, FoodEntry foodEntry);

	public void deleteEveryEntry();

	public void deleteEntry(Long id);

	public ArrayList<FoodEntry> getHomeCookedEntries(Boolean wasHomeCooked);

	public ArrayList<FoodEntry> getWouldEats(Boolean wouldEatAgain);

	public ArrayList<FoodEntry> getScoredEntries(Integer satisfactionScore);

	public ArrayList<FoodEntry> getMealTypes(String mealType);

	public ArrayList<FoodEntry> getMeal(String meal);

}
