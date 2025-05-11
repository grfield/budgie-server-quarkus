package com.someware.budgie.backend;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class AccountsResourceTest {
    @Test
    void testAccountsEndpoint() {
        given()
          .when().get("/accounts")
          .then()
             .statusCode(200)
             .body(is("[{ 'id': 1, 'name': 'Barclays', 'description': 'Joint family account', 'type': 'credit', 'balance': 1000 }]"));
    }

}
