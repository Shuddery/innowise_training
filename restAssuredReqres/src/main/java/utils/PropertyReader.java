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


    public static String getReqresUrl() {
        return properties.getProperty("reqresUrl");
    }
}