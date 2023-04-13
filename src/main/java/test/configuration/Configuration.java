package configuration;

import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Configuration {

    public static CredentialsFile cfg = ConfigFactory.create(CredentialsFile.class);
    public static Logger logger = LogManager.getLogger(Configuration.class);

    public static String getAccessTokenForUser(String user, String password) {
        Response response = given()
                .formParam("client_id", "")
                .formParam("client_secret", cfg.clientSecret())
                .formParam("grant_type", "password")
                .formParam("username", user)
                .formParam("password", password)
                .formParam("scope", "")
                .post("");
        return response.jsonPath().get("access_token");
    }

    public static RequestSpecification requestSpecification(String user, String password) {
        return new RequestSpecBuilder()
                .setAuth(oauth2(getAccessTokenForUser(user, password)))
                .setBaseUri("baseUrl")
                .setRelaxedHTTPSValidation()
                .setContentType(JSON)
                .setAccept(JSON)
                .addFilter(new AllureRestAssured())
                /*
                 * for check Request body
                 * .addFilter(new RequestLoggingFilter())
                 */
                .build();
    }

    public static ResponseSpecification responseSpecificationScOk() {
        return new ResponseSpecBuilder()
                .log(LogDetail.STATUS)
                .expectContentType(JSON)
                .expectStatusCode(HttpStatus.SC_OK)
                .expectResponseTime(lessThanOrEqualTo(5L), SECONDS)
                .build();
    }
}
