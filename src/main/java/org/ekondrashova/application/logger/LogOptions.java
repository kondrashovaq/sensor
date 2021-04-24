package org.ekondrashova.application.logger;

import java.nio.file.Path;
import java.nio.file.Paths;

public class LogOptions {
    private boolean enabled = true;
    private boolean needLogToFile = true;
    private Path path;
    private LogLevel logLevel = LogLevel.INFO;

    public LogOptions(boolean enabled, boolean needLogToFile, Path path, LogLevel logLevel) {
        this.enabled = enabled;
        this.needLogToFile = needLogToFile;
        this.path = path;
        this.logLevel = logLevel;
    }

    public static OptionsBuilder builder() {
        return new OptionsBuilder();
    }

    public static class OptionsBuilder {
        private boolean enabled = true;
        private boolean needLogToFile = true;
        private Path path;
        private LogLevel logLevel = LogLevel.INFO;

        public OptionsBuilder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public OptionsBuilder needLogToFile(boolean needLogToFile) {
            this.needLogToFile = needLogToFile;
            return this;
        }

        public OptionsBuilder path(String path) {
            this.path = Paths.get(path);
            return this;
        }

        public OptionsBuilder logLevel(LogLevel logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public LogOptions build() {
            return new LogOptions(enabled, needLogToFile, path, logLevel);
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isNeedLogToFile() {
        return needLogToFile;
    }

    public void setNeedLogToFile(boolean needLogToFile) {
        this.needLogToFile = needLogToFile;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
