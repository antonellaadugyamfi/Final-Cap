package com.techelevator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MealPlansTest {

    private MealPlans mealPlan;

    @BeforeEach
    void setUp() {
        mealPlan = new MealPlans();
    }

    @Test
    void getSetMealPlanId() {
        mealPlan.setMealPlanId(1);
        assertEquals(1, mealPlan.getMealPlanId());
    }

    @Test
    void getSetHouseholdId() {
        mealPlan.setHouseholdId(2);
        assertEquals(2, mealPlan.getHouseholdId());
    }

    @Test
    void getSetPlannerDate() {
        Date plannerDate = new Date();
        mealPlan.setPlannerDate(plannerDate);
        assertEquals(plannerDate, mealPlan.getPlannerDate());
    }

    @Test
    void getSetStartDate() {
        Date startDate = new Date();
        mealPlan.setStartDate(startDate);
        assertEquals(startDate, mealPlan.getStartDate());
    }

    @Test
    void getSetEndDate() {
        Date endDate = new Date();
        mealPlan.setEndDate(endDate);
        assertEquals(endDate, mealPlan.getEndDate());
    }

    @Test
    void getSetMealId() {
        mealPlan.setMealId(3);
        assertEquals(3, mealPlan.getMealId());
    }

    @Test
    void getSetMealPlanName() {
        mealPlan.setMealPlanName("Test Meal Plan");
        assertEquals("Test Meal Plan", mealPlan.getMealPlanName());
    }
}