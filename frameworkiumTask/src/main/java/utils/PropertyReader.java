package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static final Properties properties;
    static {
        properties = new Properties();
        try{
            properties.load(PropertyReader.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getIntelyCareUrl() {
        return properties.getProperty("intelyCareUrl");
    }

    public static String getIntelyCareApiUrl() {
        return properties.getProperty("intelyCareApiUrl");
    }

    public static String getEmail() {
        return properties.getProperty("email");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }
}