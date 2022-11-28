package utils;

import com.github.hardnorth.common.config.ConfigLoader;
import com.github.hardnorth.common.config.ConfigProvider;

public class EnvironmentConfig {

    public static final String herokuAppUrl;
    public static final String onlinerUrl;
    public static final int waitTimeoutSeconds;

    private static final ConfigProvider PROVIDER = new ConfigLoader().get();

    static {
        herokuAppUrl = PROVIDER.getProperty("herokuAppUrl", String.class);
        onlinerUrl = PROVIDER.getProperty("onlinerUrl", String.class);

        waitTimeoutSeconds = PROVIDER.getProperty("wait.timeout.seconds", Integer.class);
    }
}