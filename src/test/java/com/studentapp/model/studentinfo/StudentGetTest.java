package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Pradip
 */
public class StudentGetTest extends TestBase {

    @Test
    /*
    Below method is for getting all data.
     */
    public void getAllStudentDetails() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
     /*
    Below method is for searching student using id from list of all students.
     */
    public void searchStudentById() {
        Response response = given()
                .when()
                .get("85");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
     /*
    Below method is for searching student using id from list of all students.
     */
    public void searchStudentByProgramme() {
        Response response = given()
                .param("programme", "Financial Analysis")
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();

        given()
                .param("programme","Financial Analysis")
                .when()
                .get("/list")
                .then()
                .body("programme.size()",equalTo(10));


    }

    @Test
     /*
    Below method is for searching student using programme and limit from list of all students.
     */
    public void searchStudentByProgrammeAndLimit(){
        Response response = given()
                .param("programme", "Financial Analysis")
                .param("limit", "5")
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();

        given()
                .param("programme","Financial Analysis")
                .param("limit",5)
                .when()
                .get("/list")
                .then()
                .body("programme.size()",equalTo(5));


    }

}
