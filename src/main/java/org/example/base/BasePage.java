package org.example.base;

import org.example.utils.DriverFactory;
import org.example.utils.JsonDataReader;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    protected JSONObject pageElements;

    public BasePage(String pageName)
    {

        this.driver = DriverFactory.getDriver();
        this.pageElements = JsonDataReader.getPageLocators(pageName);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected By getLocators(String elementName)
    {
        String locatorType = pageElements.getJSONObject(elementName).getString("type");
        String locatorValue = pageElements.getJSONObject(elementName).getString("value");

        switch(locatorType.toLowerCase())
        {
            case "id": return By.id(locatorValue);
            case "xpath": return  By.xpath(locatorValue);
            case "css" : return  By.cssSelector(locatorValue);
            case "name" : return By.name(locatorValue);
            case "classname" : return By.className(locatorValue);
            case "linktext" : return  By.linkText(locatorValue);
            default: throw new IllegalArgumentException("Locator type not supported" +locatorType);
        }
    }

    /**
     * Wait for element to be visible and return WebElement
     */
    public WebElement getElement(String elementName) {
        return wait.until(ExpectedConditions.elementToBeClickable(getLocators(elementName)));
    }

    /**
     * Click on element
     */
    public void click(String elementName) {
        getElement(elementName).click();
    }

    /**
     * Type text into element
     */
    public void type(String elementName, String text) {
        WebElement element = getElement(elementName);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get text from element
     */
    public String getText(String elementName) {
        return getElement(elementName).getText();
    }

    /**
     * Wait for element to be clickable and click
     */
    public void clickWhenClickable(String elementName) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getLocators(elementName)));
        element.click();
    }

    /**
     * Wait for element to be present in DOM
     */
    public WebElement waitForPresence(String elementName) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(getLocators(elementName)));
    }
}
