package org.example.endpoints;

import io.restassured.response.Response;
import org.example.client.ApiClient;
import org.example.request.jobSeekerRequest;
import org.example.response.jobSeekerResponse;
import org.example.utils.SessionStorage;

public class registerJobSeeker extends ApiClient {

    private static final String URL = "https://email-verification.efinancialcareers.com/v1/jobseekers";

    public Response register(jobSeekerRequest requestPayload) {
        Response response = send(URL, "POST", requestPayload);

        // Deserialize for chaining // deserialization ka matlab hai k response me sy kuch aya aur aapny POJO me set krdia
        jobSeekerResponse parsed = response.as(jobSeekerResponse.class);
        SessionStorage.save("access_token", parsed.getData().getAccess_token());
        SessionStorage.save("jobseekerId", parsed.getData().getJobseekerId());
//
//        System.out.println(" rhis is the regirstered job seekers id "+ SessionStorage.get("jobseekerId"));
//        System.out.println("this is the authentication bearer token" + SessionStorage.get("access_token"));

        return response;
    }
}
