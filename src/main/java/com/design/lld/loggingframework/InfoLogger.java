package com.design.lld.loggingframework;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String msg, LogSubject logSubject) {
        String s = "INFO: " + msg;
        logSubject.notifyAllObserver(1, s);
    }
}
