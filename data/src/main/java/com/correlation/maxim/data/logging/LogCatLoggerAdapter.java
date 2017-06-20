package com.correlation.maxim.data.logging;

import android.util.Log;

import com.correlation.maxim.domain.logging.LogLevel;
import com.correlation.maxim.domain.logging.Logger;

/**
 * Created by max on 6/20/17.
 */

public class LogCatLoggerAdapter extends Logger {

    public LogCatLoggerAdapter() {
        super(LogLevel.VERBOSE);
    }

    @Override
    protected void write(LogLevel logLevel, String tag, String message) {
        switch (logLevel) {
            case ERROR:
                Log.e(tag, message);
                break;
            case WARNING:
                Log.w(tag, message);
                break;
            case INFO:
                Log.i(tag, message);
                break;
            case DEBUG:
                Log.d(tag, message);
                break;
            case VERBOSE:
                Log.v(tag, message);
                break;
            default:
                break;
        }
    }
}
