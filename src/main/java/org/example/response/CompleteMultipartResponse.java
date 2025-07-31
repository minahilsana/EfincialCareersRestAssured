package org.example.response;

public class CompleteMultipartResponse {
    private String handle;
    private String url;
    private String filename;
    private int size;
    private String mimetype;
    private String status;

    public String getHandle() {
        return handle;
    }

    public String getUrl() {
        return url;
    }

    public String getStatus() {
        return status;
    }

    public String getFilename() {
        return filename;
    }

    public String getMimetype() {
        return mimetype;
    }
}
