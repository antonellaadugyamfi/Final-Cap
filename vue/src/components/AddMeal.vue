<template>
  <div class="addMeal">
    <form v-on:submit.prevent="addMeal">
        <label>Meal</label>
        <input v-model="meal.mealName" />
        <label>Meal Description</label>
        <textarea v-model="meal.description"></textarea>
        <label>Meal Ingredients</label>
        <textarea v-model="meal.ingredients"></textarea>
        <label>Meal Instructions</label>
        <textarea v-model="meal.instructions"></textarea>
        <button>Save</button>
    </form>
  </div>
</template>

<script>
import MealService from '../services/MealService'
export default {
    data(){
        return{
            meal: {}
        }
    },
    methods: {
        addMeal(){
            MealService.addMeal(this.meal).then((response) => {
                if(response.status == 200) {
                        window.alert("Meal Added!");
                        this.meal = {};
                        this.$router.push({name: "browseMyMeals"});
                }
            })
            .catch((error) => {
                if (error.response){
                    window.alert("Bad Request");
                }
                else if (error.request){
                    window.alert("error");
                }
            })
        }
    }
}
</script>

<style>
.addMeal form {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.addMeal form input {
    width: 300px;
    height: 30px;
    margin-bottom: 10px;
}

.addMeal form textarea {
    width: 300px;
    height: 100px;
    margin-bottom: 10px;
}

.addMeal form button {
    margin-top: 10px;
    width: 30%;
    padding: 5px;
    border-radius: 5px;
    border: 1px solid #083D77;
    background-color: #083D77;
    color: #EBEBD3;
    font-weight: bold;
}

.addMeal form button:hover {
    background-color: #EE964B;
    color: #083D77;
}

.addMeal form label {
    margin-top: 10px;
}

.addMeal {
    margin: 0 auto;
    width: 75%;
    padding: 10px;
    height: 100vh;
}

.addMeal input {
    margin-top: 5px;
    width: 20%;
    padding: 5px;
    border-radius: 5px;
    border: 1px solid #083D77;
}

.addMeal textarea {
    margin-top: 5px;
    width: 20%;
    padding: 5px;
    border-radius: 5px;
    border: 1px solid #083D77;
}
</style>