package post_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post06 extends DummyRestApiBaseUrl {
    /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body:
                     {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image",
                        "id": 4891
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                        },
                        "message": "Successfully! Record has been added."
                    }
     */

    @Test
    public void post06() {
        //Given
            //URL: https://dummy.restapiexample.com/api/v1/create
        spec.pathParam("first","create");
        //And
            //Request body:
            //                     {
            //                        "employee_name": "Tom Hanks",
            //                        "employee_salary": 111111,
            //                        "employee_age": 23,
            //                        "profile_image": "Perfect image",
            //                        "id": 4891
            //                     }
        DummyRestApiDataPojo expectedData = new DummyRestApiDataPojo("Tom Hanks",111111,23,"Perfect image");
        System.out.println("expectedData = " + expectedData);
        DummyRestApiResponseBodyPojo restApiResponseBodyPojo= new DummyRestApiResponseBodyPojo("success",expectedData,"Successfully! Record has been added.");
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();
        //Then
        DummyRestApiResponseBodyPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiResponseBodyPojo.class);
            //i) Status code is 200
        assertEquals(200,response.statusCode());



        //And
            //                ii) Response body should be like the following
            //                    {
            //                        "status": "success",
            //                        "data": {
            //                            "employee_name": "Tom Hanks",
            //                            "employee_salary": 111111,
            //                            "employee_age": 23,
            //                            "profile_image": "Perfect image",
            //                            "id": 4891
            //                        },
            //                        "message": "Successfully! Record has been added."
            //                    }
        assertEquals(restApiResponseBodyPojo.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expectedData.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(expectedData.getProfile_image(),actualData.getData().getProfile_image());
        assertEquals(restApiResponseBodyPojo.getMessage(),actualData.getMessage());

    }
}
