<template>
    <div class="addMeal">
      <h1>Add Meal</h1>
      <add-meal />
    </div>
  </template>
  
  <script>
  import AddMeal from '../components/AddMeal.vue';
  
  
  export default {
    components: {
     
      AddMeal
    }
  };
  </script>
  
  <style>
  .addMeal {
      display: flex;
      flex-direction: column;
      align-items: center;
      height : 100vh;
  } 
  </style>