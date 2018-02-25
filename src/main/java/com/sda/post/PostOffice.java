package com.sda.post;

public class PostOffice {

    private SenderService senderService;

    private UserStorage userStorage;

    public PostOffice() {
    }

    public PostOffice(SenderService senderService, UserStorage userStorage) {
        this.senderService = senderService;
        this.userStorage = userStorage;
    }

    public boolean createNewUser(String nickname) {
        return userStorage.createNewUser(nickname);
    }

    public boolean sendNewMessage(String from, String to, String message) {
        return senderService.sendMessage(from, to, message);
    }

    public SenderService getSenderService() {
        return senderService;
    }

    public void setSenderService(SenderService senderService) {
        this.senderService = senderService;
    }

    public UserStorage getUserStorage() {
        return userStorage;
    }

    public void setUserStorage(UserStorage userStorage) {
        this.userStorage = userStorage;
    }
}
