package com.learningselenium.ex06_WebTables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSelenium_WebTables2 {
    @Test
    @Description("Test Case Description")
    public void test_web_table_login() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();

        WebElement table_head = driver.findElement(By.xpath("//table[@summary='Sample Table']/thead"));
        WebElement table_footer = driver.findElement(By.xpath("//table[@summary='Sample Table']/tfoot"));

        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        TimeUnit.SECONDS.sleep(2);

        List<WebElement> row_tables = table.findElements(By.tagName("tr"));

        for (int i = 0; i < row_tables.size(); i++) {

            List<WebElement> column_tables = row_tables.get(i).findElements(By.tagName("td"));
            for (WebElement c : column_tables) {
                System.out.println(c.getText());
            }


        }

        TimeUnit.SECONDS.sleep(2);




    }
}
