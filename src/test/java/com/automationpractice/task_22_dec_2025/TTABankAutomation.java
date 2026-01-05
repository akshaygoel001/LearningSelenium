package com.automationpractice.task_22_dec_2025;

import com.automationpractice.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TTABankAutomation extends CommonToAll {

    @Description("TC#1 - Verify that beneficiary is added successfully")
    @Owner("Akshay Goel")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void manageBeneficiaryFlow() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");

        // sign up clicked
        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();


        // full name
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("John doe");

        // email
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ab5@gmail.com");

        // password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test123456");

        // create account
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        customWait(2000);

        // transfer funds
        driver.findElement(By.xpath("//button[contains(text(),'Transfer Funds')]")).click();

        // manage beneficiary button
        driver.findElement(By.xpath("//button[contains(text(),'Manage Beneficiaries')]")).click();

        String beneficiary = "John dow";
        // full name
        driver.findElement(By.xpath("//label[text()='Full Name']//..//input[@type='text']")).sendKeys(beneficiary);

        // bank name
        driver.findElement(By.xpath("//label[text()='Bank Name']//..//input[@type='text']")).sendKeys("Citibank");

        // account number
        driver.findElement(By.xpath("//label[text()='Account Number']//..//input[@type='text']")).sendKeys("12345678");

        // save beneficiary button
        driver.findElement(By.xpath("//button[contains(text(),'Save Beneficiary')]")).click();

        // manage beneficiary button
        driver.findElement(By.xpath("//button[contains(text(),'Manage Beneficiaries')]")).click();

        boolean isbeneficiaryDisplayed = driver.findElement(By.xpath("//p[contains(text(),'"+beneficiary+"')]")).isDisplayed();

        if (isbeneficiaryDisplayed){
            System.out.println("Beneficiary added successfully...");
        }

        closeBrowser(driver);



    }
}
