package io.spring.core.message;

import java.util.UUID;

public class Message {

    private String senderId;
    private String receiverId;
    private String text;
    private String id;

    public Message(String senderId, String receiverId, String text) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.text = text;
        this.id = UUID.randomUUID().toString();
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }
}
