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

    public static String getBookingUrl() {
        return properties.getProperty("bookingUrl");
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static Integer getTimeoutSeconds() {
        return Integer.valueOf(properties.getProperty("wait.timeout.seconds"));
    }
}