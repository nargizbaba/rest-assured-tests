package apiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HerokuappPractiseHomeApi {

    @BeforeClass
    public static void link() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @Test
    public void postAuth() {

        String requestBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        long time =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/auth")
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().time();

        System.out.println(time);
    }

    @Test
    public void getBookingIds() {

        long time =
                given()
                        .get("/booking")
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().time();

        System.out.println(time);
    }


    @Test
    public void getBooking() {

        long time =
                given()
                        .get("/booking/1")
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().time();

        System.out.println(time);
    }

///salammmmmmmm git
    @Test
    public void postGetBooking() {

        String requestBody = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        long time =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/booking")
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().time();

        System.out.println(time);
    }


    @Test
    public void putUpdateBooking() {

        String authToken = "Basic YWRtaW46cGFzc3dvcmQxMjM=";

        String requestBody = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        long time =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", authToken)
                        .body(requestBody)
                        .when()
                        .put("/booking/1")
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().time();

        System.out.println(time);
    }


    @Test
    public void patchPartialUpdateBooking() {

        String authToken = "Basic YWRtaW46cGFzc3dvcmQxMjM=";

        String requestBody = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        long time =
                given()
                        .header("Authorization", authToken)
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .patch("/booking/1")
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().time();

        System.out.println(time);
    }


    @Test
    public void deleteBooking() {

        String authToken = "Basic YWRtaW46cGFzc3dvcmQxMjM=";

        long time =
                given()
                        .header("Authorization", authToken)
                        .when()
                        .delete("/booking/7")
                        .then()
                        .log().all()
                        .extract().time();

        System.out.println(time);
    }


    @Test
    public void getPing() {

        long time =
                given()
                        .get("/ping")
                        .then()
                        .statusCode(201)
                        .log().all()
                        .extract().time();

        System.out.println(time);
    }
}
