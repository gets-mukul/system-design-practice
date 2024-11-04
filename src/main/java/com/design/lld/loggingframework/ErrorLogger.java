package com.design.lld.loggingframework;

public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }
    @Override
    protected void display(String msg, LogSubject logSubject) {
        String s = "ERROR: " + msg;
        logSubject.notifyAllObserver(2, s);
    }
}
