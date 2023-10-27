import axios from 'axios';

export default {

    getAllHouseholds(){
        return axios.get("/households");
    },

    getHouseholdById(id){
        return axios.get("/households/" + id);
    },

    getUsersHouseholdId(){
        return axios.get("/householdId");
    },

    getHouseholdMembers(){
        return axios.get("/members");
    },

    resetUsersHousehold(){
        return axios.put("/resetUsersHousehold");
    },
    
    deleteHousehold(id){
        return axios.delete("/deleteHousehold/" + id);
    },

    resetMembersHousehold(householdId){
        return axios.put("/resetMembersHousehold", householdId);
    },

    addHousehold(household){
        return axios.post("/addHousehold", household);
    },

    linkHouseholdOwner(householdId){
        return axios.put("/linkOwner", householdId);
    },

    editHousehold(household){
        return axios.put("/editHousehold", household);
    },

    getHouseholdByOwner(username){
        return axios.get("/createdHousehold" + username);
    },

    joinHousehold(id){
        return axios.put("/joinHousehold", id);
    }

}