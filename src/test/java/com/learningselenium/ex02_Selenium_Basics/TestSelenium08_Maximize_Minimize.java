package com.learningselenium.ex02_Selenium_Basics;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestSelenium08_Maximize_Minimize {
    public static void main(String[] args) {


        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.manage().window().minimize();



    }
}
