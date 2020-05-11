package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Pradip
 */
public class StudentPatchTest extends TestBase {

    @Test
     /*
    below programme is for updating students email id using patch method.
         */
    public void StudentDataUpdatedByEmailId() {

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("cric@gmail.com");


        Response response = given()
                .header("Content-Type", "application/json")
                .log().body()
                .body(studentPojo)
                .patch("/110");
        response.then().statusCode(200);
        response.prettyPrint();


        given()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .patch("/83")
                .then();
        get("/list").then().body("[82].email",equalTo("cric@gmail.com"));

    }


}
