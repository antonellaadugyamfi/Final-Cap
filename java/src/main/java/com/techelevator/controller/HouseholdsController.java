package com.techelevator.controller;

import com.techelevator.dao.HouseholdsDao;
import com.techelevator.model.Households;
import com.techelevator.model.Meals;
import com.techelevator.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class HouseholdsController {
    @Autowired
    private HouseholdsDao householdsDao;

    @RequestMapping(path = "/households", method = RequestMethod.GET)
    public List<Households> getAllHouseholdNames(){
            return householdsDao.getAllHouseholds();
    }

    @RequestMapping(path = "/households/{id}", method = RequestMethod.GET)
    public Households getHouseholdById(@PathVariable int id){
        Households household = householdsDao.getHouseholdById(id);
        return household;
    }

    @RequestMapping(path = "/householdId", method = RequestMethod.GET)
    public Households getHouseholdByUser(Principal principal){
        Households household = householdsDao.getHouseholdIdByUser(principal.getName());
        return household;
    }

    @GetMapping("/members")
    public List<UserDto> getMembersByUsername(Principal principal){
        return householdsDao.getMembersByUsername(principal.getName());
    }

    @RequestMapping(path = "/deleteHousehold/{id}", method = RequestMethod.DELETE)
    public void deleteHousehold(@PathVariable int id){
        householdsDao.deleteHousehold(id);
    }

    @RequestMapping(path = "/resetUsersHousehold", method = RequestMethod.PUT)
    public void resetUsersHousehold(Principal principal){
        householdsDao.resetUserHousehold(principal.getName());
    }

    @RequestMapping(path = "/resetMembersHousehold", method = RequestMethod.PUT)
    public void resetMembersHousehold(@RequestBody UserDto userDto){
        householdsDao.resetAllMembersHousehold(userDto);
    }

    @RequestMapping(path = "/addHousehold", method = RequestMethod.POST)
    public int addHousehold(@RequestBody Households household, Principal principal){
        return householdsDao.addHousehold(household, principal.getName());
    }

    @RequestMapping(path = "/linkOwner", method = RequestMethod.PUT)
    public void linkUserWhenCreatingHousehold(@RequestBody Households household, Principal principal){
        householdsDao.linkUserWhenCreatingHousehold(household, principal.getName());
    }

    @RequestMapping(path = "/editHousehold", method = RequestMethod.PUT)
    public void editHousehold(@RequestBody Households household){
        householdsDao.editHousehold(household);
    }

    @RequestMapping(path = "/joinHousehold", method = RequestMethod.PUT)
    public void joinHousehold(@RequestBody UserDto userDto, Principal principal){
        householdsDao.joinHousehold(userDto, principal.getName());
    }

}
