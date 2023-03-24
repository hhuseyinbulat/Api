package delete_request;

import base_urls.DummyRestApiBaseUrl;
import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDeleteBodyPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Delete02 extends DummyRestApiBaseUrl {
    /*
Given
    URL: https://dummy.restapiexample.com/api/v1/delete/2


When
    HTTP Request Method: DELETE Request


Then
    Assert:     i) Status code is 200
            ii) "status" is "success"
            iii) "data" is "2"
            iv) "message" is "Successfully! Record has been deleted"

  */

    @Test
    public void delete02() {
       // Given
       // URL: https://dummy.restapiexample.com/api/v1/delete/2
        spec.pathParams("first","delete","second",02);
        //set the expected data
        DummyRestApiDeleteBodyPojo expectedData = new DummyRestApiDeleteBodyPojo("success","2","Successfully! Record has been deleted");
        System.out.println("expectedData = " + expectedData);
        //When
        //HTTP Request Method: DELETE Request
        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();



     //  Then
        DummyRestApiDeleteBodyPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiDeleteBodyPojo.class);

                // i) Status code is 200
                   assertEquals(200,response.statusCode());
                //  ii) "status" is "success"
                   assertEquals(expectedData.getStatus(),actualData.getStatus());
                //  iii) "data" is "2"
                   assertEquals(expectedData.getData(),actualData.getData());
                //  iv) "message" is "Successfully! Record has been deleted"
                   assertEquals(expectedData.getMessage(),actualData.getMessage());

    }
}
