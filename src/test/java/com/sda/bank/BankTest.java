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

    @Test
    public void shouldNotCreateAccountForNotExistingUserTest() {

        //given
        Account account = new Account(10, 0);
        UserService mockUserService = Mockito.mock(UserService.class);
        AccountService mockAccountService = Mockito.mock(AccountService.class);

        Mockito.when(mockUserService.isUserPresent(Mockito.any(Integer.class))).thenReturn(false);

        Mockito.when(mockAccountService.addAccount(Mockito.any(Account.class))).thenReturn(false);
        Mockito.when(mockAccountService.getNumberOfAccounts()).thenReturn(0);

        bank.setUserService(mockUserService);
        bank.setAccountService(mockAccountService);

        //when
        boolean result = bank.createAccount(10, account);

        //then
        Assert.assertFalse("Account is created.", result);
        Assert.assertEquals("Account is present.", 0, bank.getNumberOfAccounts());
    }

    @Test
    public void shouldUpdateAccountAmountTest() {
        //given
        User user = new User("Adam", "User");
        Account account = new Account(0, 100);
        UserService mockUserService = Mockito.mock(UserService.class);
        AccountService mockAccountService = Mockito.mock(AccountService.class);

        Mockito.when(mockUserService.addUser(Mockito.any(User.class))).thenReturn(true);
        Mockito.when(mockUserService.isUserPresent(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockUserService.getNumberOfUsers()).thenReturn(1);
        Mockito.when(mockAccountService.addAccount(Mockito.any(Account.class))).thenReturn(true);
        Mockito.when(mockAccountService.isAccountPresent(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockAccountService.getNumberOfAccounts()).thenReturn(1);
        Mockito.when(mockAccountService.getAccount(Mockito.anyInt())).thenReturn(new Account(0, 200));

        bank.setAccountService(mockAccountService);
        bank.setUserService(mockUserService);

        //when
        boolean userAddResult = bank.addUser(user);
        boolean accountAddResult = bank.createAccount(0, account);
        boolean changeAmountResult = bank.changeAmount(account, 100);

        //then
        Assert.assertTrue("User is not present", userAddResult);
        Assert.assertEquals("User is not present", 1, bank.getNumberOfUsers());

        Assert.assertTrue("Account is not present", accountAddResult);
        Assert.assertEquals("Account is not present", 1, bank.getNumberOfAccounts());

        Assert.assertTrue("Change amount action failed", changeAmountResult);
        Assert.assertEquals("Amount of account is not valid", 200, bank.getAccount(0).getAmount());
    }
}
