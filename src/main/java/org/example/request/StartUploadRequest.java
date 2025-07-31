package org.example.request;
import java.util.Map;

public class StartUploadRequest {
    private String filename;
    private String mimetype;
    private int size;
    private String apikey;
    private Map<String, String> store;// empty object = empty Map//wesy ismy locale tha i guess , usko rmv krdo tb b response ara to islye empty hai

    public StartUploadRequest(String filename, String mimetype, int size, String apikey) {
        this.filename = filename;
        this.mimetype = mimetype;
        this.size = size;
        this.apikey = apikey;
        this.store = Map.of();
    }

    public String getFilename() {
        return filename;
    }

    public String getMimetype() {
        return mimetype;
    }

    public int getSize() {
        return size;
    }

    public String getApikey() {
        return apikey;
    }

    public Map<String, String> getStore() {
        return store;
    }
}
