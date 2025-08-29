package org.example.base;

import org.example.utils.DriverFactory;
import org.example.utils.ReportManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest
{
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser") // browser paramater comes from testng.xml
    public void setUp(@Optional("chrome") String browser)
    {
        //Initialize driver for the given browser
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();

        //Start Reporting for this test
        ReportManager.initReports();
        ReportManager.startTest(browser + "-" +this.getClass().getSimpleName());

    }

    @AfterMethod(alwaysRun = true)
    public  void tearDown()
    {
        if(driver != null)
        {DriverFactory.quitDriver();}
        ReportManager.flushReports();
    }

}
