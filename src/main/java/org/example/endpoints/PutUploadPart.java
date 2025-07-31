package org.example.endpoints;

import lombok.extern.slf4j.Slf4j;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.utils.SessionStorage;

import java.io.File;

import static io.restassured.RestAssured.given;

@Slf4j
public class PutUploadPart {
    public Response uploadFilePart(File fileToUpload) {
        String uploadUrl = SessionStorage.get("upload_url");

        if (uploadUrl.endsWith("?")) {
            uploadUrl = uploadUrl.substring(0, uploadUrl.length() - 1);
        }

        log.info("Uploading to: {}", uploadUrl);

        log.info("Headers before sending request:");
        log.info("Authorization: {}", SessionStorage.get("Authorization").trim());
        log.info("Content-Type: {}", SessionStorage.get("Content-Type"));
        log.info("x-amz-date: {}", SessionStorage.get("x-amz-date"));
        log.info("x-amz-content-sha256: {}", SessionStorage.get("x-amz-content-sha256"));
        log.info("Content-MD5: {}", SessionStorage.get("Content-Md5"));
        log.info("x-amz-acl: {}", SessionStorage.get("x-amz-acl"));

        Response response = given()
                .header("X-Amz-Acl", SessionStorage.get("x-amz-acl"))
                .header("Content-MD5", SessionStorage.get("Content-Md5"))
                .header("X-Amz-Content-Sha256", SessionStorage.get("x-amz-content-sha256"))
                .header("Authorization", SessionStorage.get("Authorization"))
                .header("X-Amz-Date", SessionStorage.get("x-amz-date"))
                .header("Content-Type", SessionStorage.get("Content-Type"))
                .header("X-Amz-Server-Side-Encryption", SessionStorage.get("x-amz-server-side-encryption"))
                .body(fileToUpload)
                .when()
                .put(uploadUrl);

        String etag = response.getHeader("ETag");
        log.info("ETag: {}", etag);
        SessionStorage.save("etag", etag);

        return response;
    }
}
