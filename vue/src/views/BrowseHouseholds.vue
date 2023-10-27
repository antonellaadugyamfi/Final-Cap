<template>
    <div class="browseHousehold">
      <h1>Browse Households</h1>
      <div  class="household-link-container">
        <router-link class="household-link" v-bind:to="{ name: 'myHousehold' }">Create Household</router-link>
      </div>

      <div class="household-container">
        <div class="household-card" v-for="household in households" v-bind:key="household.householdId">
          <h2>{{ household.householdName }}</h2>
          <h4>Household Owner: {{ household.householdOwner }}</h4>
          <button @click="joinHousehold(household.householdId)">Join Household</button>
      </div>
      
        
      </div>
    </div>
  </template>
  
  <script>
  import HouseholdService from '../services/HouseholdService';
  
  export default {
    name: "home",
    data(){
      return{
        households: [],
        household:{}
      }
    },
    created(){
      HouseholdService.getAllHouseholds().then((response) => {
        this.households = response.data;
      })
    },
    methods: {
            joinHousehold(householdId){
                this.household.householdId = householdId;
                HouseholdService.joinHousehold(this.household).then(response => {
                    if(response.status === 200){
                        window.alert("Household joined!");
                        this.$router.push({name: "myHousehold"});
                    }
                })
            }
        },
  };
  </script>
  <style scoped>
  .browseHousehold {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
}

.household-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
  width: 75%;
}

.household-card {
  margin-top: 10px;
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

.household-card button {
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

.household-card button:hover {
  background-color: #EE964B;
  color: #083D77;
}

.household-link {
  display: inline-block;
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

.household-link:hover {
  background-color: #EE964B;
  color: #083D77;
}

  </style>