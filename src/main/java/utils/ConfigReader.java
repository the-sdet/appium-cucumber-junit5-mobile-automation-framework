package utils;

import lombok.Getter;

import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read configuration properties.
 * It loads properties from files: config.properties, android-config.properties, ios-config.properties.
 * Provides methods to access specific properties.
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@SuppressWarnings("unused")
public class ConfigReader {

    @Getter
    static Properties properties, androidProperties, iosProperties;

    static {
        properties = new Properties();
        androidProperties = new Properties();
        iosProperties = new Properties();
        try {
            properties.load(ConfigReader.class.getClassLoader().getResourceAsStream("config.properties"));
            androidProperties.load(ConfigReader.class.getClassLoader().getResourceAsStream("android-config.properties"));
            iosProperties.load(ConfigReader.class.getClassLoader().getResourceAsStream("ios-config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the value of a property from a specified configuration file.
     *
     * @param configFileName The name of the configuration file.
     * @param propertyName   The name of the property.
     * @return The value of the property.
     */
    public static String getProperty(String configFileName, String propertyName) {
        Properties properties = new Properties();
        try {
            properties.load(ConfigReader.class.getClassLoader().getResourceAsStream(configFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(propertyName);
    }
}