package com.vikingz.campustycoon.headless.Game.GameLogic;


import com.vikingz.campustycoon.Game.GameLogic.MoneyHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


public class MoneyHandlerTest {
    

    @BeforeEach
    public void setup(){
        MoneyHandler.resetBank();   
    }
    @Test
    public void testAddMoneyPositive() {
        assertTrue(MoneyHandler.addMoney(500));
        assertEquals(1500, MoneyHandler.getMoney());
    }
    @Test
    public void testAddMoneyNegative() {
        MoneyHandler.addMoney(-500);
        assertEquals(500, MoneyHandler.getMoney());
    }
    @Test
    public void testAddMoneyInsufficientFunds() {
        assertFalse(MoneyHandler.addMoney(-1500));
        assertEquals(1000, MoneyHandler.getMoney());
    }
    @Test
    public void testGetMoney() {
        assertEquals(1000, MoneyHandler.getMoney());
    }
    @Test
    public void testUpdate() {
        MoneyHandler.update(5f);
        assertEquals(1000, MoneyHandler.getMoney());
    }

    @Test
    public void testSpend(){
        MoneyHandler.spendMoney(400);
        assertEquals(600, MoneyHandler.getMoney());

    }

}

