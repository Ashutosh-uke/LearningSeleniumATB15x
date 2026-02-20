package org.learningselenium;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium002 {
    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://sdet.live");
        driver.quit();
    }
}
