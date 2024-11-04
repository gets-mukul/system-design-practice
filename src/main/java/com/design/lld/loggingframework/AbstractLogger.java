package com.design.lld.loggingframework;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLoggingLevel;

    void logMessage(int level, String msg, LogSubject logSubject) {
        if (this.level <= level) {
            display(msg, logSubject);
        }
        if (nextLoggingLevel != null) {
            nextLoggingLevel.logMessage(level, msg, logSubject);
        }
    }

    protected abstract void display(String msg, LogSubject logSubject);

}
