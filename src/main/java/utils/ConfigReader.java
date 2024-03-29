package utils;

import lombok.Getter;

import java.io.IOException;
import java.util.Properties;

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