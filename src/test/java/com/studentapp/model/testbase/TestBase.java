package com.studentapp.model.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Pradip
 */
public class TestBase {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/student";

    }


}
