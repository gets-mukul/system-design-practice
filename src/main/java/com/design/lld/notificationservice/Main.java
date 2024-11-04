package com.design.lld.notificationservice;

public class Main {
    public static void main(String[] args) {
        TextMessage textMessage = new TextMessage(new Email());
        textMessage.sendMessage();

        QrMessage qrMessage = new QrMessage(new Email());

    }
}
