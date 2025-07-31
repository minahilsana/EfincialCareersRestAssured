package org.example.endpoints;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.example.client.ApiClient;
import org.example.request.MultipartUploadRequest;
import org.example.response.MultipartUploadResponse;
import org.example.utils.SessionStorage;

import java.util.Map;

@Slf4j
public class MultipartUpload extends ApiClient {

    private static final String URL = "https://upload-ap-northeast-1.filestackapi.com/multipart/upload";

    public Response upload(MultipartUploadRequest requestPayload) {
        Response response = send(URL, "POST", requestPayload);

        MultipartUploadResponse parsed = response.as(MultipartUploadResponse.class);

        log.info("Raw Response Body:\n{}", response.getBody().asPrettyString());

        // Save values to session storage for later use
        SessionStorage.save("upload_url", parsed.getUrl());
        log.info("Saved 'upload_url' to session: {}", parsed.getUrl());

        Map<String, String> headers = parsed.getHeaders();
        if (headers != null) {
            headers.forEach((key, value) -> {
                SessionStorage.save(key, value);
                log.info("Saved header to session: {} = {}", key, value);
            });
        } else {
            log.warn("'headers' field is null in the response.");
        }

        return response;
    }
}
