package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppleHomePage extends BasePage {

    private WebDriver driver;
    public AppleHomePage(WebDriver driver)
    {
        super("appleHomePage");  //loads webElement locators from appleHomePage.json
        this.driver = driver;
    }

    public void clickAppleLogo()
    {
        driver.findElement(getLocators("applelogo")).click();

    }
    public void clickMac() {
        driver.findElement(getLocators("macLink")).click();
    }

    public void clickiPhone() {
        driver.findElement(getLocators("iPhoneLink")).click();
    }

    public void clickShoppingBag() {
        driver.findElement(getLocators("shoppingBag")).click();
    }

    public void clickSearchButton() {
        driver.findElement(getLocators("searchButton")).click();
    }

    public void enterSearchTerm(String term) {
        WebElement seachInputBox =super.getElement("searchInput");
        seachInputBox.sendKeys(term + "\n");
        seachInputBox.sendKeys(Keys.ENTER);
    }


    public String getPageTitle() {
        return driver.getTitle();
    }
}
