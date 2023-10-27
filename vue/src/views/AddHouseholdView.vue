<template>
    <div class="add-household">
      <h1>Add Household</h1>
      <add-household />
    </div>
  </template>
  
  <script>
  
import AddHousehold from '../components/AddHousehold.vue';
  
  
  export default {
    components: {
     
        AddHousehold
    }
  };
  </script>
  
  <style>
  .add-household {
      display: flex;
      flex-direction: column;
      align-items: center;
      height : 100vh;
  }
  </style>