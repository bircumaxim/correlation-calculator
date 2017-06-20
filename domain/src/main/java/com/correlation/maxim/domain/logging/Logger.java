package com.correlation.maxim.domain.logging;

/**
 * Created by max on 6/20/17.
 */

public abstract class Logger  {
    Logger nextLogger;
    private LogLevel defaultLogLevel;

    public Logger(LogLevel logLevel) {
        this.defaultLogLevel = logLevel;
    }

    void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    private void log(LogLevel logLevel, String tag, String message) {
        if (this.defaultLogLevel.accept(logLevel)) {
            write(logLevel, tag, message);
        }
        if (nextLogger != null) {
            nextLogger.log(logLevel, tag, message);
        }
    }

    protected abstract void write(LogLevel logLevel, String tag, String message);

    public void quite(String tag, String message) {
        log(LogLevel.QUITE, tag, message);
    }

    public void error(String tag, String message) {
        log(LogLevel.ERROR, tag, message);
    }

    public void error(String tag, Exception exception) {
        log(LogLevel.ERROR, tag, exception.getMessage());
    }

    public void warning(String tag, String message) {
        log(LogLevel.WARNING, tag, message);
    }

    public void info(String tag, String message) {
        log(LogLevel.INFO, tag, message);
    }

    public void debug(String tag, String message) {
        log(LogLevel.DEBUG, tag, message);
    }

    public void verbose(String tag, String message) {
        log(LogLevel.VERBOSE, tag, message);
    }
}
