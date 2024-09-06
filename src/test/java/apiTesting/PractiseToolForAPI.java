package apiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PractiseToolForAPI {


@BeforeClass
    public static void setup(){
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void practiseTest(){

    long time = given().
            get("/users?page=2").
            then().
            statusCode(200).
            body("data[0].id", equalTo(7),
                  "data[0].first_name", equalTo("Michael"),
                    "data[0].last_name", equalTo("Lawson")).
            log().all().
            extract().time();

        System.out.println(time);
    }

@Test
    public void checkDetails(){

    long time = given().
            get("/users?page=2").
            then().
            statusCode(200).
            body("data[2].first_name", equalTo("Tobias"),
                    "data[0].email", equalTo("tobias.funke@reqres.in"),
                    "data[0].avatar", equalTo("https://reqres.in/img/faces/9-image.jpg")).
            log().all().
            extract().time();

        System.out.println(time);
    }


@Test
    public void testing (){

    String body = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";


    given().
            contentType(ContentType.JSON).
            body(body).
    when().
            post("/users").
    then().
            statusCode(201).
            body("name", equalTo("morpheus")).
            body("job", equalTo("leader")).
            log().all();


    }



    @Test
    public void testing2 (){

        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";


        given().
                contentType(ContentType.JSON).
                body(body).

                when().
                post("/users").
                then().
                statusCode(201).

                log().all();


    }





    @Test
    public void testingPut (){

    String body = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"zion resident\"\n" +
            "}";

    given().
            contentType(ContentType.JSON).
            body(body).
    when().
            put("users/2").
    then().
            statusCode(200).
            body("name", equalTo("morpheus"),
                    "job", equalTo("zion resident")).
            log().all();
    }




}
