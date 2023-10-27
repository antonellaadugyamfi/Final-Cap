package com.techelevator.dao;

import com.techelevator.model.Households;
import com.techelevator.model.UserDto;

import java.security.Principal;
import java.util.List;

public interface HouseholdsDao {

    public List<Households> getAllHouseholds();
    public Households getHouseholdById(int id);
    public List<UserDto> getMembersByUsername(String username);
    public Households getHouseholdIdByUser(String username);
    public void deleteHousehold(int id);
    public int addHousehold(Households household, String username);
    public void editHousehold(Households household);
    public void resetUserHousehold(String username);
    public void resetAllMembersHousehold(UserDto userDto);
    public void linkUserWhenCreatingHousehold(Households household, String username);
    public void joinHousehold(UserDto userDto, String username);

}
