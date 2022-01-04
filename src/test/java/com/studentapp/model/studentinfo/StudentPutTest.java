package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPutTest extends TestBase {
    @Test
    public void updateStudentWithPut(){
        List<String> courseList = new ArrayList<>();
        courseList.add("java");
        courseList.add("Selenium");


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Ram");
        studentPojo.setLastName("Dasharth");
        studentPojo.setEmail("Raml123@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(courseList);
        Response response = given()
                .pathParam("id", 102)
                .header("Content-Type","application/json")
                .body(studentPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
