package jbasic.pattern.chainofresponsibility.v2;

public class DebugLogger extends Logger {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.DEBUG;
    }

    @Override
    protected void write(String message) {
        System.out.println("[DEBUG] " + message);
    }
}