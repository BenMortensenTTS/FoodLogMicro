package com.tts.FoodLog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String mealType;
	private String meal;
	private Integer satisfactionScore;
	private Boolean wouldEatAgain;
	private Boolean wasHomeCooked;
	
	public FoodEntry(String mealType, String meal, Integer satisfactionScore, Boolean wouldEatAgain, Boolean wasHomeCooked) {
		super();
		this.mealType = mealType;
		this.satisfactionScore = satisfactionScore;
		this.wouldEatAgain = wouldEatAgain;
		this.wasHomeCooked = wasHomeCooked;
		this.meal = meal;
	}
	
	public FoodEntry() {}

	public Long getId() {
		return id;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	
	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public Integer getSatisfactionScore() {
		return satisfactionScore;
	}

	public void setSatisfactionScore(Integer satisfactionScore) {
		this.satisfactionScore = satisfactionScore;
	}

	public Boolean getWouldEatAgain() {
		return wouldEatAgain;
	}

	public void setWouldEatAgain(Boolean wouldEatAgain) {
		this.wouldEatAgain = wouldEatAgain;
	}

	public Boolean getWasHomeCooked() {
		return wasHomeCooked;
	}

	public void setWasHomeCooked(Boolean wasHomeCooked) {
		this.wasHomeCooked = wasHomeCooked;
	}

	@Override
	public String toString() {
		return "FoodEntry [mealType=" + mealType + ", meal=" + meal + ", satisfactionScore=" + satisfactionScore
				+ ", wouldEatAgain=" + wouldEatAgain + ", wasHomeCooked=" + wasHomeCooked + "]";
	}
}
