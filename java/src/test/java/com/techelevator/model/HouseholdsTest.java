package com.techelevator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseholdsTest {

    private Households household;

    @BeforeEach
    void setUp() {
        household = new Households();
    }

    @Test
    void getHouseholdId() {
        household.setHouseholdId(1);
        assertEquals(1, household.getHouseholdId());
    }

    @Test
    void setHouseholdId() {
        household.setHouseholdId(2);
        assertEquals(2, household.getHouseholdId());
    }

    @Test
    void getHouseholdName() {
        household.setHouseholdName("Test Household");
        assertEquals("Test Household", household.getHouseholdName());
    }

    @Test
    void setHouseholdName() {
        household.setHouseholdName("Change Household");
        assertEquals("Change Household", household.getHouseholdName());
    }

    @Test
    void getHouseholdOwner() {
        household.setHouseholdOwner("Owner");
        assertEquals("Owner", household.getHouseholdOwner());
    }

    @Test
    void setHouseholdOwner() {
        household.setHouseholdOwner("Change Owner");
        assertEquals("Change Owner", household.getHouseholdOwner());
    }
}