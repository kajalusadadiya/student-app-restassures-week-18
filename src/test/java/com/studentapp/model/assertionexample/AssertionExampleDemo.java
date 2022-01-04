package com.studentapp.model.assertionexample;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AssertionExampleDemo {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt(){

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
      response = given()
              .when()
              .get("/products")
              .then().statusCode(200);
    }
 @Test
    public void test001(){
        response.body("limit", equalTo(11));
    }

@Test
    public void test002(){
        response.body("total", equalTo(51959));
}
@Test
    public void test003(){
        response.body("data.name", hasItem("Duracell - AA Batteries (8-Pack)"));
    }
    @Test
    public void test004(){
        response.body("data[*].name", hasItems("(Energizer - MAX Batteries AA (4-Pack), Duracell - 9V Batteries (2-Pack)) "));
    }
    @Test
    public void test005(){
        response.body("data[0].categories[0]",hasKey("name"));
    }
    @Test
    public void test006(){
        response.body("data.findAll{it.name=='Energizer - N Cell E90 Batteries (2-Pack)'}", hasItem(hasEntry("manufacturer", "Energizer")));
    }
    @Test
    public void test007(){
        response.body("limit", equalTo(10))
                .body("data.findAll{it.name=='Energizer - N Cell E90 Batteries (2-Pack)'}", hasItem(hasEntry("manufacturer", "Energizer")))
                .body("data[0].categories[0]", hasKey("name"));
    }
    @Test
    public void test008(){
        response.body("limit", equalTo(10))
                .body("limit", lessThan(12))
                .body("limit", greaterThan(9))
                .body("limit", greaterThanOrEqualTo(10));
    }
}
