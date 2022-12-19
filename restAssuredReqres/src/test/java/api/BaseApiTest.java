package api;

import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    @BeforeClass(alwaysRun = true)
    public void init() {
        RestAssured.useRelaxedHTTPSValidation();
        ConnectionConfig.CloseIdleConnectionConfig closeIdleConnectionConfig = new ConnectionConfig.CloseIdleConnectionConfig(600L, TimeUnit.SECONDS);
        RestAssured.config().connectionConfig(ConnectionConfig.connectionConfig().closeIdleConnectionsAfterEachResponseAfter(closeIdleConnectionConfig));
    }
}