package com.techelevator.dao;

import com.techelevator.model.MealPlans;
import com.techelevator.model.Meals;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Component
public class JdbcMealPlansDao implements MealPlansDao {
    private JdbcTemplate template;
    public JdbcMealPlansDao(DataSource dataSource){
        template = new JdbcTemplate(dataSource);
    }

//    @Override
//    public List<MealPlans> getAllMealPlans() {
//
//        String sql = "SELECT meal_plan.meal_plan_id, household_id, meal_plan_data.planner_date, " +
//                "meals.meal_name FROM meal_plan " +
//                "JOIN meal_plan_data ON meal_plan.meal_plan_id = meal_plan_data.meal_plan_id " +
//                "JOIN meals ON meal_plan_data.meal_id = meals.meal_id;";
//        SqlRowSet results = template.queryForRowSet(sql);
//        List<MealPlans> listOfMealPlans = new ArrayList<>();
//        while(results.next()){
//            MealPlans mealPlan = new MealPlans();
//            mealPlan.setMealPlanId(results.getInt("meal_plan_id"));
//            mealPlan.setHouseholdId(results.getInt("household_id"));
//            mealPlan.setMealId(results.getInt("meal_id"));
//            listOfMealPlans.add(mealPlan);
//        }
//        return listOfMealPlans;
//
//    }

    @Override
    public List<MealPlans> getAllMealPlanNames(int id) {
        String sql = "SELECT * FROM meal_plan WHERE household_id = ?;";
        SqlRowSet results = template.queryForRowSet(sql, id);
        List<MealPlans> listOfMealPlans = new ArrayList<>();
        while(results.next()){
            MealPlans mealPlan = new MealPlans();
            mealPlan.setMealPlanId(results.getInt("meal_plan_id"));
            mealPlan.setHouseholdId(results.getInt("household_id"));
            mealPlan.setMealPlanName(results.getString("meal_plan_name"));
            listOfMealPlans.add(mealPlan);
        }
        return listOfMealPlans;
    }

    @Override
    public List<MealPlans> getMealPlanByMealPlanId(int id) {
        String sql = "SELECT meal_plan.meal_plan_id, household_id, meal_plan_name, " +
                "meal_plan_data.planner_date, meal_plan_data.meal_id, meals.meal_name FROM meal_plan " +
                "JOIN meal_plan_data ON meal_plan.meal_plan_id = meal_plan_data.meal_plan_id " +
                "JOIN meals ON meal_plan_data.meal_id = meals.meal_id " +
                "WHERE meal_plan.meal_plan_id = ? " +
                "ORDER BY meal_plan_data.planner_date ASC;";
        SqlRowSet results = template.queryForRowSet(sql, id);
        List<MealPlans> listOfMealPlans = new ArrayList<>();
        while(results.next()){
            MealPlans mealPlan = new MealPlans();
            mealPlan.setMealPlanId(results.getInt("meal_plan_id"));
            mealPlan.setHouseholdId(results.getInt("household_id"));
            mealPlan.setMealPlanName(results.getString("meal_plan_name"));
            mealPlan.setPlannerDate(results.getDate("planner_date"));
            mealPlan.setMealId(results.getInt("meal_id"));
            mealPlan.setMealName(results.getString("meal_name"));
            listOfMealPlans.add(mealPlan);
        }
        return listOfMealPlans;
    }




//    @Override
//    public void deleteMeal(int id) {
////        String sql = "DELETE FROM households_meals WHERE household_id = ?";
////        template.update(sql, id);
////        sql = "DELETE FROM households WHERE household_id = ?";
////        template.update(sql, id);
////        sql = "DELETE FROM meal_plan WHERE household_id = ?";
////        template.update(sql, id);
//
//         String sql1 = "DELETE from households WHERE household_id = ? JOIN meal_plan ON meal_plan.household_id = households.household_id ;";
//         String sql = "Delete from meal_plan WHERE meal_plan_id = ?;";
//        template.update(sql, id);

//    }

    @Override
    public int addMealPlans(MealPlans mealPlan) {
        String sql = "INSERT INTO meal_plan (household_id, meal_plan_name) VALUES (?,?) RETURNING meal_plan_id;";
        int newId = template.queryForObject(sql, Integer.class, mealPlan.getHouseholdId(), mealPlan.getMealPlanName());

        Date startDate = mealPlan.getStartDate();
        Date endDate = mealPlan.getEndDate();

        Calendar plannerDate = Calendar.getInstance();
        plannerDate.setTime(startDate);

        while (!plannerDate.getTime().after(endDate)) {
            plannerDate.add(Calendar.DAY_OF_MONTH, 1);
            sql = "INSERT INTO meal_plan_data (meal_plan_id, planner_date) VALUES (?,?);";
            template.update(sql, newId, plannerDate.getTime());
        }
        return newId;
    }

    @Override
    public void editMealPlans(MealPlans meal) {
//        String sql = "UPDATE meal_plan SET household_id = ?, meal_name = ?, planner_date = ?, meal_plan_details = ? WHERE meal_plan_id = ?";
//        template.update(sql, meal.getHouseholdId(),meal.getMealName(), meal.getPlannerDate(), meal.getMealDetails(), meal.getMealPlanId());

    }

    @Override
    public void addMealToMealPlan(MealPlans mealPlan) {
        String sql = "UPDATE meal_plan_data SET meal_id = ? WHERE meal_plan_id = ? AND planner_date = ?;";

        Date datePlannerDate = mealPlan.getPlannerDate();
        Calendar plannerDate = Calendar.getInstance();
        plannerDate.setTime(datePlannerDate);
        plannerDate.add(Calendar.DAY_OF_MONTH, 1);

        template.update(sql, mealPlan.getMealId(), mealPlan.getMealPlanId(), plannerDate.getTime());
    }
}
