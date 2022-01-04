package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPostTest extends TestBase {
    @Test
    public void createStudent(){
        List<String> courseList = new ArrayList<>();
        courseList.add("java");
        courseList.add("Selenium");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("prime1");
        studentPojo.setLastName("Testing");
        studentPojo.setEmail("primetesting1@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(courseList);
        Response response = given()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
