package com.learningselenium.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;

public class TestSelenium11_DriverChange {
    public static void main(String[] args) {


        WebDriver driver1 = new ChromeDriver();
        driver1 = new FirefoxDriver();

        Integer [] a = new Integer[3];
        a[0] = 12;
        a[0] = 112;
        a[0] = 122;
        System.out.println(a);

        ArrayList a1 = new ArrayList();

        a1.add(23);
        a1.add(34); //
        System.out.println(a1);
        System.out.println(a1.toString());


    }
}
