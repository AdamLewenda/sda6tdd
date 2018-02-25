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
    private boolean sendNewMessageResult;

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

    @And("^I mock senderService to return (.*) when sendMessage method called$")
    public void I_mock_senderService_to_return_value_when_sendMessage_method_called(String value) {
        SenderService senderService = Mockito.mock(SenderService.class);
        Mockito.when(senderService.sendMessage(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(Boolean.valueOf(value));
        postOffice.setSenderService(senderService);
    }


    @When("^I create new user with nickname (.*)$")
    public void I_create_new_user_with_nickname_nickname(String nickname) {
        createUserResult = postOffice.createNewUser(nickname);
    }

    @And("^I send new message (.*) from (.*) to (.*)$")
    public void I_send_new_message_message_from_from_to_to(String message, String from, String to) {
        sendNewMessageResult = postOffice.sendNewMessage(from, to, message);
    }

    @Then("^User with nickname (.*) is present$")
    public void User_with_nickname_nickname_is_present(String nickname) {
        Assert.assertTrue("User is not present.", createUserResult);
    }

    @And("^Message (.*) from (.*) is sent to (.*)$")
    public void Message_message_from_from_is_sent_to_to(String message, String from, String to) {
        Assert.assertTrue("Message is not present.", sendNewMessageResult);
    }
}
