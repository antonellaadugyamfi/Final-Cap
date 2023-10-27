<template>
    <div>
      <form v-on:submit.prevent="deleteMeal(meal.mealId)">
          <label>Meal</label>
          <p>{{ meal.mealName }}</p>
          <label>Meal Ingredients</label>
          <p>{{ meal.ingredients }}</p>
          <label>Meal Instructions</label>
          <p>{{ meal.instructions }}</p>
          <button>Delete Meal</button>
      </form>
    </div>
  </template>
  
  <script>
  import MealService from '../services/MealService'
  export default {
      data(){
          return{
              mealId: -1,
              meal: {}
          }
      },
      methods: {
            deleteMeal(id){
                MealService.deleteMeal(id).then(response => {
                    if(response.status === 200){
                        window.alert("Meal deleted!");
                        this.$router.push({name: "home"});
                    }
                })
            }
      },
      created() {
        this.mealId = this.$route.params.id;
        MealService.getMealById(this.mealId).then(
            (response) => {
                this.meal = response.data;
            }
        );
      },
  }
  
  </script>
  
  <style>
  
  </style>