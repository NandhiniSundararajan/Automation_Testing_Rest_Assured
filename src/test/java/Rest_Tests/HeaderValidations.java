package Rest_Tests;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class HeaderValidations {

    @Test
    public void getSingleHeaderDetails(){
        Response res =  given()
                .pathParam("id","7")
                .when()
                .get("https://reqres.in/api/users/{id}");

        String s = res.getHeader("Content-Type");
        System.out.println("Single header: Content-Type:" + s);
    }

    @Test
    public void getMultipleHeaderDetails(){
        Response res =  given()
                .pathParam("id","7")
                .when()
                .get("https://reqres.in/api/users/{id}");
        Headers headers = res.getHeaders();
        for(Header h : headers){
            System.out.println(h.getName() + "--------" + h.getValue());
        }


    }
}
