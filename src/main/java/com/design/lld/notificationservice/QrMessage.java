package com.design.lld.notificationservice;

public class QrMessage extends Notification {
    QrMessage(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is QR code");
    }

    @Override
    void sendMessage() {
        // call some method to build QR code
        notificationSender.sendNotification();
    }
}
