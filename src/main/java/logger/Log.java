package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Log {

    private static final Logger logger;

    static {
        // Configure the logger (example: setting log level to DEBUG)
        Configurator.setLevel(LogManager.getRootLogger().getName(), org.apache.logging.log4j.Level.DEBUG);

        // Initialize the logger
        logger = getLogger();
    }

    public static Logger getLogger() {
        // Using the stack trace to determine the calling class
        String callingClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        return LogManager.getLogger(callingClassName);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void error(String message, Exception e) {
        logger.error(message, e);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }
}