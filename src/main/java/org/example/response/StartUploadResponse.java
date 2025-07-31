package org.example.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StartUploadResponse {

    private String uri;
    private String region;

    @JsonProperty("upload_id")
    private String uploadId;

    @JsonProperty("location_url")
    private String locationUrl;

    // Getters
    public String getUri() { return uri; }
    public String getRegion() { return region; }
    public String getUploadId() { return uploadId; }
    public String getLocationUrl() { return locationUrl; }
}
