package jbasic.pattern.chainofresponsibility.v2;

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // Creating loggers
        Logger infoLogger = new InfoLogger();
        Logger debugLogger = new DebugLogger();
        Logger errorLogger = new ErrorLogger();

        // Setting up the chain
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        // Processing logs
        infoLogger.logMessage("This is an INFO message.", LogLevel.INFO);
        infoLogger.logMessage("This is a DEBUG message.", LogLevel.DEBUG);
        infoLogger.logMessage("This is an ERROR message.", LogLevel.ERROR);
    }
}