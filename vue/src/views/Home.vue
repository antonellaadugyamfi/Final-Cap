<template>
  <div class="home">
    <img class="blueLogo" src="../assets/HouseMatesBlue.png" alt="Blue HouseMates Logo">
    <h1>Welcome to Housemates</h1>
    <h3>Meal Planning for Mixed Households</h3>
    <div>
        <router-link class="home-page-link" v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link class="home-page-link" v-bind:to="{ name: 'browseMeals' }">Browse Meals</router-link>
    </div>
  </div>
</template>
<script>

</script>


<style scoped>
.home {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.home-page-link {
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

.home-page-link:hover {
  background-color: #EE964B;
  color: #083D77;
}

.blueLogo {
  width: 300px;
  height: 300px;
  margin-bottom: 20px;
}

.home h1 {
  margin-bottom: 10px;
  font-size: 45px;
}

.home h3 {
  margin-bottom: 20px;
  font-size: 20px;
}
</style>