package com.sda.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static int idCounter = 0;
    private String name;
    private UserService userService;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.userService = new UserService();
        this.accounts = new ArrayList<>();
    }

    public int getNumberOfUsers() {
        return userService.getNumberOfUsers();
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

    public List<Account> getAccounts() {
        return accounts;
    }
}
