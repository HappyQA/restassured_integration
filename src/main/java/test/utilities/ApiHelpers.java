package test.utilities;

import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApiHelpers extends Configuration {

    public static CredentialsFile cfg = ConfigFactory.create(CredentialsFile.class);
    public static Logger logger = LogManager.getLogger(ApiHelpers.class);

    public static void doSomething() {
        given()
            .spec(requestSpecification(cfg.user(), cfg.password()))
            .body(someBody)
            .when()
            .post("/api/endpoint")
            .then()
            .statusCode(HttpStatus.SC_OK);
        logger.info("");
    }
}
