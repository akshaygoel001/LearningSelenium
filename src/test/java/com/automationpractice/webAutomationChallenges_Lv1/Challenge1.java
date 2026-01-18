package com.automationpractice.webAutomationChallenges_Lv1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.time.Duration;

public class Challenge1 {

    @Test
    public void verifyBalanceAmount(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.applitools.com");

        driver.findElement(By.cssSelector("#username.form-control")).sendKeys("Admin");
        driver.findElement(By.cssSelector("#password.form-control")).sendKeys("Password@123");

        driver.findElement(By.cssSelector("#log-in")).click();
        System.out.println(driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("app.html"));

        int totalTransactions = driver.findElements(By.xpath("//tbody//tr")).size();
        double earned = 0;
        double spent = 0;
        for(int i = 1; i <= totalTransactions ; i++){
            String amount = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[5]/span")).getText();
            if (amount.split(" ")[0].equalsIgnoreCase("+")){
                earned = earned + Double.valueOf(amount.split(" ")[1].replace(",",""));
            } else if (amount.split(" ")[0].equalsIgnoreCase("-")) {
                spent = spent + Double.valueOf(amount.split(" ")[1].replace(",",""));
            }
        }
        System.out.println("Earned = "+earned+" , Spent = "+spent+", Balance = "+(float)(earned - spent));

        DecimalFormat df = new DecimalFormat("#.##");
        Assert.assertEquals(df.format((float)(earned - spent)), "1996.22");

        driver.quit();


    }

}
