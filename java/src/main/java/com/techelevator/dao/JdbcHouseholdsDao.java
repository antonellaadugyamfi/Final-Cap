package com.techelevator.dao;

import com.techelevator.model.Households;
import com.techelevator.model.UserDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcHouseholdsDao implements HouseholdsDao {


    private JdbcTemplate template;
    public JdbcHouseholdsDao(DataSource dataSource){
        template = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Households> getAllHouseholds() {
        String sql = "SELECT * FROM households";
        SqlRowSet results = template.queryForRowSet(sql);
        List<Households> listOfNames = new ArrayList<>();
        while(results.next()){
            Households households = new Households();
            households.setHouseholdId(results.getInt("household_id"));
            households.setHouseholdName(results.getString("household_name"));
            households.setHouseholdOwner(results.getString("household_owner"));

            listOfNames.add(households);
        }
        return listOfNames;
    }

    @Override
    public Households getHouseholdById(int id) {
        String sql = "SELECT * FROM households WHERE household_id = ?";
        SqlRowSet result = template.queryForRowSet(sql, id);
        Households household = new Households();
        if (result.next()){
            household.setHouseholdId(result.getInt("household_id"));
            household.setHouseholdName(result.getString("household_name"));
            household.setHouseholdOwner(result.getString("household_owner"));
        }
        return household;
    }

    @Override
    public Households getHouseholdIdByUser(String username) {
        String sql = "SELECT users.household_id, households.household_name, household_owner " +
                "FROM users " +
                "JOIN households ON users.household_id = households.household_id " +
                "WHERE username = ?";
        SqlRowSet result = template.queryForRowSet(sql, username);
        Households household = new Households();
        if (result.next()){
            household.setHouseholdId(result.getInt("household_id"));
            household.setHouseholdName(result.getString("household_name"));
            household.setHouseholdOwner(result.getString("household_owner"));
        }
        return household;
    }

    @Override
    public List<UserDto> getMembersByUsername(String username) { // whats the difference between above
        String sql = "SELECT user_id, username, household_id FROM users WHERE household_id = " +
                "(SELECT households.household_id FROM households " +
                "JOIN users ON users.household_id = households.household_id " +
                "WHERE username LIKE ?);";
        SqlRowSet results = template.queryForRowSet(sql, username);
        List<UserDto> users = new ArrayList<>();
        while(results.next()){
            UserDto user = new UserDto();
            user.setId(results.getInt("user_id"));
            user.setUsername(results.getString("username"));
            user.setHouseholdId(results.getInt("household_id"));

            users.add(user);
        }
        return users;
    }

    @Override
    public void deleteHousehold(int id) {
        String sql = "DELETE FROM meal_plan_data WHERE meal_plan_id IN " +
                "(SELECT meal_plan_id FROM meal_plan WHERE household_id = ?);";
        template.update(sql,id);
        sql = "DELETE FROM meal_plan WHERE household_id = ?;";
        template.update(sql, id);
        sql = "DELETE FROM households WHERE household_id = ?;";
        template.update(sql, id);
    }

    @Override
    public void resetUserHousehold(String username) {
        String sql = "UPDATE users SET household_id = NULL WHERE username = ?;";
        template.update(sql, username);
    }

    @Override
    public void resetAllMembersHousehold(UserDto userDto) {
        String sql = "UPDATE users SET household_id = NULL WHERE household_id = ?;";
        template.update(sql, userDto.getHouseholdId());
    }

    @Override
    public void linkUserWhenCreatingHousehold(Households household, String username) {
        String sql = "UPDATE users SET household_id = ? WHERE username = ?;";
        template.update(sql, household.getHouseholdId(), username);
    }

    @Override
    public int addHousehold(Households households, String username) {
        String sql = "INSERT INTO households (household_name, household_owner) VALUES(?,?) RETURNING household_id;";
        return template.queryForObject(sql, Integer.class, households.getHouseholdName(), username);

    }

    @Override
    public void editHousehold(Households households){
        String sql = "UPDATE households SET household_name = ? WHERE household_id = ?";
        template.update(sql,households.getHouseholdName(), households.getHouseholdId() );
    }

    @Override
    public void joinHousehold(UserDto userDto,String username) {
        String sql = "UPDATE users SET household_id = ? WHERE username = ?;";
        template.update(sql, userDto.getHouseholdId(), username);
    }


}
