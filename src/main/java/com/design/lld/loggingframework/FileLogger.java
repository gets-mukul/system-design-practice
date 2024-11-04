package com.design.lld.loggingframework;

public class FileLogger implements LogObserver {
    @Override
    public void log(String msg) {
        System.out.println("This is in file: " + msg);
    }
}
