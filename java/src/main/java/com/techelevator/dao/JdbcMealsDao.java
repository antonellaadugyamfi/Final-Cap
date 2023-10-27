package com.techelevator.dao;

import com.techelevator.model.Meals;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealsDao implements MealsDao {

    private JdbcTemplate template;
    public JdbcMealsDao(DataSource dataSource){
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Meals> getAllMeals() {
        String sql = "SELECT * FROM meals";
        SqlRowSet results = template.queryForRowSet(sql);
        List<Meals> listOfMeals = new ArrayList<>();
        while(results.next()){
            Meals meals = new Meals();
            meals.setMealId(results.getInt("meal_id"));
            meals.setMealName(results.getString("meal_name"));
            meals.setDescription(results.getString("description"));
            meals.setIngredients(results.getString("ingredients"));
            meals.setInstructions(results.getString("instructions"));
            listOfMeals.add(meals);
        }
        return listOfMeals;
    }

    @Override
    public List<Meals> getAllUsersMeals(String username) {
        String sql = "SELECT * FROM meals WHERE meal_owner = ?";
        SqlRowSet results = template.queryForRowSet(sql, username);
        List<Meals> listOfMeals = new ArrayList<>();
        while(results.next()){
            Meals meals = new Meals();
            meals.setMealId(results.getInt("meal_id"));
            meals.setMealName(results.getString("meal_name"));
            meals.setDescription(results.getString("description"));
            meals.setIngredients(results.getString("ingredients"));
            meals.setInstructions(results.getString("instructions"));
            meals.setMealOwner(results.getString("meal_owner"));
            listOfMeals.add(meals);
        }
        return listOfMeals;
    }

    @Override
    public Meals getMealById(int id) {
        String sql = "SELECT * FROM meals WHERE meal_id = ?";
        SqlRowSet result = template.queryForRowSet(sql, id);
        Meals meal = new Meals();
        if (result.next()){
            meal.setMealId(result.getInt("meal_id"));
            meal.setMealName(result.getString("meal_name"));
            meal.setDescription(result.getString("description"));
            meal.setIngredients(result.getString("ingredients"));
            meal.setInstructions(result.getString("instructions"));
        }
        return meal;
    }

    @Override
    public void deleteMeal(int id) {
        String sql = "DELETE FROM meal_plan_data WHERE meal_id = ?";
        template.update(sql, id);
        sql = "DELETE FROM meals WHERE meal_id = ?";
        template.update(sql, id);
    }

    @Override
    public void addMeal(Meals meal, String username) {
        String sql = "INSERT INTO meals (meal_name, description, ingredients, instructions, meal_owner) VALUES(?,?,?,?,?);";
        template.update(sql, meal.getMealName(), meal.getDescription(), meal.getIngredients(), meal.getInstructions(), username);
    }

    @Override
    public void editMeal(Meals meal) {
        String sql = "UPDATE meals SET meal_name = ?, description = ?, ingredients = ?, instructions = ? WHERE meal_id = ?";
        template.update(sql, meal.getMealName(), meal.getDescription(), meal.getIngredients(), meal.getInstructions(), meal.getMealId());
    }

}
