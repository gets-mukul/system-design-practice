package com.design.lld.notificationservice;

public class TextMessage extends Notification {
    TextMessage(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is text message");
    }

    @Override
    void sendMessage() {
        notificationSender.sendNotification();
    }
}
