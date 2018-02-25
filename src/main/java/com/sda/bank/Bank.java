package com.sda.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static int idCounter = 0;
    private String name;
    private List<User> users;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public boolean addUser(User user) {
        boolean result = false;
        if (user != null) {
            user.setId(idCounter++);
            users.add(user);
            result = true;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
