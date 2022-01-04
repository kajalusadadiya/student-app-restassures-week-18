package com.studentapp.model.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("-------------StartingTest--------------");
        System.out.println("The valu of limit is :" + limit);
        System.out.println("--------------End of Test--------------");
    }

    @Test
    public void test002() {
        List<Integer> idList = response.extract().path("data.id");
        System.out.println("-------------StartingTest------------");
        System.out.println("List of Ids are :" + idList);
        System.out.println("--------------End of Test-----------");
    }
    @Test
    public void test003(){
        String productName = response.extract().path("data[0].name" );
        System.out.println("-------------StartingTest-----------");
        System.out.println("The Categories list are :"+ productName);
        System.out.println("--------------End of Test-----------");
    }
    // 5)Print the size of data   //HomeWork
    @Test
    public void test005(){
        System.out.println("-----------StartingTest----------");
        System.out.println("The size of the data is :");
        System.out.println("------------End of Test----------");
    }
    // 6) Get All the products Name from data    ///Homework
    @Test
    public void test006(){
        System.out.println("-----------StartingTest----------");
        System.out.println("The names of the products are: ");
        System.out.println("------------End of Test----------");
    }
    @Test
    public void test007(){
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='Duracell - AA Batteries (8-Pack)'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for product name 'Duracell - AA Batteries (8-Pack)' are: " + values);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test008(){
        List<Integer> price = response.extract().path("data.findAll{it.name=='Duracell - D Batteries (4-Pack)'}.price");
        System.out.println("------------StartingTest-----------");
        System.out.println("The price of product name 'Duracell - D Batteries (4-Pack)' is:" + price);
        System.out.println("--------------End of Test------------");
    }
    @Test
    public void test009(){
        List<String> nameList =response.extract().path("data.findAll{it.price<16.99}.name");
        System.out.println("---------------StartingTest---------");
        System.out.println("The names of products that price is less than 16.99 are:" + nameList);
        System.out.println("---------------End of Test-------------");
    }
    @Test
    public void test010(){
        List<String> manufactures = response.extract().path("data.findAll{it.name==~/Ene.*/}.manufacturer");

        System.out.println("---------StartingTest----------");
        System.out.println("The manufacturer of products whose name start = Ene are:" + manufactures);
        System.out.println("----------End of Test-----------");
    }

    @Test
    public void test011(){
        List<String> price = response.extract().path("data.findAll{it.name==~/.*Black/}.price");
        System.out.println("----------StartingTest-----------");
        System.out.println("The prices of products whose name end with = Vehicles are: " + price);
        System.out.println("---------End of Test---------");
    }
    @Test
    public void test012(){
        List<Integer> id = response.extract().path("data.findAll{it.name=='Energizer - N Cell E90 Batteries (2-Pack)'}.id");
        System.out.println("-----------StartingTest---------");
        System.out.println("The id of product whose name  'Energizer - N Cell E90 Batteries (2-Pack)' is : " + id);
        System.out.println("-----------End of Test----------");
    }
}
