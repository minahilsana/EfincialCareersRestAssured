package org.example.test;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.example.endpoints.MultipartUpload;
import org.example.request.MultipartUploadRequest;
import org.example.utils.SessionStorage;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class MultipartUploadTest {

    public static String calculateContentMD5(File file) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] content = Files.readAllBytes(file.toPath());
        byte[] digest = md.digest(content);
        return Base64.getEncoder().encodeToString(digest);
    }

    @Test
    public void shouldReturnUploadHeaders() {
        File file = new File("src/test/PDF/TestRsume.pdf");
        String md5;

        try {
            md5 = calculateContentMD5(file);
            log.info("Calculated Content-MD5 for file: {}", md5);
        } catch (Exception e) {
            log.error("Error calculating MD5 hash: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }

        String responseUri = SessionStorage.get("response_uri");
        log.info("Using response_uri from SessionStorage: {}", responseUri);

        MultipartUploadRequest request = new MultipartUploadRequest(
                "AspmZm6UNRi2WpLedxsLgz",
                responseUri,
                "n/a",
                "us-east-1",
                1,
                17005,
                md5
        );

        MultipartUpload uploader = new MultipartUpload();
        Response response = uploader.upload(request);

        log.info("Received response with status code: {}", response.statusCode());
        assertEquals(200, response.statusCode(), "Expected status code 200");
    }
}
