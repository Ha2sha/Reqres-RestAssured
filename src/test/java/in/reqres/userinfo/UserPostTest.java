package in.reqres.userinfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {

    @Test
    public void createUser() {
        UserPojo userPojo=new UserPojo();
        userPojo.setName("Shiven");
        userPojo.setJob("Automation Tester");

         Response response = given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();

//177
    }
}
