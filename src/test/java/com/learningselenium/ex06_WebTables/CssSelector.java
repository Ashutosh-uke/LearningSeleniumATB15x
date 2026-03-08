package com.learningselenium.ex06_WebTables;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CssSelector {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("");

        WebElement table = driver.findElement(By.cssSelector("//table[@summary=\"Sample Table\"]/tbody"));
        String color = table.getAttribute("color");
    }
}
