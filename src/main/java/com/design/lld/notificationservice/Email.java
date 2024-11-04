package com.design.lld.notificationservice;

public class Email implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("We are sending email notification");
    }
}
