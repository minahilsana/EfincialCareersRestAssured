package org.example.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobSearchResponse {
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private String id;
        private String title;
        private String description;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }
}
