package Rest_Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Post_Req {

    public static HashMap details = new HashMap();
    public static HashMap hm = new HashMap();

    @BeforeClass
    public void dataToPost() {
        details.put("name", "BBBB");
        details.put("job", "Leader");
    }

    @Test
    public void postReqTest() {

        given()
                .contentType("application/json")
                .body(details)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .assertThat().body("name",equalTo("BBBB"))
                .assertThat().body("job",equalTo("Leader"))
                .log().all();
    }


}
