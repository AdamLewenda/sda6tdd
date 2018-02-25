package com.sda.bank;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static int idCounter = 0;
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public int getNumberOfUsers(){
        return users.size();
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
}
