package com.sda.post;

import com.sda.bank.UserService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.mockito.Mockito;

public class PostOfficeSteps {

    private PostOffice postOffice;
    private boolean createUserResult;

    @Given("^I instantiate PostOffice$")
    public void I_instantiate_PostOffice() {
        postOffice = new PostOffice();
    }

    @And("^I mock userStorage to return (.*) when createUser method called$")
    public void I_mock_userStorage_to_return_value_when_createUser_method_called(String value) {
        UserStorage mockUserStorage = Mockito.mock(UserStorage.class);
        Mockito.when(mockUserStorage.createNewUser(Mockito.anyString())).thenReturn(Boolean.valueOf(value));
        postOffice.setUserStorage(mockUserStorage);
    }

    @When("^I create new user with nickname (.*)$")
    public void I_create_new_user_with_nickname_nickname(String nickname) {
        createUserResult = postOffice.createNewUser(nickname);
    }

    @Then("^User with nickname (.*) is present$")
    public void User_with_nickname_nickname_is_present(String nickname) {
        Assert.assertTrue("User is not present.", createUserResult);

    }
}
