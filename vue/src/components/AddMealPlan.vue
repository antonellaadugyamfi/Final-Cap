<template>
  <div>
    <form v-on:submit.prevent="addMealPlan">
        <label>Household ID</label>
        <input v-model="mealPlan.householdId" />
        <label>Date</label>
        <input v-model="mealPlan.plannerDate" />
        <label>Meal Name</label>
        <textarea v-model="mealPlan.mealName"></textarea>
        <label>Meal Details</label>
        <textarea v-model="mealPlan.mealDetails"></textarea>
  
        <button>Save</button>
    </form>
  </div>
</template>

<script>
import MealPlansService from '../services/MealPlansService'
export default {
    data(){
        return{
            mealPlan: {}
        }
    },
    methods: {
        addMealPlan(){
            MealPlansService.addMeal(this.mealPlan).then((response) => {
                if(response.status == 200) {
                        window.alert("Meal Plan Added!");
                        this.mealPlan = {};
                        this.$router.push({name: "browseMealPlans"});
                }
            })
            .catch((error) => {
                if (error.response){
                    window.alert("Bad Request");
                }
                else if (error.request){
                    window.alert("error");
                }
            })
        }
    }
}
</script>

<style>

</style>