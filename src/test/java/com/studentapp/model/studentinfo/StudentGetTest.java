package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StudentGetTest extends TestBase {


    @Test
    public void getAllStudentsInfo(){
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getSingleStudentInfo(){
        Response response = given()
                .pathParam("id", 10)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void searchStudentWithParameter(){
        HashMap<String,Object> qParams = new HashMap<>();
        qParams.put("programme", "Financial Analysis");
        qParams.put("limit", 2);
        Response response = given()
                .queryParams(qParams)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
