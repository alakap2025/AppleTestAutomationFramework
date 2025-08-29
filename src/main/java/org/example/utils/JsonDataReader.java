package org.example.utils;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonDataReader {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode getTestData(String fileName) {
        try {
            InputStream inputStream = JsonDataReader.class.getClassLoader()
                    .getResourceAsStream("testdata/" + fileName + ".json");

            if (inputStream == null) {
                throw new RuntimeException("Test data file not found: " + fileName + ".json");
            }

            return mapper.readTree(inputStream);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON for test data file: " + fileName, e);
        }
    }

    /**
     * Reads a JSON file from pages folder
     * Example: appleHomePage.json
     *
     * @param pageName page JSON file name without extension
     * @return root JsonNode of the page JSON
     */
    public static JSONObject getPageLocators(String pageName) {
        try {
            InputStream inputStream = JsonDataReader.class.getClassLoader()
                    .getResourceAsStream("pageObjects/" + pageName + ".json");

            if (inputStream == null) {
                throw new RuntimeException("Page locator file not found: " + pageName + ".json");
            }

            return new JSONObject(new JSONTokener(inputStream));

        } catch (Exception e) {
            throw new RuntimeException("Failed to read locators JSON for page: " + pageName, e);
        }
    }

    /**
     * Reads an array of test cases from test data JSON
     * Example JSON:
     * {
     *   "searchTests": [
     *     { "searchTerm": "MacBook Pro", "expectedTitle": "MacBook Pro - Apple" },
     *     { "searchTerm": "iPhone 16", "expectedTitle": "iPhone 16 - Apple" }
     *   ]
     * }
     *
     * @param fileName file name without extension
     * @param arrayName name of the array node
     * @return JsonNode array of test cases
     */
    public static JsonNode getTestCases(String fileName, String arrayName) {
        JsonNode root = getTestData(fileName);
        if (!root.has(arrayName)) {
            throw new RuntimeException("Array node not found in JSON: " + arrayName);
        }
        return root.get(arrayName);
    }
}
