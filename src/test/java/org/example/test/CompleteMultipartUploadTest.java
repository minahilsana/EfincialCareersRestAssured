package org.example.test;

import io.restassured.response.Response;
import org.example.endpoints.PostCompleteMultipartUpload;
import org.example.request.CompleteMultipartRequest;
import org.example.response.CompleteMultipartResponse;
import org.example.utils.SessionStorage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CompleteMultipartUploadTest {

    @Test
    public void shouldCompleteMultipartUploadSuccessfully() {
        // Hardcode for now
        String apikey = "AspmZm6UNRi2WpLedxsLgz";
        String uri = SessionStorage.get("response_uri");
        String uploadId = SessionStorage.get("upload_id"); // Use "n/a" if needed
        String region = "us-east-1";
        String filename = "TestRsume.pdf";
        String mimetype = "application/pdf";
        int size = 17005;
        String etag = "2ec98b2a2402b7b65fc70a21c720f4f3";
        CompleteMultipartRequest request = new CompleteMultipartRequest(
                apikey, uri, uploadId, region, filename, mimetype, size, etag
        );

        PostCompleteMultipartUpload endpoint = new PostCompleteMultipartUpload();
        CompleteMultipartResponse response = endpoint.completeAndExtract(request);

        // Store handle for future use
        SessionStorage.save("handle", response.getHandle());

        // Assertions
        assertEquals("Stored", response.getStatus());
        assertEquals(filename, response.getFilename());
        assertEquals(mimetype, response.getMimetype());
        assertNotNull(response.getHandle());
    }
}
