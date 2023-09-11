package Rest_Tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Delete_Req {

    @Test
    public void delReq(){
        Response res =
        given()
                .when()
                .delete("https://dummy.restapiexample.com/api/v1/delete/1604")
                .then()
                //.statusCode(200)
                .log().all()
                .extract().response();

        String responseInStr = res.asString();
        System.out.println("response:" + responseInStr);
        Assert.assertEquals(responseInStr.contains("Successfully! Record has been deleted"),true);
    }
}
