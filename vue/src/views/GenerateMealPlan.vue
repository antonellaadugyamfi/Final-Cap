<template>
    <div class="generateMealPlan">
        <div class="mealPlanForm">
            <h4>Generate Meal Plan</h4>
            <form v-on:submit.prevent="addMealPlan">
                <label>Meal Plan Name</label>
                <input v-model="mealPlan.mealPlanName" />
                <label>Start Date</label>
                <input type="date" v-model="mealPlan.startDate" />
                <label>End Date</label>
                <input type="date" v-model="mealPlan.endDate" />
                <button>Save</button>
            </form>
        </div>
    </div>
</template>
  
<script>
import MealPlansService from '../services/MealPlansService'
import HouseholdService from '../services/HouseholdService';

export default {
    props: ['meal'],
    data() {
        return {
            mealPlan: {
                householdId: -1,
            }
        }
    },
    created() {
        HouseholdService.getUsersHouseholdId().then((response) => {
            console.log(response.data);
            this.mealPlan.householdId = response.data.householdId;
        });
    },
    methods: {
        addMealPlan() {
            MealPlansService.addMealPlan(this.mealPlan).then((response) => {
                if (response.status == 200) {
                    window.alert("Meal Plan Added!");
                    this.mealPlan = {};
                    this.$router.push({ name: "myHousehold" });
                }
            })
                .catch((error) => {
                    if (error.response) {
                        window.alert("Bad Request");
                    }
                    else if (error.request) {
                        window.alert("error");
                    }
                })
        }
    }
}

</script>
  
<style>
.generateMealPlan {
    margin: 0 auto;
    width: 75%;
    padding: 10px;
    border-radius: 5px;
    height: 100vh;
}

.generateMealPlan h4 {
    text-align: center;
}

.generateMealPlan form {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.generateMealPlan label {
    margin-top: 10px;
}

.generateMealPlan input {
    margin-top: 5px;
    width: 20%;
    padding: 5px;
    border-radius: 5px;
    border: 1px solid #083D77;
}

.generateMealPlan button{
    margin-top: 10px;
    width: 10%;
    padding: 5px;
    border-radius: 5px;
    border: 1px solid #083D77;
    background-color: #083D77;
    color: #EBEBD3;
    font-weight: bold;
}

.generateMealPlan button:hover {
    background-color: #EE964B;
    color: #083D77;
    cursor: pointer;
}

</style>