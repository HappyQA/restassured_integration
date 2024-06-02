package test.api;

@Tag("Test-API")
@Epic("API section / API CRUD")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SomeAPITest extends Configuration {

    @Test
    @DisplayName("Test Case - 1: Create Object")
    public void createObject() {
        TestDTO newTestObject = createTestObject();
        String creteTestObject = createObject(ENDPOINT, newTestObject);
        TestDTO getTestObject = getObject(ENDPOINT + creteTestObject, TestDTO.class);
        assertEqualsObject(newTestObject, getTestObject);
    }
}
