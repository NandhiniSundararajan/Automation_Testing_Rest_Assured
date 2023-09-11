package Rest_Tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Post_Req2 {

    public static HashMap hm = new HashMap();
    @BeforeClass
    public void prepData2(){
        hm.put("name","Jack");
        hm.put("salary","5000");
        hm.put("age","30");
    }
    @Test
    public void postReqTest2() {

        Response res =
        given()
                .contentType("application/json")
                .body(hm)
                .when()
                .post("https://dummy.restapiexample.com/api/v1/create")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();


        String responseInStringFormat = res.asString();

        Assert.assertTrue(responseInStringFormat.contains("Jack"));


    }
}
