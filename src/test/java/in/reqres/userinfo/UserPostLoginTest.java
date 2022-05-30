package in.reqres.userinfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostLoginTest extends TestBase {
    UserPojo userPojo=new UserPojo();

    @Test
    public void userLoginSuccessful() {
        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword("cityslicka");
         Response response = given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void userLoginUnSuccessful() {
        userPojo.setEmail("peter@klaven");
        userPojo.setPassword("");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post("/login");
        response.then().statusCode(400);
        response.prettyPrint();

    }
}
