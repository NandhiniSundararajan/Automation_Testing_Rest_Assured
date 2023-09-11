package Rest_Tests;

import groovy.transform.TypeChecked;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class Put_Req {

    public static HashMap details = new HashMap();
    @BeforeClass
    public void prepData(){
        details.put("name","RRR");
        details.put("job","Astronaut");
    }

    @Test
    public void putReqTest(){
        given()
                .contentType("application/json")
                .body(details)
                .when()
                .put("https://reqres.in/api/users/878")
                .then()
                .statusCode(200)
                .log().all();
    }
}
