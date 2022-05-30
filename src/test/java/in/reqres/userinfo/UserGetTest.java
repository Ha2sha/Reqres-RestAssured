package in.reqres.userinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class UserGetTest extends TestBase {

    @Test
    public void getAllUsersInfo() {
        HashMap<String,Object>qParams=new HashMap<>();
        qParams.put("page",2);
        Response response = given()
                .queryParams(qParams)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleUserInfo() {
        Response response = given()
                .pathParam("id", 4)
                .when()
                .get("/users/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchUserWithParameter() {
        HashMap<String,Object>qParams=new HashMap<>();
        qParams.put("id",5);
        Response response=given()
                .queryParams(qParams)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getUsersWithDelayedResponse() {
        HashMap<String,Object>qParams=new HashMap<>();
        qParams.put("page",2);
        qParams.put("delay",6);
        Response response = given()
                .queryParams(qParams)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void singleUserNotFound() {
        Response response = given()
                .pathParam("id", 23)
                .when()
                .get("/unknown/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }
}
