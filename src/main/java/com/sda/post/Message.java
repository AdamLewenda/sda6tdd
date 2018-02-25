package com.sda.post;

import java.time.Instant;

public class Message {
    private String from;
    private String to;
    private String message;
    private Instant date;
    private boolean deliveryStatus;

    public Message(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.date = Instant.now();
        this.deliveryStatus = false;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }

    public Instant getDate() {
        return date;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
