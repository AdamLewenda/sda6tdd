package com.sda.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

    private Bank bank;

    @Before
    public void init() {
        this.bank = new Bank("test");
    }

    @Test
    public void shouldAddNewUserTest() {
        //given
        User user = new User("Adam", "User");

        //when
        boolean result = bank.addUser(user);

        //then
        Assert.assertTrue("Method returned false", result);
        Assert.assertEquals("User is not present in bank.", 1, bank.getUsers().size());
    }

    @Test
    public void shouldAddNullUser() {
        //given
        User user = null;

        //when
        boolean result = bank.addUser(user);

        //then
        Assert.assertFalse("Method returned true", result);
        Assert.assertEquals("User is present in bank.", 0, bank.getUsers().size());
    }
}
