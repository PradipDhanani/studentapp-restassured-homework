package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Pradip
 */
public class StudentDeleteTest extends TestBase {

    @Test
/*
   below programme is for updating students details using put method.
         */
    public void deleteStudentDataUsingId() {
        StudentPojo studentPojo = new StudentPojo();

        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .delete("/118");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}



