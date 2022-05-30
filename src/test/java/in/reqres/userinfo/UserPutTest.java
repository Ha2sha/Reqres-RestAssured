package in.reqres.userinfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPutTest extends TestBase {
    @Test
    public void updateUserWithPut(){
        UserPojo userPojo=new UserPojo();
        userPojo.setName("Shiven Shah");
        userPojo.setJob("Automation Engineer");

        Response response=given()
                .header("Content-Type", "application/json")
                .pathParam("id", 177)
                .body(userPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
