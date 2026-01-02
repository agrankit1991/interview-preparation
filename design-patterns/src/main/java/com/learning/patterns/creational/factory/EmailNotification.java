package com.learning.patterns.creational.factory;

public class EmailNotification implements Notification {
    @Override
    public void sendMessage() {
        System.out.println("Sending Email...");
    }
}
