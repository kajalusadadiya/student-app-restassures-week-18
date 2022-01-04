package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StudentDeleteTest extends TestBase {


    Response response= (Response) given()
            .pathParam("id", 102)
            .when()
            .delete("/{id}")
            .then()
            .statusCode(204);



}
