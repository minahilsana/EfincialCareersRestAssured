package org.example.client;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

import java.util.Map;

public class ApiClient {

    protected static final SessionFilter sessionFilter = new SessionFilter();

    //overload send method k jb query parameters na hon aur sirf simple request ho with request body
    //content type islye specify ki hui kyu k ek request me pdf upload krna to uska content type change hai
    protected Response send(String url, String method, Object body) {
        return send(url, method, body, ContentType.JSON, null); // default contentType and no queryParams
    }

    // Overloaded method with query params
    protected Response send(String url, String method, Object body, Map<String, String> queryParams) {
        return send(url, method, body, ContentType.JSON, queryParams);
    }

    // Full control version
    protected Response send(String url, String method, Object body, ContentType contentType, Map<String, String> queryParams) {
        RequestSpecification requestSpec = RestAssured
                .given()
                .filter(sessionFilter)
                .contentType(contentType);

        if (body != null) {
            requestSpec.body(body);
        }

        if (queryParams != null && !queryParams.isEmpty()) {
            requestSpec.params(queryParams);
        }

        return switch (method.toUpperCase()) {
            case "POST" -> requestSpec.post(url);
            case "GET" -> requestSpec.get(url);
            case "PUT" -> requestSpec.put(url);
            case "DELETE" -> requestSpec.delete(url);
            default -> throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        };
    }

}