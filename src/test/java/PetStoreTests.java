import io.qameta.allure.Description;
import io.qameta.allure.junit4.AllureJunit4;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class PetStoreTests extends  BaseTest {

    @Rule
    public AllureJunit4 rule = new AllureJunit4();

    @Test
    @Description("Create pet")
    public void CreatePet(){
        String bodyPayload = "{\n" +
                "    \"id\": 1234567880,\n" +
                "    \"category\": {\n" +
                "        \"id\": 13,\n" +
                "        \"name\": \"zeytin3\"\n" +
                "    },\n" +
                "    \"name\": \"doggie\",\n" +
                "    \"photoUrls\": [\n" +
                "        \"string\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"id\": 1234,\n" +
                "            \"name\": \"kömür\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"available\"\n" +
                "}";
        RestAssured.given()
                .body(bodyPayload)
                .contentType(ContentType.JSON)
                .when()
                .post("pet")
                .then()
                .statusCode(200);


    }

    @Test
    @Description("Get pet from ID")
    public void GetPetID(){
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("pet/1234567880")
                .then()
                .statusCode(200);
    }

    @Test
    @Description("Update Pet")
    public void UpdatePet(){
        String bodyPayload = "{\n" +
                "    \"id\": 1234567890,\n" +
                "    \"category\": {\n" +
                "        \"id\": 1234,\n" +
                "        \"name\": \"zeytin2\"\n" +
                "    },\n" +
                "    \"name\": \"doggie\",\n" +
                "    \"photoUrls\": [\n" +
                "        \"string\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"id\": 123,\n" +
                "            \"name\": \"kömür2\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"available\"\n" +
                "}";

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(bodyPayload)
                .put("pet")
                .then()
                .statusCode(200);
    }

    @Test
    @Description("Delete Pet")
    public void DeletePet(){
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete("pet/1234567890")
                .then()
                .statusCode(200);
    }

    @Test
    @Description("Get Pet from status")
    public void GetPetStatus(){
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("pet/findByStatus?status=available")
                .then()
                .statusCode(200);
    }

    @Test
    @Description("Update petID")
    public void UpdatePetID(){
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .post("pet/1234567890")
                .then()
                .statusCode(415);
    }


}
