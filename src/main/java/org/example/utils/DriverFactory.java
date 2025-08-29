package org.example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    // ThreadLocal for parallel execution
    private  static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Initialize driver based on browser name
    public static void initDriver(String browser)
    {
        WebDriver webDriver = null;

        switch(browser.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;

            case "safari":
                WebDriverManager.safaridriver().setup();
                webDriver = new SafariDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported:" +browser);

        }
        driver.set(webDriver);
        getDriver().manage().window().maximize();
    }

    // Get driver for current thread
    public  static  WebDriver getDriver()
    {
        return  driver.get();
    }

    //Quit driver for current thread
    public  static void quitDriver()
    {
        getDriver().quit();
    }
}
