package org.example.endpoints;

import io.restassured.response.Response;
import org.example.client.ApiClient;
import org.example.response.JobSearchResponse;
import org.example.utils.SessionStorage;
import java.util.Map;


public class searchJob extends ApiClient {

    private static final String URL = "https://job-search-api.efinancialcareers.com/v1/efc/jobs/search";

    public Response search(String jobTitle) {
        Response response = send(URL, "GET", null, Map.of(
                "q", jobTitle,
                "page", "1",
                "pageSize", "15"
        ));

        // Deserialize
        JobSearchResponse parsed = response.as(JobSearchResponse.class);
        String jobId = parsed.getData().get(0).getId(); // Get first job ID


        // Store for later use
        SessionStorage.save("jobId", jobId);

        return response;
    }
}
