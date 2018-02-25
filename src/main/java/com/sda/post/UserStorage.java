package com.sda.post;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private List<String> users;

    public UserStorage() {
        this.users = new ArrayList<>();
    }

    public boolean createNewUser(String nickname) {
        return users.add(nickname);
    }

    public boolean isUserPresent(String nickname) {
        return users.contains(nickname);
    }
}
