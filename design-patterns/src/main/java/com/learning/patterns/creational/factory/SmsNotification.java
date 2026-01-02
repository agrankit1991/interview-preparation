package com.learning.patterns.creational.factory;

public class SmsNotification implements Notification {
    @Override
    public void sendMessage() {
        System.out.println("Sending SMS...");
    }
}
