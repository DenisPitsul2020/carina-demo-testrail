package com.gurock.testrail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRailManager {

    public static final String TEST_RUN_ID = "17";
    public static final String TESTRAIL_USERNAME = "dpitsul@solvd.com";
    public static final String TESTRAIL_PASSWORD = "Denia261298";
    public static final String RAILS_ENGINE_URL = "https://opendata.testrail.net/";
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;

    public TestRailManager() { }

    public static void addResultForTestCases(String testCaseId, int status, String error) throws IOException, APIException {

        APIClient client = new APIClient(RAILS_ENGINE_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);
        Map<String, Object> data = new HashMap<>();
        data.put("status_id", status);
        data.put("comment", "Test Executed - Status updated automatically from selenium test automation");
        client.sendPost("add_result_for_case/" + TEST_RUN_ID + "/" + testCaseId + "", data);
    }

}
