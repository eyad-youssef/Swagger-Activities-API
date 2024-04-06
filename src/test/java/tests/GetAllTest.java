package tests;

import Resources.Utilities;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import Resources.TestBuild;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetAllTest extends Utilities {
    RequestSpecification res;
    ResponseSpecification responspec;
    Response response;
//    TestBuild testData = new TestBuild();

    @Test
    public void getAllActivities() throws IOException {

        responspec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON)
                .build();

        res = given()
                .spec(requestSpecification());


        response = res.
                when()
                .get("Activities")
                .then().spec(responspec).extract().response();

        assertEquals(response.getStatusCode(), 200);

        String body = response.asString();

        JsonPath jsOpj= new JsonPath(body);
        System.out.println(" total number of users Activities is "+ jsOpj.getList("id").size() + " user");

    }
}
