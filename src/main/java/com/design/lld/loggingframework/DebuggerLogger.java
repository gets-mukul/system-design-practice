package com.design.lld.loggingframework;

public class DebuggerLogger extends AbstractLogger {
    public DebuggerLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String msg, LogSubject logSubject) {
        String s = "DEBUG: " + msg;
        logSubject.notifyAllObserver(3, s);
    }
}
