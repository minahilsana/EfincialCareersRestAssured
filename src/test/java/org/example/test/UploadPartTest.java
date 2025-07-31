package org.example.test;

import io.restassured.response.Response;
import org.example.endpoints.PutUploadPart;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadPartTest {

    public void shouldUploadFilePartSuccessfully() {
        File fileToUpload = new File("src/test/PDF/TestRsume.pdf");

        PutUploadPart uploader = new PutUploadPart();
        Response response = uploader.uploadFilePart(fileToUpload);

        assertEquals(200, response.getStatusCode());
    }
}
