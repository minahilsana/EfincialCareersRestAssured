package org.example.request;

import java.util.List;

public class jobSeekerRequest {
    private String email_address;
    private String password;
    private List<String> newsletters;
    private String locale;

    public jobSeekerRequest(String email_address, String password, List<String> newsletters, String locale) {
        this.email_address = email_address;
        this.password = password;
        this.newsletters = newsletters;
        this.locale = locale;
    }


    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getNewsletters() {
        return newsletters;
    }

    public void setNewsletters(List<String> newsletters) {
        this.newsletters = newsletters;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
