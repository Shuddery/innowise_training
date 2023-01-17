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

    public static String getAmazonUrl() {
        return properties.getProperty("amazonUrl");
    }

    public static String getOnlinerUrl() {
        return properties.getProperty("onlinerUrl");
    }

    public static String getRelaxUrl() {
        return properties.getProperty("relaxUrl");
    }

    public static String getApiVkUrl() {
        return properties.getProperty("apiVkUrl");
    }

    public static String getGoogleTranslateUrl() {
        return properties.getProperty("googleTranslateUrl");
    }

    public static String getAccessToken() {
        return properties.getProperty("access.token");
    }

    public static String getOwnerId() {
        return properties.getProperty("owner.id");
    }

    public static String getApiVersion() {
        return properties.getProperty("api.version");
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static Integer getTimeoutSeconds() {
        return Integer.valueOf(properties.getProperty("wait.timeout.seconds"));
    }
}