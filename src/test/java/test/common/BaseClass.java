package test.common;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;


public class BaseClass {

    public static Logger logger = LogManager.getLogger(someClass.class);

    public static ConfigFile cfg = ConfigFactory.create(ConfigFile.class);

    /**
     * Get OAuth 2.0 token, use cfg file with configuration for access via REST API
     * like: grant_type, username, password, scope, token endpoint etc.
     */

    @BeforeClass
    public String getAccessToken() {
        Response resp = RestAssured
                .given()
                .formParam()
                .formParam()
                .formParam()
                .formParam()
                .formParam()
                .formParam()
                .post("");
        logger.info("Accepted access token from Active Directory");
        return resp.jsonPath().get("access_token");
    }
}
