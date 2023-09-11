package Rest_Tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get_Req {

    @Test
    public void get_details() {

        given()
                .pathParam("id","7")
                .when()
                .get("https://reqres.in/api/users/{id}")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8")
                .assertThat().body("data.email", equalTo("michael.lawson@reqres.in"))
                .assertThat().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
                .log().all();
    }


}
