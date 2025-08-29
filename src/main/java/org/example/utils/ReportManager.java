package org.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    //Initialize report once per test run
    public static void initReports()
    {
        if(extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Apple Automation Test Report");
            spark.config().setReportName("UI & API Test Execution");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            //Add Environemntal Dteails
            extent.setSystemInfo("Tester", "QA Architect");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        }
    }

    // Start a test node
    public static void startTest(String testName) {
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
    }

    // Get current test node
    public static ExtentTest getTest() {
        return test.get();
    }

    // Flush report after all tests
    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }

}
