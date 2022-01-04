package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentPatchTest extends TestBase {
    @Test
    public void updateStudentWithPatch(){
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("RamSita123@gmail.com");

        Response response = given()
                .header("Content-Type","application/json")
                .pathParam("id", 102)
                .body(studentPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
