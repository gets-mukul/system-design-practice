package com.design.lld.loggingframework;

public class ConsoleLogger implements LogObserver {
    @Override
    public void log(String msg) {
        System.out.println("This is in Console: " + msg);
    }
}
