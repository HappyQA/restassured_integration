package test.api;

import io.qameta.allure.Epic;

import org.junit.jupiter.api.*;
import test.dto.TestDTO;

@Tag("Test-API")
@Epic("API section / API CRUD")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SomeAPITest extends Configuration {

    @Order(1)
    @Test
    @DisplayName("Test Case - 1: Create Object")
    public void createObject() {
        TestDTO newTestObject = createTestObject();
        String creteTestObject = createObject(ENDPOINT, newTestObject);
        TestDTO getTestObject = getObject(ENDPOINT + creteTestObject, TestDTO.class);
        assertEqualsBudgetStructure(newTestObject, getTestObject);
    }
}
