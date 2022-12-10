package utils;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static Properties getProperties() {
        Properties profileProperties = new Properties();
        try {
            profileProperties.load(TestProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profileProperties;
    }

    public static String getChromeBrowser() {
        return getProperties().getProperty("browser.chrome");
    }

    public static Integer getTimeoutSeconds() {
        return Integer.valueOf(getProperties().getProperty("wait.timeout.seconds"));
    }
}