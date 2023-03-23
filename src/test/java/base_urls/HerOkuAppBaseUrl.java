package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static util.AuthenticationHerOkuApp.generateToken;

public class HerOkuAppBaseUrl {

    protected RequestSpecification spec;

    @Before//Her Test Method'undan önce çalışır
    public void setUp() { //setAccept(ContentType.JSON) bu olmasada çalışır
        spec =new RequestSpecBuilder().addHeader("Cookie",
                        "token="+generateToken()).setContentType(ContentType.JSON).
                setBaseUri("https://restful-booker.herokuapp.com").build();

    }
}