package org.ekondrashova.application.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class LogManager {
    private static LogManager logManager;

    private LogOptions logOptions;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
    private final StandardOpenOption[] openOptions =
            new StandardOpenOption[]{StandardOpenOption.APPEND, StandardOpenOption.CREATE};

    private LogManager() {
    }

    public static LogManager getLogger() {
        if (Objects.isNull(logManager)) {
            logManager = new LogManager();
        }
        return logManager;
    }

    public void setLogOptions(LogOptions logOptions) {
        this.logOptions = logOptions;
    }

    public void trace(String log, Object... args) {
        if (isNeedToLog(LogLevel.TRACE)) {
            log(log, args, LogLevel.TRACE);
        }
    }

    private boolean isNeedToLog(LogLevel level) {
        return logOptions.isEnabled() && level.isNeedToLog(logOptions.getLogLevel());
    }

    public void debug(String log, Object... args) {
        if (isNeedToLog(LogLevel.DEBUG)) {
            log(log, args, LogLevel.DEBUG);
        }
    }

    public void info(String log, Object... args) {
        if (isNeedToLog(LogLevel.INFO)) {
            log(log, args, LogLevel.INFO);
        }
    }

    public void warn(String log, Object... args) {
        if (isNeedToLog(LogLevel.WARN)) {
            log(log, args, LogLevel.WARN);
        }
    }

    public void error(String log, Object... args) {
        if (isNeedToLog(LogLevel.ERROR)) {
            log(log, args, LogLevel.ERROR);
        }
    }

    private void log(String log, Object[] args, LogLevel current) {
        String logMessage = getFormattedLogMessage(log, args, current);
        logToConsole(logMessage);
        logToFile(logMessage);
    }

    private void logToConsole(String logMessage) {
        System.out.println(logMessage);
    }

    private void logToFile(String logMessage) {
        try {
            Files.write(logOptions.getPath(), (logMessage + "\n").getBytes(), openOptions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFormattedLogMessage(String log, Object[] args, LogLevel current) {
        return dateTimeFormatter.format(LocalDateTime.now()) + " -- " +
                current.toString() + " " +
                String.format(log.replace("{}", "%s"), args);
    }
}
