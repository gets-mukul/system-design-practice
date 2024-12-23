package com.design.lld.notificationservice;

public abstract class Notification {
    NotificationSender notificationSender;

    Notification(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    abstract void sendMessage();
}
