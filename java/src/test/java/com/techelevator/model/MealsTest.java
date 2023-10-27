package com.techelevator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealsTest {

    private Meals meal;

    @BeforeEach
    void setUp() {
        meal = new Meals();
    }

    @Test
    void getSetMealId() {
        meal.setMealId(1);
        assertEquals(1, meal.getMealId());
    }

    @Test
    void getSetMealName() {
        meal.setMealName("Test Meal");
        assertEquals("Test Meal", meal.getMealName());
    }

    @Test
    void getSetDescription() {
        meal.setDescription("Test Description");
        assertEquals("Test Description", meal.getDescription());
    }

    @Test
    void getSetIngredients() {
        meal.setIngredients("Test Ingredients");
        assertEquals("Test Ingredients", meal.getIngredients());
    }

    @Test
    void getSetInstructions() {
        meal.setInstructions("Test Instructions");
        assertEquals("Test Instructions", meal.getInstructions());
    }

    @Test
    void getSetMealOwner() {
        meal.setMealOwner("Test Owner");
        assertEquals("Test Owner", meal.getMealOwner());
    }
}