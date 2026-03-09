package com.learningselenium.exHW6_SVG_project_cheapest_mackmini_onFlipKart;

import com.learningselenium.utils.CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;

public class FindCheapestMackMini {

    @Description("Find the cheapest macmini")
    @Test
    public void identifyCheapestMackMiniOnFlipKart() {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Open Flipkart search page
        driver.get("https://www.flipkart.com/search?q=Mac%20Mini&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        //Enter the product name in search box and click on Search icon
//        WebElement searcBbox = driver.findElement(By.xpath("//input[@name='q']"));
//        searcBbox.sendKeys("Mac Mini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();

        //Get the all price details using List
        List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='hZ3P6w']"));

        for(WebElement price : priceElements){
            String text = price.getText();
            System.out.println(text);
        }

        //Convert to Integer and Find min value
        int minPrice = Integer.MAX_VALUE;
        for(WebElement price : priceElements){
            String text = price.getText();
            text = text.replace("₹","").replace(",","");
            int value = Integer.parseInt(text);
            if(value < minPrice){
                minPrice = value;
            }
        }
        System.out.println("Minimum Price: ₹" + minPrice);

    }

}


