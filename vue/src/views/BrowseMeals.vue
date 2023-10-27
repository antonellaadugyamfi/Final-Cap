<template>
  <div class="browseMeals">
    <h1>Browse Meals</h1>
    <div class="meal-link-container">
      <router-link class="meals-link" v-bind:to="{ name: 'addMeal' }"> Add Meal </router-link>
      <router-link class="meals-link" v-bind:to="{ name: 'browseMyMeals' }"> Browse My Meals </router-link>
    </div>

    <div class="meals-container">
      <div v-for="meal in meals" v-bind:key="meal.mealId" class="meal-card">
        <h4>{{ meal.mealName }}</h4>
        <button @click="showDetails(meal)">More Details</button>
      </div>
    </div>
    <div class="popup" v-if="selectedMeal">
      <h2>{{ selectedMeal.mealName }}</h2>
      <h6>Meal Description: </h6>
      <p>{{ selectedMeal.description }}</p>
      <h6>Meal Ingredients: </h6>
      <p>{{ selectedMeal.ingredients }}</p>
      <h6>Meal Instructions: </h6>
      <p>{{ selectedMeal.instructions }}</p>
      <button @click="hideDetails">Close</button>
    </div>
  </div>
</template>

<script>
import MealService from '../services/MealService';

export default {
  name: "home",
  data() {
    return {
      meals: [],
      selectedMeal: null
    }
  },
  created() {
    MealService.getAllMeals().then((response) => {
      console.log(response.data);
      this.meals = response.data;
    })
  },
  methods: {
    showDetails(meal) {
      this.selectedMeal = meal;
    },
    hideDetails() {
      this.selectedMeal = null;
    }
  }
};
</script>

<style scoped>
.browseMeals {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
}

.meals-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
  width: 75%;
}

.meal-card {
  width: calc(30% - 10px);
  margin-bottom: 20px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #083D77;
  color: white;
  white-space: nowrap;
}

.meal-card button {
  margin-top: 10px;
  display: inline-block;
  margin-top: 20px;
  margin-right: 10px;
  padding: 10px 20px;
  color: #083D77;
  border-radius: 5px;
  text-decoration: none;
  text-align: center;
  font-size: 18px;
  font-weight: bold;
  cursor: pointer;
  background-color: #EBEBD3;
}

.meal-card button:hover {
  background-color: #EE964B;
  color: #083D77;
}

.popup {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: #fff;
  padding: 15px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  z-index: 999;
  display: flex;
  flex-direction: column;
  width: 30%;
}

.popup h2 {
  margin-bottom: 20px;
  display: flex;
  justify-content: center;
  font-size: 50px;
}

.popup button {
  margin-top: 10px;
  display: inline-block;
  margin-top: 20px;
  margin-right: 10px;
  padding: 10px 20px;
  color: #083D77;
  border-radius: 5px;
  text-decoration: none;
  text-align: center;
  font-size: 18px;
  font-weight: bold;
  cursor: pointer;
  background-color: #EBEBD3;
  width: 50%;
  margin: 0 auto;
}

.popup button:hover {
  background-color: #EE964B;
  color: #083D77;
}

.popup p {
  margin-bottom: 30px;
}

.popup h6 {
  font-size: 20px;
  margin-bottom: 10px;
}


.meals-link {
  display: inline-block;
  margin-top: 20px;
  margin-right: 10px;
  padding: 10px 20px;
  background-color: #083D77;
  color: #EBEBD3;
  border-radius: 5px;
  text-decoration: none;
  text-align: center;
  font-size: 18px;
  font-weight: bold;
  cursor: pointer;
}

.meals-link:hover {
  background-color: #EE964B;
  color: #083D77;
}

.meal-link-container {
  display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
    white-space: nowrap;
}
</style>


