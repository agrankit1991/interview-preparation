package com.learning.patterns.creational.factory;

public class NotificationFactory {
    public static Notification getNotification(NotificationEnum notification) {
        switch (notification) {
            case EMAIL -> {
                return new EmailNotification();
            }
            case SMS -> {
                return new SmsNotification();
            }
            default -> {
                throw new UnsupportedOperationException();
            }
        }
    }
}
