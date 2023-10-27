<template>
  <div>
    <div class="myHoushold" v-if="household.householdId != 0">
      <div class="household-name">
        <h1>{{ householdName }}</h1>
      </div>
      <div class="editMenu">
        <button class="my-household-button" v-on:click="toggleEditMenu">Edit Household Name</button>
      </div>
      <div class="popup" v-if="this.editMenu == true">
        <form v-on:submit.prevent="editHousehold">
          <label>Household</label>
          <input v-model="household.householdName" />
          <div class="button-container">
            <button>Save</button>
            <button v-on:click="toggleEditMenu">Cancel</button>
          </div>
          
        </form>
      </div>

      <div class="household-buttons">
        <button class="my-household-button" v-on:click="leaveHousehold">Leave Household</button>
        <button class="my-household-button" v-on:click="deleteHousehold">Delete Household</button>
      </div>

      <div class="household-components">
        <household-members />
        <browse-meal-plans />
      </div>

    </div>
    <div class="add-household" v-else>
      <h1>Create Household</h1>
      <add-household />
      <div class="browse-households-link">
        <router-link v-bind:to="{ name: 'browseHouseholds' }"> Browse Household </router-link>
      </div>
    </div>
  </div>
</template>
  
<script>
import AddHousehold from '../components/AddHousehold.vue';
import HouseholdMembers from '../components/HouseholdMembers.vue';
import HouseholdService from '../services/HouseholdService';
import BrowseMealPlans from '../views/BrowseMealPlans.vue';

export default {
  components: {
    HouseholdMembers,
    AddHousehold,
    BrowseMealPlans
  },
  data() {
    return {
      household: {},
      editMenu: false,
      householdName: ""
    }
  },
  created() {

    HouseholdService.getUsersHouseholdId().then((response) => {
      console.log(response.data);
      this.household = response.data;
      this.householdName = response.data.householdName;
    });
  },
  methods: {
    leaveHousehold() {
      if (confirm("Are you sure you want to leave this household?")) {
        HouseholdService.resetUsersHousehold().then((response) => {
          if (response.status == 200) {
            window.alert("Left Household");
            window.location.reload();
          }
        }).catch((error) => {
          if (error.response) {
            window.alert("Bad Request");
          }
          else if (error.request) {
            window.alert("error");
          }
        })
      }
    },
    deleteHousehold() {
      if (confirm("Are you sure you want to delete this household?")) {
        HouseholdService.resetMembersHousehold(this.household).then((response) => {
          console.log(this.household);
          HouseholdService.deleteHousehold(this.household.householdId);
          if (response.status == 200) {
            window.alert("Household Deleted");
            window.location.reload();
          }
        }).catch((error) => {
          if (error.response) {
            window.alert("Bad Request");
          }
          else if (error.request) {
            window.alert("error");
          }
        })
      }
    },
    editHousehold() {
      HouseholdService.editHousehold(this.household).then((response) => {
        if (response.status == 200) {
          window.alert("Household updated!");
          window.location.reload();
        }
      })
    },
    toggleEditMenu() {
      this.editMenu = !this.editMenu;
    },
  
  }
};

</script>
  
<style scoped>
.myHousehold {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

.household-name {
  margin-bottom: 10px;
  display: flex;
  justify-content: center;
}

.editMenu {
  margin-bottom: 10px;
  display: flex;
  justify-content: center;
}

/* .button-container {
    display: flex;
    justify-content: space-between;
    margin: 0 auto;
} */

.button-container button {
  margin-top: 10px;
  display: inline-block;
  margin-top: 20px;
  margin-right: 10px;
  padding: 10px 15px;
  color: #083D77;
  border-radius: 5px;
  text-decoration: none;
  text-align: center;
  font-size: 18px;
  font-weight: bold;
  cursor: pointer;
  background-color: #EBEBD3;
  width: 50%;
  margin: 0 auto;;
}

.popup {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: #fff;
  padding: 15px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  z-index: 999;
  display: flex;
  flex-direction: column;
  width: 30%;
}



form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

label {
  margin-bottom: 10px;
}

input {
  width: 100%;
  padding: 5px;
  margin-bottom: 10px;
}

.household-components {
  display: flex;
  width: 100%;
  justify-content: space-evenly;

}

.my-household-button {
  width: 30%;
  padding: 5px;
  border-radius: 5px;
  border: 1px solid #083D77;
  background-color: #083D77;
  color: #EBEBD3;
  font-weight: bold;
}

button:hover {
  background-color: #EE964B;
  color: #083D77;
}

.household-buttons {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  margin-top: 10px;
  padding: 10px;
  margin-bottom: 20px;
}

.household-buttons button {
  margin: 0 10px;
}

.add-household {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
}

.browse-households-link {
  margin-top: 10px;
}

.browse-households-link a {
  margin-top: 10px;
  width: 10%;
  padding: 5px;
  border-radius: 5px;
  border: 1px solid #083D77;
  background-color: #083D77;
  color: #EBEBD3;
  font-weight: bold;
  text-decoration: none;
}

.browse-households-link a:hover {
  background-color: #EE964B;
  color: #083D77;
}
</style>