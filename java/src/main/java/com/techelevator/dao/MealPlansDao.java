package com.techelevator.dao;

import com.techelevator.model.MealPlans;
import com.techelevator.model.Meals;

import java.util.List;

public interface MealPlansDao {

    //    public List<MealPlans> getAllMealPlans();
    public List<MealPlans> getAllMealPlanNames(int id);
    public List<MealPlans> getMealPlanByMealPlanId(int id);
    public int addMealPlans(MealPlans mealPlan);
    public void editMealPlans(MealPlans meal);
    public void addMealToMealPlan(MealPlans mealPlan);


}
