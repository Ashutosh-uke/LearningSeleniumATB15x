package com.learningselenium.exHW8_Complete_SignUp;

import com.learningselenium.utils.CommonToAll;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;
import java.util.Set;




public class Complete_SignUp extends CommonToAll {

    @Test
    @Description("Performing complete sign-up process")
    public void complete_SignUp() {

        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        openBrowser(driver,"https://app.vwo.com/#/login");

        //1. Click on Signup
        WebElement sign_Up_button = waitForVisibility(driver,"//a[.//span[text()='Start a FREE TRIAL']]");
        sign_Up_button.click();

        //2. Identify signUp window 2
        /*String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for(String window : allWindows){
            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);
            }
        }*/
        String loginWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        String signUpWindow = "";

        for(String window : allWindows){
            if(!window.equals(loginWindow)){
                driver.switchTo().window(window);
                signUpWindow = window; // We SAVE this ID to come back later!
            }
        }
        System.out.println(driver.getTitle());
        // --- STEP 3: Verify the "Business Email" Error ---
        WebElement email_id = waitForVisibility(driver,"//input[@id='page-v1-step1-email']");
        email_id.sendKeys("normal@gmail.com");

        String error = "gmail.com doesn't look like a business domain.";
        System.out.println(error);

        //div[normalize-space()="gmail.com doesn't look like a business domain. Please use your business email."]

        WebElement errorMessage = waitForVisibility(driver,
                "//div[normalize-space()=\"gmail.com doesn't look like a business domain. Please use your business email.\"]");

        String actualMessage = errorMessage.getText();
        System.out.println(actualMessage);

        assertThat(actualMessage)
                .contains("business domain");

        email_id.clear(); // clean the box

        // --- STEP 4: Get Temp Email (Window 3) ---
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.1secmail.cc");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //  Capture the automatically generated email
        WebElement tempEmailElement = waitForVisibility(driver, "//input[@id='mainEmail']");
        /*// WAIT until the value is no longer "Loading"
        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(d -> !tempEmailElement.getAttribute("value").equalsIgnoreCase("Loading"));
*/
        // 1. Wait until the value is NOT "Loading"
        wait.until(ExpectedConditions.not(
                ExpectedConditions.attributeContains(tempEmailElement, "value", "Loading")
        ));

        // 2. Wait until the value actually contains an '@' symbol
        wait.until(ExpectedConditions.attributeContains(tempEmailElement, "value", "@"));
        String tempEmail = tempEmailElement.getAttribute("value");
        System.out.println("Generated Temp Email: " + tempEmail);

        // --- STEP 5: Switch back to SIGN-UP Window (Window 2) ---
        driver.switchTo().window(signUpWindow);
        Assert.assertNotNull(tempEmail);
        email_id.sendKeys(tempEmail);

        // --- STEP 6: Checkbox & Create Account ---
        WebElement checkboxLabel = driver.findElement(By.xpath("//input[@id='page-free-trial-step1-cu-gdpr-consent-checkbox']"));
        checkboxLabel.click();

        // Use button tag for the final click
        WebElement click_on_create_free_trial_button = waitForVisibility(driver,
                "//div[normalize-space()='Create a Free Trial Account']");
        click_on_create_free_trial_button.click();


        // Providing 1st name and last name


        WebElement first_name = waitForVisibility(driver, "//input[@id='page-v1-fname']");
        first_name.sendKeys("John");

        WebElement last_name = waitForVisibility(driver, "//input[@id='page-v1-lname']");
        last_name.sendKeys("Wick");

        WebElement ph_number = waitForVisibility(driver, "//input[@id='page-v1-pnumber']");
        ph_number.sendKeys("081234 56789");

        /*// Find all buttons with that data-qa
        List<WebElement> buttons = driver.findElements(By.xpath("//button[@data-qa='page-su-submit']"));

// Click the second one (List index starts at 0, so [1] is the second button)
        buttons.get(2).click();*/

        WebElement click_on_button = waitForVisibility(driver, "(//button[@data-qa='page-su-submit'])[2]");
        click_on_button.click();

        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(60));

        //button[@data-step="free-trial-thankyou"]
        WebElement click_on_skip_button = longWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-step='free-trial-thankyou']"))
        );
        click_on_skip_button.click();

        //Continue is showing only while performing automation task with selenium webdriver
        WebElement Continue_Setup_button = longWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@vwo-async-click='vm.continueSetup()']")));
        Continue_Setup_button.click();

        WebElement Choose_data_center = longWait.until(
          ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-qa='koxaloyezi'])[2]")));
        Choose_data_center.click();

        //button[@vwo-async-click="vm.saveDataLocation()"]
        WebElement click_on_save_button =  longWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@vwo-async-click='vm.saveDataLocation()']")));
        click_on_save_button.click();

        WebElement vwo_insights_buttons = longWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("(//button[@vwo-async-click='item.isLoading = true; vm.addProduct(item)'])[2]")));
        vwo_insights_buttons.click();

        WebElement add_domain_button = longWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add domain']")));
        add_domain_button.click();

        WebElement copy_button = longWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@vwo-title='Copy']"))
        );
        copy_button.click();

        String clipboardText = getClipboardText();

        System.out.println("Clipboard Content:\n" + clipboardText);

        assertThat(clipboardText)
                .as("Verify SmartCode copied to clipboard")
                .contains("Start VWO Async SmartCode");





        closeBrowser(driver);






    }
    private String getClipboardText() {
        try {
            java.awt.datatransfer.Clipboard clipboard =
                    java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();

            return (String) clipboard.getData(java.awt.datatransfer.DataFlavor.stringFlavor);

        } catch (Exception e) {
            throw new RuntimeException("Unable to read clipboard", e);
        }
    }

}
