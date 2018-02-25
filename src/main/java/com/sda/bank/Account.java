package com.sda.bank;

public class Account {

    private int userId;

    private int amount;

    public Account(int userId, int amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public Account() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
