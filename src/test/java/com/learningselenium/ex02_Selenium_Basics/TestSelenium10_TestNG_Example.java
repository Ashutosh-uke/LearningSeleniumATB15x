package com.learningselenium.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestSelenium10_TestNG_Example {
    @Test
    public void test_Selenium_app_vwo(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        driver.quit();



    }

}
