package com.correlation.maxim.domain.logging;

/**
 * Created by max on 6/20/17.
 */

public class LoggerBuilder {

    private Logger firstLogger;
    private Logger lastLogger;

    public LoggerBuilder() {
        this.firstLogger = null;
        this.lastLogger = null;
    }

    public LoggerBuilder appendNextLogger(Logger logger){
        if(firstLogger == null){
            firstLogger = logger;
            lastLogger = logger;
        } else {
            lastLogger.nextLogger = logger;
            lastLogger = logger;
        }
        return this;
    }

    public Logger build(){
        return firstLogger;
    }
}
