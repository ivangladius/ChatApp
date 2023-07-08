package com.example.anonchat;

public class Message {
    private String nickname;
    private String message;

    public Message(String nickname, String message) {
        this.nickname = nickname;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
