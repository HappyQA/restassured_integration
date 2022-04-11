package test.backend.sometests;

import test.common.BaseClass;
import io.restassured.RestAssured;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.*;

import static test.backend.specification.Specifications.*;

public class someTestApi extends BaseClass {

    /**
     * More info with examples:
     * https://testit.software/blog/post/rest-assured-i-postman-dva-podhoda-k-testirovaniyu-api
     */

    @Test
    @DisplayName("GET request on Entity with check status code = 200")
    public void getAllSomething() {
        RestAssured.given()
                .spec(requestSpecification())
                .auth().oauth2(getAccessToken())
                .get("/api/Entity")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
