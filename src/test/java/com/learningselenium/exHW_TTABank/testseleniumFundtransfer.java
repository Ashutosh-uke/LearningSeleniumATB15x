package com.learningselenium.exHW_TTABank;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testseleniumFundtransfer {
    @Owner("Ashutosh")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Fund Transfer")
    @Test
    public void Fund_Transfer() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
        driver.manage().window().maximize();

        TimeUnit.SECONDS.sleep(2);
        //Sign UP
        WebElement sign_up = driver.findElement(By.xpath("//button[normalize-space()='Sign Up']"));
        sign_up.click();

        TimeUnit.SECONDS.sleep(2);

        // Provide Username
       // Added quotes around the XPath string
        WebElement username_input_box = driver.findElement(By.xpath("//input[@placeholder='John Doe']"));
        username_input_box.sendKeys("Jack Ryan");

        TimeUnit.SECONDS.sleep(2);

        // Provide Email
        // Fixed the variable reference and the typo in sendKeys
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='you@example.com']"));
        email.sendKeys("jackrayn969742@gmail.com");

        TimeUnit.SECONDS.sleep(2);

        // Provide Password
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Got@123");

        TimeUnit.SECONDS.sleep(2);

        // Click on Create-account
        WebElement createAccount_button = driver.findElement(By.xpath("//button[text()='Create Account']"));
        createAccount_button.click();

        TimeUnit.SECONDS.sleep(2);

        // Click on Transfer-Funds
        WebElement transfer_funds = driver.findElement(By.xpath("//button[normalize-space()='Transfer Funds']"));
        transfer_funds.click();

        TimeUnit.SECONDS.sleep(2);

        WebElement input_number = driver.findElement(By.xpath("//input[@type='number']"));
        input_number.sendKeys("5000");

        TimeUnit.SECONDS.sleep(2);

        // Providing Note as a optional
        WebElement note = driver.findElement(By.xpath("//input[@placeholder='e.g. Rent for October']"));
        note.sendKeys("for a March");

        TimeUnit.SECONDS.sleep(2);

        // Click on Continue button
        WebElement continue_button =  driver.findElement(By.xpath("//button[text()='Continue']"));
        continue_button.click();

        TimeUnit.SECONDS.sleep(2);

        // Confirm transfer
        WebElement confirm_transfer = driver.findElement(By.xpath("//button[normalize-space()='Confirm Transfer']"));
        confirm_transfer.click();

        TimeUnit.SECONDS.sleep(2);

        // Click on Dashboard button
        WebElement dashboard_button = driver.findElement(By.xpath("//button[text()='Dashboard']"));
        dashboard_button.click();

        TimeUnit.SECONDS.sleep(2);

        // Verify remaining balance
        WebElement remaining_amount = driver.findElement(By.xpath("//h3[contains(., '$45,000.00')]"));
        String remaining_amount_text = remaining_amount.getText();
        String expected_amount = "$45,000.00";
        Assert.assertEquals(remaining_amount_text, expected_amount);

        driver.quit();

    }
}
