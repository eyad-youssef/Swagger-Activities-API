package tests;

import Resources.TestBuild;
import Resources.Utilities;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostTest extends Utilities {


    RequestSpecification res;
    ResponseSpecification responspec;
    Response response;
    TestBuild testData = new TestBuild();
    @Test
    public void addActivity() throws IOException {

        responspec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON)
                .build();

        res = given()
                .spec(requestSpecification())
                .body(testData.createActivity());


        response = res.
                when()
                .post("Activities")
                .then().spec(responspec).extract().response();

        assertEquals(response.getStatusCode(), 200);
    }


}
