package org.example.pages;

import org.example.utils.ReportManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchWorkFlow {

    public static void searchAndValidate(WebDriver driver, String term, String expectedTitle)
    {
        AppleHomePage home = new AppleHomePage(driver);

        home.clickSearchButton();
        home.enterSearchTerm(term);


        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {

        }
        String actualTitle = home.getPageTitle();

        ReportManager.getTest().info("Searching for:" +term);
        ReportManager.getTest().info("Expected Title: " + expectedTitle);
        ReportManager.getTest().info("Actual Title: " + actualTitle);

        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Title mismatch for search: " + term);

        ReportManager.getTest().pass("Search for '" + term + "' validated successfully!");

    }
}
