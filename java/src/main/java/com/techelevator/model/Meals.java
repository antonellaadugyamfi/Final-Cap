package com.techelevator.model;

public class Meals {

    private int mealId;
    private String mealName;
    private String description;
    private String ingredients;
    private String instructions;

    private String mealOwner;


    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getMealOwner() {
        return mealOwner;
    }

    public void setMealOwner(String mealOwner) {
        this.mealOwner = mealOwner;
    }

}
