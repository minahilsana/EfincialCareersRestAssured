package org.example.request;

import java.util.Map;

public class MultipartUploadRequest {
    private String apikey;
    private String uri;
    private String upload_id;
    private String region;
    private Map<String, String> store;
    private int part;
    private int size;
    private String md5;

    public MultipartUploadRequest(String apikey, String uri, String upload_id, String region, int part, int size , String md5) {
        this.apikey = apikey;
        this.uri = uri;
        this.upload_id = upload_id;
        this.region = region;
        this.store = Map.of("location", "s3"); // empty map
        this.part = part;
        this.size = size;
        this.md5= md5;
    }

    public String getApikey() {
        return apikey;
    }

    public String getUri() {
        return uri;
    }

    public String getUpload_id() {
        return upload_id;
    }

    public String getRegion() {
        return region;
    }

    public Map<String, String> getStore() {
        return store;
    }

    public int getPart() {
        return part;
    }

    public int getSize() {
        return size;
    }

    public String getMd5() {
        return md5;
    }
}
