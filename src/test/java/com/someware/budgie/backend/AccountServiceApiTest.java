package com.someware.budgie.backend;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class AccountServiceApiTest {
    @Test
    void testAccountsEndpoint() {
        given()
          .when().get("/accounts")
          .then()
            .contentType(ContentType.JSON)
            .statusCode(200)
            .body("size()", is(1))
            .body("[0].name", is("Barclays"))
            .body("[0].description", is("Joint family account"))
            .body("[0].type", is("checking"))
            .body("[0].balance", is(1000.00F));
    }
}
