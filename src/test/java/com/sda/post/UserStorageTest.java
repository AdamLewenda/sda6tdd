package com.sda.post;

import org.junit.Assert;
import org.junit.Test;

public class UserStorageTest {

    @Test
    public void shouldCreateNewUserWithGivenName() {
        //given
        UserStorage userStorage = new UserStorage();
        String nickname = "qwerty";

        //when
        boolean createNewUserResult = userStorage.createNewUser(nickname);

        //then
        Assert.assertTrue("User was not created.", createNewUserResult);
        Assert.assertTrue("User was not created", userStorage.isUserPresent(nickname));
    }
}
