package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * Class to handle Logging
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@SuppressWarnings("unused")
public class Log {

    private static final Logger logger;

    static {
        // Configure the logger (example: setting log level to DEBUG)
        Configurator.setLevel(LogManager.getRootLogger().getName(), org.apache.logging.log4j.Level.DEBUG);

        // Initialize the logger
        logger = getLogger();
    }

    /**
     * Get the logger for the calling class.
     *
     * @return the logger object
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static Logger getLogger() {
        // Using the stack trace to determine the calling class
        String callingClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        return LogManager.getLogger(callingClassName);
    }

    /**
     * Log an informational message.
     *
     * @param message the message to log
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void info(String message) {
        logger.info(message);
    }

    /**
     * Log an error message.
     *
     * @param message the error message to log
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void error(String message) {
        logger.error(message);
    }

    /**
     * Log an error message with an exception.
     *
     * @param message the error message to log
     * @param e       the exception to log with the error message
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void error(String message, Exception e) {
        logger.error(message, e);
    }

    /**
     * Log a debug message.
     *
     * @param message the debug message to log
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void debug(String message) {
        logger.debug(message);
    }

    /**
     * Log a warning message.
     *
     * @param message the warning message to log
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void warn(String message) {
        logger.warn(message);
    }
}