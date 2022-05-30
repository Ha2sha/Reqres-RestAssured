package in.reqres.userinfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostRegisterTest extends TestBase {
    UserPojo userPojo=new UserPojo();
    @Test
    public void registerUserSuccessfully() {
        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword("pistol");

         Response response = given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post("/register");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void registerUserUnsuccessful() {
        userPojo.setEmail("sydney@fife");
        userPojo.setPassword("");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post("/register");
        response.then().statusCode(400);
        response.prettyPrint();
    }
}
