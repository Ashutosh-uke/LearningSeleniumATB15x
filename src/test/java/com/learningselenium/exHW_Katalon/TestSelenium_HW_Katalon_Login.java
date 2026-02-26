package com.learningselenium.exHW_Katalon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSelenium_HW_Katalon_Login {

    @Test
    public void testLogin() throws InterruptedException{

        // Driver Managing
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        // Make appointment
        WebElement click_on_button = driver.findElement(By.id("btn-make-appointment"));
        click_on_button.click();

        TimeUnit.SECONDS.sleep(2);

        // Login
        WebElement username_input_box = driver.findElement(By.id("txt-username"));
        username_input_box.sendKeys("John Doe");

        WebElement password_input_box = driver.findElement(By.id("txt-password"));
        password_input_box.sendKeys("ThisIsNotAPassword");

        WebElement login_button = driver.findElement(By.id("btn-login"));
        login_button.click();

        TimeUnit.SECONDS.sleep(2);

//        // Verify success message
//
//        WebElement success_message = driver.findElement(By.tagName("h2"));
//        System.out.println(success_message.getText());
//
//        // Assertions
//
//        Assert.assertEquals(success_message.getText(),"Make Appointment");
//        System.out.println("Test Ex");
//
//
//        //Quit
//        driver.quit();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

        String make_appointment = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(make_appointment, "Make Appointment");

        driver.quit();



    }
}
