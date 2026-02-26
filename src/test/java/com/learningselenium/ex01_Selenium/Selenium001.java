package com.learningselenium.ex01_Selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium001 {
    public static void main(String[] args) {
        // Source here -> (navigate to the google.com)
        // Converted -> JSON Wireprotocol | HTTP Request | api request)
        // Browser Driver | Server (application running on a particular port)
        // Browser Driver -> Real Driver()
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // Source here ->  (nagivate to the google.com)
        //  Converted -> JSON Wireprotocol | HTTP Request | api request)
        //  Browser Driver | Server ( application running on a particulr port)
        // Browser Driver -> Real Driver(

        // Selenium 3-
        // Download the driver binary
        // System.get ---  start the binary

        // Selenium 4
        // Selenium manager (application)
        // Selenium will automatically doawloan the drivers and start)
//
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://app.vwo.com");



    }
}
