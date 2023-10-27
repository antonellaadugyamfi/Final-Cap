<template>
  <div class="household-members">
    <div class="members">
      <h1>Household Members</h1>
      <div v-for="member in members" v-bind:key="member.id">
        <h4>{{ member.username }}</h4>
        <h4>{{ member.householdOwner }}</h4>
      </div>
    </div>
  </div>
</template>
  
<script>
import HouseholdService from '../services/HouseholdService';

export default {
  name: "home",
  data() {
    return {
      members: []
    }
  },
  created() {
    HouseholdService.getHouseholdMembers().then((response) => {
      console.log(response.data);
      this.members = response.data;
    });
  },
};
</script>

<style>
.household-members {
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
  
}

.members {
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 5px solid #083D77;
  border-radius: 15px;
  height: 50%;
  padding: 15px;
  overflow-y: auto; /* Add this line */
}

.members h4 {
  font-size: 20px;
}


</style>