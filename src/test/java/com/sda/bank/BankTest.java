package com.sda.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
        Assert.assertEquals("User is not present in bank.", 1, bank.getNumberOfUsers());
    }

    @Test
    public void shouldAddNullUserTest() {
        //given
        User user = null;

        //when
        boolean result = bank.addUser(user);

        //then
        Assert.assertFalse("Method returned true", result);
        Assert.assertEquals("User is present in bank.", 0, bank.getNumberOfUsers());
    }

    @Test
    public void shouldCreateAccountForGivenUserTest() {
        //given
        UserService mockUserService = Mockito.mock(UserService.class);
        AccountService mockAccountService = Mockito.mock(AccountService.class);

        Mockito.when(mockUserService.addUser(Mockito.any(User.class))).thenReturn(true);
        Mockito.when(mockUserService.getNumberOfUsers()).thenReturn(1);
        Mockito.when(mockUserService.isUserPresent(Mockito.any(Integer.class))).thenReturn(true);

        Mockito.when(mockAccountService.addAccount(Mockito.any(Account.class))).thenReturn(true);
        Mockito.when(mockAccountService.getNumberOfAccounts()).thenReturn(1);

        bank.setAccountService(mockAccountService);
        bank.setUserService(mockUserService);

        User user = new User("Adam", "User");
        Account account = new Account(0, 0);

        //when
        boolean userAddResult = bank.addUser(user);
        boolean accountAddResult = bank.createAccount(0, account);

        //then
        Assert.assertTrue("User is not present id bank list.", userAddResult);
        Assert.assertEquals("User is not present in bank list.", 1, bank.getNumberOfUsers());
        Assert.assertTrue("Account is not present in bank list.", accountAddResult);
        Assert.assertEquals("Account is not present in bank list.", 1, bank.getNumberOfAccounts());
    }
}
