package org.example.endpoints;

import io.restassured.response.Response;
import org.example.request.CompleteMultipartRequest;
import org.example.response.CompleteMultipartResponse;

import static io.restassured.RestAssured.given;

public class PostCompleteMultipartUpload {

    public Response completeUpload(CompleteMultipartRequest requestBody) {
        return given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("https://upload-ap-northeast-1.filestackapi.com/multipart/complete");
    }

    public CompleteMultipartResponse completeAndExtract(CompleteMultipartRequest requestBody) {
        return completeUpload(requestBody)
                .then()
                .statusCode(200)
                .extract()
                .as(CompleteMultipartResponse.class);
    }
}
