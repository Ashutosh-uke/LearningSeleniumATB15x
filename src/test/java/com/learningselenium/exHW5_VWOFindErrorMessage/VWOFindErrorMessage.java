package com.learningselenium.exHW5_VWOFindErrorMessage;

import com.learningselenium.utils.CommonToAll;
import com.learningselenium.utils.Constants;
import com.learningselenium.utils.WaitHelpers;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class VWOFindErrorMessage extends CommonToAll {

    @Description("Verify that the error message is shown Your email, password, IP address or location did not match")
    @Test
    public void VWOFindErrorMessage()
    {

        driver = new ChromeDriver();
        openBrowser(driver,"https://app.vwo.com/#/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement email_id = waitForVisibility(driver,"//input[@name='username']");
        email_id.sendKeys("admin@admin.com");

        WaitHelpers.waitImplicitWait(driver,100);

        WebElement password = waitForVisibility(driver,"//input[@name='password']");
        password.sendKeys("admin");

        WaitHelpers.waitImplicitWait(driver,100);

        WebElement signin= clickabletoClick(driver,"//button//span[text()='Sign in']");
        signin.click();

        WaitHelpers.waitImplicitWait(driver,100);

        WebElement errMsg = WaitHelpers.checkVisibilityOfAndTextToBePresentInElement(driver, By.xpath("//div[contains(@class,'notification-box-description')]"));

        String actualMsg = errMsg.getText().trim();

        Assert.assertEquals(
                actualMsg,
                Constants.INVALID_LOGIN_ERROR,
                "Login error message mismatch"
        );

        closeBrowser(driver);



    }
}
