package org.example.test;

import io.restassured.response.Response;
import org.example.endpoints.StartUpload;
import org.example.request.StartUploadRequest;
import org.example.utils.SessionStorage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StartUploadTest {


    public void shouldInitiateUploadSuccessfully() {
        StartUploadRequest request = new StartUploadRequest(
                "TestRsume.pdf",
                "application/pdf",
                53746,
                "AspmZm6UNRi2WpLedxsLgz"
        );

        StartUpload upload = new StartUpload();
        Response response = upload.initiateUpload(request);

        assertEquals(200, response.statusCode());

        // Additional checks //for checking k sessionstroage me store hui b hai value k ni
        assertNotNull(SessionStorage.get("response_uri"));
        assertNotNull(SessionStorage.get("location_url"));


//        //just for debudding
//        System.out.println(SessionStorage.get("response_uri"));
//        System.out.println(SessionStorage.get("location_url"));

    }
}
