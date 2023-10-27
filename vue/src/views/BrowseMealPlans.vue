<template>
  <div class="browseMealPlans">

    <div class="mealPlans">
      <h1>Browse Meal Plans</h1>
      
      <div >
        <router-link class="generateMealPlan" :to="{ name: 'generateMealPlan' }">Add Meal Plan</router-link>
      </div>
      <div class="mealPlanDetails" v-for="mealPlan in mealPlanNames" :key="mealPlan.mealPlanId">

        <router-link :to="{ name: 'mealPlanDetails', params: { id: mealPlan.mealPlanId } }">
          {{ mealPlan.mealPlanName }}</router-link>
      </div>
      
    </div>

  </div>
</template>
  
<script>
import MealPlansService from '../services/MealPlansService';
import HouseholdService from '../services/HouseholdService';

export default {
  name: "browse-meal-plans",
  data() {
    return {
      mealPlanNames: [],
    }
  },
  async created() {
    const response = await HouseholdService.getUsersHouseholdId();
    const mealPlanResponse = await MealPlansService.getAllMealPlanNames(response.data.householdId);
    this.mealPlanNames = mealPlanResponse.data;
  },
};
</script>

<style scoped>
.mealPlans {
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 5px solid #083D77;
  border-radius: 15px;
  height: 50%;
  padding: 15px;
  width: 100%;
  overflow-y: auto;
}

.browseMealPlans {
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
}

.browseMealPlans table {
  width: 50%;
}

.browseMealPlans button {
  width: 10%;
}

.browseMealPlans h1 {
  margin-bottom: 20px;
}

.mealPlanDetails {
  display: flex;
  justify-content: center;
  width: 100%;
}

.mealPlanDetails a {
  margin-top: 10px;
  width: 50%;
  padding: 5px;
  border-radius: 5px;
  border: 1px solid #083D77;
  background-color: #083D77;
  color: #EBEBD3;
  font-weight: bold;
  text-decoration: none;
}

.mealPlanDetails a:hover {
  background-color: #EE964B;
  color: #083D77;
}

.generateMealPlan {
  margin-top: 10px;
  width: 50%;
  padding: 5px;
  border-radius: 20px;
  border: 1px solid #083D77;
  background-color: #EBEBD3;
  color: #083D77;
  font-weight: bold;
  text-decoration: none;
  margin-bottom: 10px;
}

.generateMealPlan:hover {
  background-color: #EE964B;
  color: #083D77;
}

</style>