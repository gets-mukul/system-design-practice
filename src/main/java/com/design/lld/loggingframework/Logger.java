package com.design.lld.loggingframework;

import java.io.Serializable;

import static com.design.lld.loggingframework.LogManager.buildSubject;

public class Logger implements Cloneable, Serializable {
    private volatile static Logger logger;
    private volatile static AbstractLogger chainOfLogger;
    private volatile static LogSubject logSubject;

    private Logger() throws IllegalAccessException {
        if (logger != null) {
            throw new IllegalAccessException("Object already created");
        }
    }

    public static Logger getInstance() throws IllegalAccessException {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                    chainOfLogger = LogManager.buildChainOfLogger();
                    logSubject = buildSubject();
                }
            }
        }
        return logger;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolve() {
        return logger;
    }

    private void createLog(int level, String msg) {
        chainOfLogger.logMessage(level, msg, logSubject);
    }

    public void info(String msg) {
        createLog(1, msg);
    }

    public void error(String msg) {
        createLog(2, msg);
    }

    public void debug(String msg) {
        createLog(3, msg);
    }


}
