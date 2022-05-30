package in.reqres.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
        response = given()
                .queryParams("page", 2)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1.page = 2
    @Test
    public void test001() {
        int pageNo = response.extract().path("page");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of page is : " + pageNo);
        System.out.println("------------------End of Test---------------------------");

    }
    //2.per_page = 6
    @Test
    public void test002() {
        int perPage = response.extract().path("per_page");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of per_page is : " + perPage);
        System.out.println("------------------End of Test---------------------------");

    }
    //3.data[1].id = 8
    @Test
    public void test003() {
        int id = response.extract().path("data[1].id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The ID of data[1] is : " + id);
        System.out.println("------------------End of Test---------------------------");

    }
    //4.data[3].first_name = Byron
    @Test
    public void test004() {
        String firstName = response.extract().path("data[3].first_name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The firstName of data[3] is : " + firstName);
        System.out.println("------------------End of Test---------------------------");

    }
    //5.list of data = 6
    @Test
    public void test005() {
        int listSize = response.extract().path("data.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The list of data is : " + listSize);
        System.out.println("------------------End of Test---------------------------");
    }
    //6.data[5].avatar="https://reqres.in/img/faces/12-image.jpg"
    @Test
    public void test006() {
        String imageLink = response.extract().path("data[5].avatar");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The link of data[5].avatar is : " + imageLink);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. support.url = "https://reqres.in/#support-heading"
    @Test
    public void test007() {
        String supportUrl = response.extract().path("support.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Support URL is : " + supportUrl);
        System.out.println("------------------End of Test---------------------------");
    }
    //8. support.txt = "To keep ReqRes free, contributions towards server costs are appreciated!"
    @Test
    public void test008() {
        String supportTxt = response.extract().path("support.text");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Support Text is : " + supportTxt);
        System.out.println("------------------End of Test---------------------------");
    }


}
