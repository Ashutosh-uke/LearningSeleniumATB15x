package com.learningselenium.exHW4_DemoQA;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class testseleniumDemoQA {

    @Test
    @Deprecated
    public void manipulationIn_tableOf_employees() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();

        TimeUnit.SECONDS.sleep(2);
        String data = "";
        String dynamic_xpath = "";
        String[][] users = {
                {"Jack", "Ryan", "Jack@example.com", "40", "9000", "Sales"},
                {"Jon", "Doe", "Jon@example.com", "25", "4000", "Legal Department"},
                {"John", "Wick", "John@example.com", "35", "9000", "Sales"},

        };
        // add elements
        for (String[] user : users) {
            driver.findElement(By.xpath("//button[text()='Add']")).click();

            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(user[0]);
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(user[1]);
            driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys(user[2]);
            driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys(user[3]);
            driver.findElement(By.xpath("//input[@placeholder='Salary']")).sendKeys(user[4]);
            driver.findElement(By.xpath("//input[@placeholder='Department']")).sendKeys(user[5]);

            driver.findElement(By.id("submit")).click();
        }

        TimeUnit.SECONDS.sleep(2);

        //table[@class='-striped -highlight table table-striped table-bordered table-hover']/tbody/tr[3]/td[1]

        // printing table after adding element
        String first_part = "//table[@class='-striped -highlight table table-striped table-bordered table-hover']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        Integer row = driver.findElements(By.xpath("//table[@class='-striped -highlight table table-striped table-bordered table-hover']/tbody/tr")).size();
        Integer column = driver.findElements(By.xpath("//table[@class='-striped -highlight table table-striped table-bordered table-hover']/tbody/tr[1]/td")).size();

        // pringting fable
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {

                dynamic_xpath = first_part + i + second_part + j + third_part;
                //System.out.println(dynamic_xpath);
                data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(data);
            }
        }

        //extracting element having department name 'legal department'
        for (int i = 1; i <= row; i++) {
            boolean isProcessed = false; // Flag to stop the entire process
            for (int j = 1; j <= column; j++) {
                dynamic_xpath = first_part + i + second_part + j + third_part;

                data = driver.findElement(By.xpath(dynamic_xpath)).getText();

                if (data.contains("Legal Department")) {

                    String salary_path = dynamic_xpath + "/preceding-sibling::td[1]";
                    String salary_path_text = driver.findElement(By.xpath(salary_path)).getText();
//                    String deletion_path = dynamic_xpath + "/following-sibling::td";
//                    String deletion_path_text = driver.findElement(By.xpath(deletion_path))

                    System.out.println("----");
                    System.out.println("Legal Department salary is " + salary_path_text + " /- ");

                    // editing name and salary
                    WebElement edit_info = driver.findElement(By.xpath(dynamic_xpath + "/following-sibling::td[1]//span[@title='Edit']"));
                    edit_info.click();
                    WebElement First_Name = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
                    TimeUnit.SECONDS.sleep(1);
                    First_Name.clear();
                    First_Name.sendKeys("John ");
                    TimeUnit.SECONDS.sleep(1);
                    WebElement Last_Name = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
                    Last_Name.clear();
                    TimeUnit.SECONDS.sleep(1);
                    Last_Name.sendKeys("Snow");
                    TimeUnit.SECONDS.sleep(1);
                    WebElement Salary = driver.findElement(By.xpath("//input[@placeholder='Salary']"));
                    Salary.clear();
                    TimeUnit.SECONDS.sleep(1);
                    Salary.sendKeys("45000");
                    WebElement submit_button = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
                    submit_button.click();
                    TimeUnit.SECONDS.sleep(1);



                    System.out.println("Edited for row " + i);

                    WebElement delete_info = driver.findElement(By.xpath(dynamic_xpath + "/following-sibling::td[1]//span[@title='Delete']"));
                    delete_info.click();

                    System.out.println("Deleted for row " + i);

                    TimeUnit.SECONDS.sleep(2);
                    isProcessed = true;
                    break; // Exit the inner (column) loop


                }



            }


            if (isProcessed) {
                break;
            }
        }


        driver.quit();

    }


}

