<template>
  <div class="addHousehold">
    <form v-on:submit.prevent="runTwoMethods">
      <div>
        <label>Household Name</label>
        <!-- <p>{{ this.household }}</p> -->
        <textarea v-model="household.householdName"></textarea>
      </div>
      <button>Save</button>
    </form>
  </div>
</template>

  <script>
import HouseholdService from "../services/HouseholdService.js";

export default {
  data() {
    return {
      household:{}
    };
  },
  methods: {
    // addHousehold() {
    //   HouseholdService.addHousehold(this.household)
    //     .then((response) => {
    //       if (response.status == 200) {
    //         const generatedHouseholdId = response.data;
    //         this.household.householdId = generatedHouseholdId;
    //         window.alert("Household Added!");
    //         console.log(this.household);
    //       }
    //     })
    //     .catch((error) => {
    //       if (error.response) {
    //         window.alert("Bad Request");
    //       } else if (error.request) {
    //         window.alert("error");
    //       }
    //     });
    // },
    async addHousehold() {
        try {
        const response = await HouseholdService.addHousehold(this.household);
        if (response.status === 200) {
            const generatedHouseholdId = response.data;
            this.household.householdId = generatedHouseholdId;
            console.log(this.household);
        }
        } catch (error) {
        if (error.response) {
            window.alert("Bad Request");
        } else if (error.request) {
            window.alert("Error");
        }
        }
    },
    linkOwner() {
      HouseholdService.linkHouseholdOwner(this.household)
        .then((response) => {
          if (response.status == 200) {
            window.alert("Household Added!");
          }
        })
        .catch((error) => {
          if (error.response) {
            window.alert("Bad Request");
          } else if (error.request) {
            window.alert("error");
          }
        });
    },
    runTwoMethods() {
      this.addHousehold().then(() => this.linkOwner())
      this.$router.push({name: "home"});
    },
  },
};
</script>

  <style>
.addHousehold {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.addHousehold form {  
  display: flex;
  flex-direction: column;
  align-items: center;
}

.addHousehold form input {
  width: 300px;
  height: 30px;
  margin-bottom: 10px;
}

.addHousehold form textarea {
  width: 300px;
  height: 100px;
  margin-bottom: 10px;
}

.addHousehold form button {
  margin-top: 10px;
    width: 30%;
    padding: 5px;
    border-radius: 5px;
    border: 1px solid #083D77;
    background-color: #083D77;
    color: #EBEBD3;
    font-weight: bold;
    margin-bottom: 10px;
}

.addHousehold form button:hover {
  background-color: #EE964B;
    color: #083D77;
}

.addHousehold form label {
  display: flex;
  justify-content: center;
  font-size: 25px;
}


</style>