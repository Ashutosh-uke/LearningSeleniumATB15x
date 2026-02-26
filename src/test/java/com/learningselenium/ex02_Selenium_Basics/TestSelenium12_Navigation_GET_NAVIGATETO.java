package com.learningselenium.ex02_Selenium_Basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class TestSelenium12_Navigation_GET_NAVIGATETO {
    @Test
    public void test_Selenium01(){

        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com"); // 95%

        //  Use Navigation Commands
        // driver.get("url") -> Navigate to a URL


        driver.navigate().to("https://bing.com");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }


}
