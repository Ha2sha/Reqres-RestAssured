package in.reqres.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void inIt() {
        //set environment
        RestAssured.baseURI="https://reqres.in";//test environment
        RestAssured.basePath="/api";

    }
}
