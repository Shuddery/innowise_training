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


    public static String getHerokuAppUrl() {
        return properties.getProperty("herokuAppUrl");
    }

    public static String getChromeBrowser() {
        return properties.getProperty("chrome.browser");
    }

    public static String getOperaBrowser() {
        return properties.getProperty("opera.browser");
    }

    public static String getFirefoxBrowser() {
        return properties.getProperty("firefox.browser");
    }

    public static Integer getTimeoutSeconds() {
        return Integer.valueOf(properties.getProperty("wait.timeout.seconds"));
    }
}