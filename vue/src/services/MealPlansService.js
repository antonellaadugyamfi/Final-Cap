import axios from 'axios';

export default {

    getAllMealPlans(){
        return axios.get("/mealPlans");
    },
    
    getAllMealPlanNames(id){
        return axios.get("/mealPlanNames/" + id);
    },

    getMealPlansByMealPlanId(id){
        return axios.get("/mealPlan/" + id);
    },

    addMealPlan(mealPlan){
        return axios.post("/addMealPlan", mealPlan);
    },

    editMeal(mealPlan){
        return axios.put("/editMealPlan", mealPlan);
    },

    addMealToMealPlan(meal){
        return axios.put("/addMealToMealPlan", meal);
    },

    // deleteMeal(id){
    //     return axios.delete("/meals/" + id);
    // }

}