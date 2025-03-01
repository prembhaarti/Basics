package jbasic.pattern.chainofresponsibility.v2;

public abstract class Logger {
    protected Logger nextLogger; // Next handler in the chain

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(String message, LogLevel level) {
        if (canHandle(level)) {
            write(message);
        } else if (nextLogger != null) {
            nextLogger.logMessage(message, level);
        }
    }

    protected abstract boolean canHandle(LogLevel level);
    protected abstract void write(String message);
}