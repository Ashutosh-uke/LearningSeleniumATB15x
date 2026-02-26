package com.learningselenium.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestSelenium09_Assertion_TestNG {
    @Test
    public void test_selenium_01(){


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");

        //  TestNG
        // Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/?zx=1771811294977&no_sw_cr=1");
        Assert.assertEquals(driver.getTitle(),"Google");


        // AssertJ
        assertThat(driver.getTitle())
                .isNotBlank()
                .isNotEmpty()
                .isNotNull()
                .isEqualTo("Google");



        driver.quit();


    }
}
