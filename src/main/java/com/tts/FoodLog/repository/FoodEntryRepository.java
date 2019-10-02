package com.tts.FoodLog.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.FoodLog.model.FoodEntry;

@Repository
public interface FoodEntryRepository extends CrudRepository<FoodEntry, Long> {

	public ArrayList<FoodEntry> findAll();

	public FoodEntry findFoodEntryById(Long id);

	public void deleteFoodEntryById(Long id);

	public ArrayList<FoodEntry> findFoodEntryByWasHomeCooked(Boolean wasHomeCooked);

	public ArrayList<FoodEntry> findFoodEntryByWouldEatAgain(Boolean wouldEatAgain);

	public ArrayList<FoodEntry> findFoodEntryBySatisfactionScore(Integer satisfactionScore);

	public ArrayList<FoodEntry> findFoodEntryByMealType(String mealType);

	public ArrayList<FoodEntry> findFoodEntryByMeal(String meal);

}
