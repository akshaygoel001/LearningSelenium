package com.automationpractice.task_21_dec_2025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VWOAutomation {

    @Test
    public void verifyVWOTrial() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

        driver.findElement(By.xpath("//a[contains(text(),'trial')]")).click();
        driver.findElement(By.id("page-v1-step1-email")).sendKeys("acvvddd");

        driver.findElement(By.name("gdpr_consent_checkbox")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Trial')]")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class,'invalid-input-group')]//div"));

        System.out.println(errorMessage.getText());



    }
}
