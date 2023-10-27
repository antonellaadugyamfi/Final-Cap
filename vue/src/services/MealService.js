import axios from 'axios';

export default {

    getAllMeals(){
        return axios.get("/meals");
    },
    
    getUsersMeal(){
        return axios.get("/usersMeals" );
    },

    getMealById(id){
        return axios.get("/meals/" + id);
    },

    addMeal(meal){
        return axios.post("/addMeal", meal);
    },

    editMeal(meal){
        return axios.put("/editMeal", meal);
    },

    deleteMeal(id){
        return axios.delete("/meals/" + id);
    }

}