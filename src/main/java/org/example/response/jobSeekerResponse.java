package org.example.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class jobSeekerResponse {
    private Data data;

    public Data getData() {
        return data;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private String access_token;
        private String refresh_token;
        private String token_type;
        private String jobseekerId;
        private List<String> roles;

        public String getAccess_token() {
            return access_token;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public String getToken_type() {
            return token_type;
        }

        public String getJobseekerId() {
            return jobseekerId;
        }
        public List<String> getRoles() {
            return roles;
        }
    }
}
