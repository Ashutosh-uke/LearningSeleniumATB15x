package com.learningselenium.exHW3_OrangeHRM_AwesomeQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class awesomeQA {
    @Test
    @Deprecated
    public void orangeHRM_AwesomeQA() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement input_username = driver.findElement(By.xpath("//input[@name='username']"));
        input_username.sendKeys("admin");
        WebElement input_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        input_password.sendKeys("Hacker@4321");
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();

        Thread.sleep(2000);

        String dynamic_rowXpath = "//div[@role='row'][.//div[text()='Terminated']]";

        List<WebElement> terminatedRows = driver.findElements(By.xpath(dynamic_rowXpath));
        Integer totalToProcess = terminatedRows.size();
        System.out.println("Found " + totalToProcess + " terminated employees.");

        // Loop through each row and print the name found in the 3rd column
        for (WebElement row : terminatedRows) {
            String empName = row.findElement(By.xpath(".//div[@role='cell'][3]")).getText();
            System.out.println("Employee Name: " + empName);
        }

        // Click on 1st terminated delete-icon
        WebElement delete_icon = driver.findElement(By.xpath(dynamic_rowXpath + "/parent::div/following-sibling::div//button/i[contains(@class, 'bi-trash')]"));
        delete_icon.click();

        Thread.sleep(1000);

        WebElement pop_for_delete = driver.findElement(By.xpath("//p[normalize-space()='Are you Sure?']"));
        Thread.sleep(2000);
        String pop_for_delete_text = pop_for_delete.getText();
        Assert.assertEquals(pop_for_delete_text, "Are you Sure?");
        Thread.sleep(2000);

        driver.quit();


    }





}
