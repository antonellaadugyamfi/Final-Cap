<template>
    <div class="editMeal">
        <h2>Edit Meal</h2>
        <form v-on:submit.prevent="editMeal">
            <label>Meal Name</label>
            <input v-model="mealInfo.mealName" />
            <label>Meal Description</label>
            <textarea v-model="mealInfo.description"></textarea>
            <label>Meal Ingredients</label>
            <textarea v-model="mealInfo.ingredients"></textarea>
            <label>Meal Instructions</label>
            <textarea v-model="mealInfo.instructions"></textarea>
            <button>Save</button>
        </form>
    </div>
</template>
  
<script>
import MealService from '../services/MealService'

export default {
    props: ['meal'],
    data() {
        return {
            mealId: -1,
            mealInfo: this.meal
        }
    },
    methods: {
        editMeal() {
            MealService.editMeal(this.mealInfo).then((response) => {
                if (response.status == 200) {
                    window.alert("Meal updated!");
                    window.location.reload();
                }
            });
        }
    }
}

</script>
  
<style>
.editMeal {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.editMeal form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.editMeal form input {
    width: 300px;
    height: 30px;
    margin-bottom: 10px;
}

.editMeal form textarea {
    width: 350px;
    height: 100px;
    margin-bottom: 10px;
}

.editMeal form button {
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

.editMeal form button:hover {
  background-color: #EE964B;
  color: #083D77;
}

.editMeal form label {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 10px;
}
</style>