package com.learningselenium.HW7_Booking;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.learningselenium.utils.CommonToAll;
import com.learningselenium.utils.Constants;
import com.learningselenium.utils.WaitHelpers;

import java.time.Duration;

public class Select_Delhi_Destination extends CommonToAll {

    @Test
    @Description("Searching for Delhi flights")
    public void search_for_Delhi(){

        driver = new ChromeDriver();
        openBrowser(driver,"https://booking.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement close_modal = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@aria-label='Dismiss sign-in info.']//*[local-name()='svg']")
                )
        );
        close_modal.click();

        WebElement click_on_flights = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='flights']")));
        click_on_flights.click();

        WebElement going_to = driver.findElement(By.xpath("//span[contains(@class,'Text-module__root') and normalize-space()='Going to']"));
        going_to.click();

        WebElement input = driver.findElement(By.xpath("//input[@data-ui-name='input_text_autocomplete']"));
        Actions actions = new Actions(driver);

        actions.moveToElement(input)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys(input, "del")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();


        // Wait for and click search button
        WebElement search_button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[normalize-space()='Explore']]")
        ));
        search_button.click();

        closeBrowser(driver);
    }
}
