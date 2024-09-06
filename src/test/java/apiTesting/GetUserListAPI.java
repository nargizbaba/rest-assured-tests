package apiTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserListAPI {

    @Test
    public void getUserListAPI() {

        Response response = RestAssured.get("https://reqres.in/api/users/2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("fsjsj"));
        System.out.println(response.getStatusLine());


        int statusCode;
        statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);

    }
}
