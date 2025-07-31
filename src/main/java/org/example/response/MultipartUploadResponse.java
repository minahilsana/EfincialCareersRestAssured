package org.example.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipartUploadResponse {
    private String url;
    private int part;

    @JsonProperty("headers")
    private Map<String, String> headers;

    @JsonProperty("location_url")
    private String locationUrl;

    public String getUrl() { return url; }
    public int getPart() { return part; }
    public String getLocationUrl() { return locationUrl; }
    public Map<String, String> getHeaders() { return headers; }
}
