<template>
  <div id="app">
    <div id="nav">
      <div class="nav-left">
        <router-link v-bind:to="{ name: 'home' }">
          <div class="logoContainer">
            <img src="./assets/HouseMatesBeige.png" alt="Default Image" class="beigeLogo">
            <img src="./assets/HouseMatesOrange.png" alt="Hover Image" class="orangeLogo">
          </div>
        </router-link>
        <router-link class="nav-link" v-if="$store.state.token != ''" v-bind:to="{ name: 'myHousehold' }">My
          Household</router-link>
        <router-link class="nav-link" v-if="$store.state.token != ''" v-bind:to="{ name: 'browseMyMeals' }">My Meals</router-link>
        <router-link class="nav-link" v-if="$store.state.token != ''" v-bind:to="{ name: 'generateMealPlan' }">Generate
          Meal Plan</router-link>
      </div>
      <div class="nav-right">
        <router-link class="nav-link" v-bind:to="{ name: 'register' }"
          v-if="$store.state.token == ''">Register</router-link>
        <router-link class="nav-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Log In</router-link>
        <router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Log Out</router-link>
      </div>
    </div>
    <router-view class="content" />
  </div>
</template>
  
<script>
import HouseholdService from "./services/HouseholdService";

export default ({
  data() {
    return {
      household: {}
    }
  },
  created() {
    HouseholdService.getUsersHouseholdId().then((response) => {
      console.log(response.data);
      this.household = response.data;
    });

  },
})
</script>
  
<style>

#app {
  margin-top: 0;
  background-color: #EBEBD3;
}

#nav {
  padding: 30px;
  background-color: #083D77;
  color: #EBEBD3;
  display: flex;
  justify-content: space-between;
}

.nav-left {
  display: flex;
  justify-content: flex-start;
}

.nav-right {
  display: flex;
  justify-content: flex-end;
}

#nav .nav-link {
  margin-right: 20px;
  color: #083D77;
  text-decoration: none;
  font-size: 18px;
  padding: 10px;
  border: 5px solid #083D77;
  border-radius: 15px;
  display: flex;
  align-items: center;
  background-color: #EBEBD3;
}

#nav .nav-link:hover {
  color: #EE964B;
  border: 5px solid #EE964B;
  background-color: #083D77;
}

.logoContainer {
  position: relative;
  width: 75px;
  height: 75px;
}

.beigeLogo {
  width: 75px;
  height: 75px;
  margin-right: 20px;

}

.beigeLogo:hover+.orangeLogo {
  display: block;
}

.orangeLogo {
  display: none;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
</style>