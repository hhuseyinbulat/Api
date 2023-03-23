package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a GET request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Aaron" and last name is "Chen"
            (Data içerisinde firstname değeri "Aaron", lastname değeri "Chen" olan biri olmalı)
     */

    @Test
    public void get05(){
        //Set the URL
        spec.pathParam("first","booking").
                queryParams("firstname","Sally","lastname","Brown");

        //Set the expected data

        //Send the request and get the response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do Assertion
        response.then().statusCode(200);//Status code is 200

        // Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
        assertTrue(response.asString().contains("bookingid"));
    }

}
