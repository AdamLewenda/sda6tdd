package com.sda.bank;

public class Bank {
    private String name;
    private UserService userService;
    private AccountService accountService;

    public Bank(String name) {
        this.name = name;
        this.userService = new UserService();
        this.accountService = new AccountService();
    }

    public boolean createAccount(int userId, Account account) {
        boolean result = false;
        if (userService.isUserPresent(userId)) {
            result = accountService.addAccount(account);
        }
        return result;
    }

    public int getNumberOfUsers() {
        return userService.getNumberOfUsers();
    }

    public int getNumberOfAccounts() {
        return accountService.getNumberOfAccounts();
    }

    public boolean addUser(User user) {
        return userService.addUser(user);
    }

    public String getName() {
        return name;
    }

    public UserService getUserService() {
        return userService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
