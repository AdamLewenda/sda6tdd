package com.sda.post;

import java.util.ArrayList;
import java.util.List;

public class SenderService {

    private List<Message> messages;

    public SenderService() {
        this.messages = new ArrayList<>();
    }

    public boolean sendMessage(String from, String to, String message) {
        Message messageObject = new Message(from, to, message);
        return messages.add(messageObject);

    }
}
