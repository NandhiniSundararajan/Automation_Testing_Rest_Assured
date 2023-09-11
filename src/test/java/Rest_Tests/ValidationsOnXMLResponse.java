package Rest_Tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ValidationsOnXMLResponse {

    @Test
    public void test_singleContent(){
        given()
                //NA
                .when()
                .get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
                .statusCode(200)
                .body("CUSTOMER.ID", equalTo("10"))
                .body("CUSTOMER.FIRSTNAME", equalTo("Sue"))
                .log().all();

    }

    @Test
    public void test_multipleContentInOneShot(){
        given()
                //NA
                .when()
                .get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
                .statusCode(200)
                .body("CUSTOMER.text()",equalTo("10SueFuller135 Upland Pl.Dallas"))
                .log().all();
    }

    @Test
    public void test_xpathInXMLResponse(){
        given()
                //NA
                .when()
                .get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
                .statusCode(200)
                .body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Sue")))
                .log().all();
    }

    @Test
    public void test_xpathInXMLResponse2(){
        given()
                //NA
                .when()
                .get("http://www.thomas-bayer.com/sqlrest/INVOICE/")
                .then()
                .statusCode(200)
                .body(hasXPath("/INVOICEList/INVOICE[text()='27']"))
                .log().all();
    }


    @Test
    public void test_RootPath(){
        given()
                //NA
                .when()
                .get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
                .statusCode(200)
                .rootPath("CUSTOMER")
                .body("ID", is("10"))
                .body("FIRSTNAME", is("Sue"))
                .detachRootPath("CUSTOMER")
                .body("CUSTOMER.LASTNAME", is("Fuller"))
                .log().all();

    }
}
