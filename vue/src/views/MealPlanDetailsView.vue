<template>
    <div class="browseMealPlans">
      <meal-plan-details />
    </div>
  </template>
  
  <script>
  import MealPlanDetails from '../components/MealPlanDetails.vue';
  
  
  export default {
    components: {
     
        MealPlanDetails
    }
  };
  </script>
  
  <style>
    .browseMealPlans {
        display: flex;
        flex-direction: column;
        align-items: center;
        height : 100vh;
    }
  </style>