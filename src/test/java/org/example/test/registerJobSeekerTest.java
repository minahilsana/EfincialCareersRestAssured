package org.example.test;

import io.restassured.response.Response;
import org.example.endpoints.registerJobSeeker;
import org.example.request.jobSeekerRequest;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class registerJobSeekerTest {

    public void shouldRegisterJobseekerSuccessfully() {
        // Generate random email and password
        String email = "user_" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
        String password = "Pass@" + UUID.randomUUID().toString().substring(0, 6);

//        System.out.println(email);
//        System.out.println(password);

        jobSeekerRequest requestPayload = new jobSeekerRequest(
                email,
                password,
                Collections.singletonList("MEMBER_COMMUNICATIONS"),
                "us_US"
        );

        // Call API
        registerJobSeeker registration = new registerJobSeeker();
        Response response = registration.register(requestPayload);

        // Assert
        assertEquals(201, response.statusCode());
//        System.out.println("Jobseeker registered. JobSeekerID is: " + response.jsonPath().getString("data.jobseekerId"));
    }
}
