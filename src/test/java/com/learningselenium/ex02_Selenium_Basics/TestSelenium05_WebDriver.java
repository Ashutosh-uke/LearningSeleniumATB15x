package com.learningselenium.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium05_WebDriver {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://sdet.live");

    }
}
