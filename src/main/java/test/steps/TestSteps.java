package steps;

public class TestSteps extends Configuration {

    public static Logger logger = LogManager.getLogger(TestSteps.class);

    /**
     * Create model
     */
    @Step("Create test object")
    public static TestDTO createTestObject() {
        TestDTO td = new TestDTO();
        td.setTitle("");
        td.setBudgetType("");
        td.setLevel1("");
        td.setLevel2("");
        td.setLevel3("");
        td.setCostCenter("");
        td.setYear(2023);
        td.setOwnerId("");
        td.setManagerId("");
        td.setParentManagerId("");
        td.setStatus("");
        td.setPaidMedia(true);
        logger.info("");
        return td;
    }

    /**
     * Reusable CRUD methods
     */
    @Step("Create object")
    public static String createObject(String endpoint, Object bodyPayload) {
        logger.info("Create object: POST '"+ endpoint +"'");
        return given()
                .spec(requestSpecification(cfg.email(), cfg.password()))
                .body(bodyPayload)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .extract().body().as(TestDTO.class).getId();
    }

    @Step("Get object")
    public static <T> T getObject(String endpoint, Class<T> responseClass) {
        logger.info("Get object by Id: GET '"+ endpoint +"'");
        return given()
                .spec(requestSpecification(cfg.godModeEmail(), cfg.godModePassword()))
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract().as(responseClass);
    }

    /**
     * Assertions steps
     */
    @Step("Check if Expected and Actual Object are equals")
    public static void assertEqualsObject(TestDTO expectedObject, TestDTO actualObject) {
        assertEquals(expectedObject.getTitle(), actualObject.getTitle());
        logger.info("Expected object are equals with actual object with Id: {}", actualObject.getId());
    }
}
