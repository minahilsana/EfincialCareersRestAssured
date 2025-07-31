package org.example.request;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CompleteMultipartRequest {
    private String apikey;
    private String uri;

    @SerializedName("upload_id")
    private String uploadId;

    private String region;
    private Store store;
    private String filename;
    private String mimetype;
    private int size;
    private List<Part> parts;

    public static class Store {
        private String location;

        public Store(String location) {
            this.location = location;
        }
    }

    public static class Part {
        @SerializedName("part_number")
        private int partNumber;
        private String etag;

        public Part(int partNumber, String etag) {
            this.partNumber = partNumber;
            this.etag = etag;
        }
    }

    public CompleteMultipartRequest(String apikey, String uri, String uploadId, String region, String filename, String mimetype, int size, String etag) {
        this.apikey = apikey;
        this.uri = uri;
        this.uploadId = uploadId;
        this.region = region;
        this.filename = filename;
        this.mimetype = mimetype;
        this.size = size;
        this.store = new Store("s3");
        this.parts = List.of(new Part(1, etag));
    }
}
