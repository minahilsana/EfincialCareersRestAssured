package org.example.utils;

import java.util.HashMap;
import java.util.Map;

public class SessionStorage {
    private static final Map<String, String> storage = new HashMap<>();

    public static void save(String key, String value) {
        storage.put(key, value);
    }

    public static String get(String key) {
        return storage.get(key);
    }
}
