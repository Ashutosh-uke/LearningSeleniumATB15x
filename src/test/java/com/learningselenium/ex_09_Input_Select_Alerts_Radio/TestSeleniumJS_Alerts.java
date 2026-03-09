package com.learningselenium.ex_09_Input_Select_Alerts_Radio;
import com.learningselenium.CommonToAll;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.learningselenium.WaitHelpers.waitForAlert;
import static com.learningselenium.WaitHelpers.waitJVM;


public class TestSeleniumJS_Alerts extends CommonToAll{
    @Test
    public void test_Alerts() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        WebElement elementConfirm = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        WebElement elementPrompt= driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));


//        element.click();
//        elementConfirm.click();
        elementPrompt.click();

        waitForAlert(driver,5);

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("PRAMOD");
        alert.accept();
//        alert.dismiss();

        String result = driver.findElement(By.id("result")).getText();
//        Assert.assertEquals(result,"You successfully clicked an alert");
//        Assert.assertEquals(result,"You clicked: Ok");
        Assert.assertEquals(result,"You entered: PRAMOD");



        waitJVM(5000);
        closeBrowser(driver);





    }



}
