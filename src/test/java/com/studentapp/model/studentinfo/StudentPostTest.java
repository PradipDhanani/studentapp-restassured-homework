package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.given;

/**
 * Created by Pradip
 */
public class StudentPostTest extends TestBase {
/*
      Using this below method we can enter random data but we are working with data base.
      so I think I should not play with data in real time

    String email = "Pradeep" + getRandomString(4) + "@gmail.com";
    String firstName = "Pradeep" + getRandomString(2);
    String lastName = "Patel" + getRandomString(2); */

    String email = "Pradeep" + getRandomString(4) + "@gmail.com";

    @Test
    /*
    below programme is for creating new student in data base with giving all mandatory details.
    after successful student added we are getting 201 status code successfully.
     */
    public void createNewStudent() {
        List<String> course = new ArrayList<>();

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Pruv");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(course);

        course.add("selenium");
        course.add("java");
        course.add("API Testing");

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
     /*
    below programme is for creating new student in data base with giving all mandatory details but here we are not giving first name.
    after successful student added we are getting 201 status code successfully.
     */
    public void createNewStudentWithoutFirstName() {

        List<String> course = new ArrayList<>();


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(" ");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Testing");
        studentPojo.setCourses(course);

        course.add("selenium");
        course.add("java");
        course.add("API Testing");

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
     /*
    below programme is for creating new student in data base with giving all mandatory details but here we are not giving last name.
    after successful student added we are getting 201 status code successfully.
     */
    public void createNewStudentWithoutLastName() {

        List<String> course = new ArrayList<>();

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Paresh");
        studentPojo.setLastName(" ");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Testing");
        studentPojo.setCourses(course);

        course.add("selenium");
        course.add("java");
        course.add("API Testing");

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }

    @Test
     /*
    below programme is for creating new student in data base with giving all mandatory details but here we are giving duplicate email id.
    system showing getting error 500 status code.
     */
    public void StudentDuplicateEmailError() {

        List<String> course = new ArrayList<>();

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Parel");
        studentPojo.setLastName("Parl");
        studentPojo.setEmail("anna@gmail.com");
        studentPojo.setProgramme("Testing");
        studentPojo.setCourses(course);

        course.add("selenium");
        course.add("java");
        course.add("API Testing");

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(500);
        response.prettyPrint();


    }
}
