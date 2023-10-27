package com.techelevator.controller;

import com.techelevator.dao.MealsDao;
import com.techelevator.model.Meals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class MealsController {
    @Autowired
    private MealsDao mealsDao;
    @RequestMapping(path = "/meals", method = RequestMethod.GET)
    public List<Meals> getAllMeals(){
        return mealsDao.getAllMeals();
    }

    @RequestMapping(path = "/usersMeals", method = RequestMethod.GET)
    public List<Meals> getAllUsersMeals(Principal principal){
        return mealsDao.getAllUsersMeals(principal.getName());
    }

    @RequestMapping(path = "/meals/{id}", method = RequestMethod.GET)
    public Meals getMealById(@PathVariable int id){
        Meals meal = mealsDao.getMealById(id);
        return meal;
    }

    @RequestMapping(path = "/addMeal", method = RequestMethod.POST)
    public void addMeal(@Valid @RequestBody Meals meal, Principal principal){
        mealsDao.addMeal(meal, principal.getName());
    }

    @RequestMapping(path = "/editMeal", method = RequestMethod.PUT)
    public void editMeal(@Valid @RequestBody Meals meal){
        mealsDao.editMeal(meal);
    }

    @RequestMapping(path = "/meals/{id}", method = RequestMethod.DELETE)
    public void deleteMeal(@PathVariable int id){
        mealsDao.deleteMeal(id);
    }



}
