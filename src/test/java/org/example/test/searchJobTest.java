package org.example.test;

import io.restassured.response.Response;
import org.example.endpoints.searchJob;
import org.example.utils.SessionStorage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class searchJobTest {


    public void shouldSearchJobs() {
        searchJob jobSearch = new searchJob();

        // Call the search method and capture the response
        Response response = jobSearch.search("developer");

        // Assert the status code
        assertEquals(200, response.getStatusCode());


        ///debug
//        System.out.println(SessionStorage.get("jobId"));
    }
}
