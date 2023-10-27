<template>
  <div>
    <form v-on:submit.prevent="editMealPlan">
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
            mealId: -1,
            mealPlan: {}
        }
    },
    methods: {
          editMealPlan(){
            MealPlansService.editMeal(this.mealPlan).then((response) => {
                if(response.status == 200) {
                        window.alert("Meal Plan updated!");
                        this.$router.push({name: "browseMealPlans"});
                }
            })
          }
      },
      created() {
        this.mealId = this.$route.params.id;
        MealPlansService.getMealById(this.mealId).then(
            (response) => {
                this.mealPlan = response.data;
            }
        );
    },
}

</script>

<style>

</style>