package org.example.endpoints;

import io.restassured.response.Response;
import org.example.client.ApiClient;
import org.example.request.StartUploadRequest;
import org.example.response.StartUploadResponse;
import org.example.utils.SessionStorage;

public class StartUpload extends ApiClient {

    private static final String URL = "https://upload.filestackapi.com/multipart/start";

    public Response initiateUpload(StartUploadRequest requestPayload) {
        Response response = send(URL, "POST", requestPayload);

//        // Print the full response body (as String) // just for debugging
//        System.out.println("Response Body:");
//        System.out.println(response.getBody().asPrettyString());


        StartUploadResponse parsed = response.as(StartUploadResponse.class);
//
        SessionStorage.save("response_uri", parsed.getUri());
        SessionStorage.save("location_url", parsed.getLocationUrl());

        return response;
    }
}
