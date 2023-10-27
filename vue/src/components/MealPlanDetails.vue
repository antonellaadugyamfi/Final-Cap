<template>
  <div class="browseMealPlans">

    <h1>Meal Plan: {{ this.mealPlanName }}</h1>
    <table class="meal-plan-table">
      <thead>
        <tr>
          <th>Date</th>
          <th>Meal Name</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="mealPlan in mealPlans" v-bind:key="mealPlan.mealPlanId">
          <td>{{ mealPlan.plannerDate }}</td>
          <td>{{ mealPlan.mealName }}</td>
          <button v-on:click="selectMealPlan(mealPlan)">Select Meal</button>
        </tr>
      </tbody>
    </table>
    <div v-if="selectMealMenu == true" class="popup">
      <form v-on:submit.prevent="addMealToMealPlan">
        <label>All Meals</label>
        <select v-model="selectedMeal" @change="createMealPlanData(selectedMeal, mealPlan)">
          <option v-for="meal in allMeals" v-bind:key="meal" :value="meal">{{ meal.mealName }}</option>
        </select>
        <button>Save</button>
        <label>My Meals</label>
        <select v-model="selectedMeal" @change="createMealPlanData(selectedMeal, mealPlan)">
          <option v-for="meal in myMeals" v-bind:key="meal" :value="meal">{{ meal.mealName }}</option>
        </select>
        <button>Save</button>
        <button v-on:click="cancelMealMenu">Cancel</button>
      </form>
    </div>

  </div>
</template>
  
<script>
import MealPlansService from '../services/MealPlansService';
import MealService from '../services/MealService';

export default {
  name: "home",
  data() {
    return {
      mealPlans: [],
      allMeals: [],
      myMeals: [],
      mealPlanId: -1,
      mealPlanName: "",
      mealPlanData: {
        mealId: -1,
        mealPlanId: -1,
        plannerDate: "",
      },
      selectedMeal: null,
      selectMealMenu: false,
    }
  },
  created() {
    this.mealPlanId = this.$route.params.id;
    MealPlansService.getMealPlansByMealPlanId(this.mealPlanId).then((response) => {
      this.mealPlans = response.data;
      this.mealPlans.forEach(mealPlan => {
        this.mealPlanName = mealPlan.mealPlanName;
      });
    });
    MealService.getAllMeals().then((response) => {
      this.allMeals = response.data;
    });
    MealService.getUsersMeal().then((response) => {
      this.myMeals = response.data;
    });
    MealService.getMealById(this.selectedMealId).then((response) => {
      this.mealName = response.data.mealName;
    });
  },
  methods: {
    addMealToMealPlan() {
      console.log(this.mealPlanData);
      MealPlansService.addMealToMealPlan(this.mealPlanData).then((response) => {
        if (response.status == 200) {
          window.alert("Meal added to meal plan!");
          window.location.reload();
        }
      }).catch((error) => {
        if (error.response) {
          window.alert("Bad Request");
        }
        else if (error.request) {
          window.alert("error");
        }
      })
    },
    createMealPlanData(selectedMeal) {
      this.mealPlanData.mealId = selectedMeal.mealId;
    },
    selectMealPlan(mealPlan) {
      this.mealPlanData.mealPlanId = mealPlan.mealPlanId;
      this.mealPlanData.plannerDate = mealPlan.plannerDate;
      this.selectMealMenu = true;
    },
    cancelMealMenu() {
      this.selectMealMenu = false;
    }
  }
};
</script>

<style>
.browserMealPlans {
  height: 100vh;
  background-color: #EBEBD3;
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

.popup form {
  display: flex;
  flex-direction: column;
}

.popup label {
  margin: 15px;
  display: flex;  
  justify-content: center;
  font-size: 25px;
}

.popup select {
  width: 100%;
  padding: 5px;
  margin-bottom: 10px;
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
}

.popup button:hover {
  background-color: #EE964B;
  color: #083D77;
}

.meal-plan-table {
  margin: 0 auto;
  width: 100%;
  
}

.meal-plan-table th {
  background-color: #083D77;
  color: #EBEBD3;
  padding: 10px;
}

.meal-plan-table td {
  background-color: #EBEBD3;
  color: #083D77;
  padding: 10px;
}

.meal-plan-table button {
  background-color: #083D77;
  color: #EBEBD3;
  padding: 10px;
  border-radius: 5px;
  border: none;
}

.meal-plan-table button:hover {
  background-color: #EE964B;
  color: #083D77;
}
</style>