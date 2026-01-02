package com.learning.patterns.creational.factory;

public class App {
    public static void main(String[] args) {
        Notification email = NotificationFactory.getNotification(NotificationEnum.EMAIL);
        email.sendMessage();

        Notification sms = NotificationFactory.getNotification(NotificationEnum.SMS);
        sms.sendMessage();
    }
}
