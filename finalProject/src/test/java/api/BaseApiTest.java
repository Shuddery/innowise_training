package api;

import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    @BeforeAll()
    public static void init() {
        RestAssured.useRelaxedHTTPSValidation();
        ConnectionConfig.CloseIdleConnectionConfig closeIdleConnectionConfig = new ConnectionConfig.CloseIdleConnectionConfig(600L, TimeUnit.SECONDS);
        RestAssured.config().connectionConfig(ConnectionConfig.connectionConfig().closeIdleConnectionsAfterEachResponseAfter(closeIdleConnectionConfig));
    }
}