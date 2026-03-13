package com.learningselenium.ex_10_Actions_Class;

import com.learningselenium.CommonToAll;
import com.learningselenium.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class Lab_ActionClass_MakeMyTRIP_example {

    @Test
    public void test_makemytrip_flights(){

        WebDriver driver = new FirefoxDriver();
        openBrowser(driver,"https://www.makemytrip.com/");

        WaitHelpers.checkVisibility(driver,By.xpath("//span[@data-cy='closeModal']"),5);

        WebElement signup_model = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        signup_model.click();

        WaitHelpers.checkVisibility(driver,By.xpath("//img[@alt='minimize']"),5);

        WebElement ai_model = driver.findElement(By.xpath("//img[@alt='minimize']"));
        ai_model.click();

        //

        // just to remove the transparent layer.
        WebElement background_element = driver.findElement(By.tagName("body"));
        background_element.click(); // just to remove the transparent layer.

        WaitHelpers.waitJVM(3000);

        WebElement fromCity = driver.findElement(By.xpath("//input[@data-cy='fromCity']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(fromCity).click().build().perform();

        WaitHelpers.waitJVM(2000);

        actions.moveToElement(fromCity).click().sendKeys("IXC").build().perform();

        WaitHelpers.waitJVM(2000);

        try {
            List<WebElement> list_auto_complete_dropdown = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
            for(WebElement suggestions: list_auto_complete_dropdown){
                if(suggestions.getText().contains("Chandigarh")){
                    suggestions.click();
                }
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        WebElement toCity = driver.findElement(By.xpath("//input[@data-cy='toCity']"));
        actions.moveToElement(toCity).click().sendKeys("DEL").build().perform();

        try {
            List<WebElement> list_auto_complete=  driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

            for(WebElement e : list_auto_complete){
                if(e.getText().contains("Del")){
                    e.click();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }






















    }

    private void openBrowser(WebDriver driver, String url) {
    }
}
