package com.sda.post;

import org.junit.Assert;
import org.junit.Test;

public class SenderServiceTest {
    @Test
    public void shouldSendNewMessageSuccessfully() {
        //given
        SenderService senderService = new SenderService();
        String message = "Hello World";
        String from = "qwerty";
        String to = "abc";

        //when
        boolean result = senderService.sendMessage(from, to, message);

        //then
        Assert.assertTrue("Message was not sent", result);

    }
}
