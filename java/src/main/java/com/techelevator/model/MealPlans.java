package com.techelevator.model;

import java.time.LocalDate;
import java.util.Date;

public class MealPlans {

    private int mealPlanId;
    private String mealPlanName;
    private int householdId;
    private Date plannerDate;
    private Date startDate;
    private Date endDate;
    private int mealId;
    private String mealName;


    public int getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(int mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public int getHouseholdId() {
        return householdId;
    }
    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }

    public Date getPlannerDate() {
        return plannerDate;
    }

    public void setPlannerDate(Date plannerDate) {
        this.plannerDate = plannerDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealPlanName() {
        return mealPlanName;
    }

    public void setMealPlanName(String mealPlanName) {
        this.mealPlanName = mealPlanName;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
}
