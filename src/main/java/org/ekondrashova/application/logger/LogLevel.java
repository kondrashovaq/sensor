package org.ekondrashova.application.logger;

public enum LogLevel {
    TRACE(50),
    DEBUG(40),
    INFO(30),
    WARN(20),
    ERROR(10);

    LogLevel(int order) {
        this.order = order;
    }

    private final int order;

    private int getOrder() {
        return order;
    }

    public boolean isNeedToLog(LogLevel logLevel) {
        return this.getOrder() <= logLevel.getOrder();
    }
}
