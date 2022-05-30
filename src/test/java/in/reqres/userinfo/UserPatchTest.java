package in.reqres.userinfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class UserPatchTest extends TestBase {

    @Test
    public void updateUserWithPatch(){

        UserPojo userPojo=new UserPojo();
        userPojo.setJob("Manual Tester");

        Response response=given()
                .header("Content-Type", "application/json")
                .pathParam("id", 177)
                .body(userPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
