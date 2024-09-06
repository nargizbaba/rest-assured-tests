package apiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PractiseHomeAPI {

    @BeforeClass
    public static void setUp (){
        RestAssured.baseURI = "https://reqres.in/api";
    }



@Test
    public void getSingleUser (){


        long time = given().
                get("/users/2").
                then().
                body("data.email", equalTo("janet.weaver@reqres.in")).
                statusCode(200).
                log().all().
                extract().time();

    System.out.println(time);

    }






@Test
    public void getSingleUserNotFound (){

        long time = given().
                get("/users/23").
                then().
                statusCode(404).
                log().all().
                extract().time();

        System.out.println(time);

    }



    



    @Test
    public void getListResource(){

        long time = given()
                .get("/unknown")
                .then()
                .body("data[0].name", equalTo("cerulean"))
                .statusCode(200)
                .log().all()
                .extract().time();

        System.out.println(time);

    }








@Test
    public void getSingleResource(){


        long time = given().
                get("/unknown/2").
                then().
                statusCode(200).
                log().all().
                extract().time();

    System.out.println(time);

}






@Test
public void getSingleResourceNotFound (){

        long time = given().
                get("/unknown/23").
                then().
                statusCode(404).
                log().all().
                extract().time();

    System.out.println(time);

}






@Test
public void postCreate (){

        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        long time = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post("/users").
                then().
                statusCode(201).
                body("name", equalTo("morpheus")).
                log().all().
                extract().time();

    System.out.println(time);

}






@Test
public void putUpdate (){

        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        long time = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                put("users/2").
                then().
                statusCode(200).
                log().all().
                extract().time();

    System.out.println(time);
}







@Test
    public void patchUpdate (){

        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        long time = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                patch("/users/2").
                then().
                statusCode(200).
                body("name", equalTo("morpheus")).
                log().all().
                extract().time();

        System.out.println(time);

}





@Test
    public void deleteDelete(){

        long time = given().
                delete("/users/2").
                then().
                statusCode(204).
                log().all().
                extract().time();

        System.out.println(time);

}





@Test
    public void postRegisterSuccessful (){

        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";


        long time = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post("/register").
                then().
                statusCode(200).
                log().all().
                extract().time();

        System.out.println(time);

}






@Test
    public void postRegisterUnsuccessful (){

        String requestBody = "{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";

        long time = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post("/register").
                then().
                statusCode(400).
                log().all().
                extract().time();

        System.out.println(time);

}







@Test
    public void postLoginSuccessful (){


        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";


        long time = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post("/login").
                then().
                statusCode(200).
                log().all().
                extract().time();

        System.out.println(time);

}







@Test
    public void postLoginUnsuccessful (){

        String requestBody = "{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}";

        long time = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post("/login").
                then().
                statusCode(400).
                log().all().
                extract().time();

        System.out.println(time);
}





@Test
    public void getDelayedResponse(){

        long time = given().
                get("/users?delay=3").
                then().
                statusCode(200).
                body("data[0].email", equalTo("george.bluth@reqres.in")).
                log().all().
                extract().time();

        System.out.println(time);

}

}
