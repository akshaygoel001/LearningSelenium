package com.automationpractice.webAutomationChallenges_Lv1;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Challenge2 {

    @Test
    public void webTableVerification(){
        File path = new File("src/test/java/com/automationpractice/ex02_Selenium_Basics/AdBlockers.crx");

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--incognito");
        chromeOptions.addExtensions(path);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/webtables");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='app']//button[@id='addNewRecordButton']")));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[@id='app']//button[@id='addNewRecordButton']"))).click().build().perform();

        //driver.findElement(By.cssSelector("#addNewRecordButton")).click();
        String firstName = "John";
        String lastName = "Doe";
        String email = "abc@gmail.com";
        String age = "23";
        String salary = "2300";
        String dept = "Customs";


        driver.findElement(By.cssSelector("#firstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#lastName")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(email);
        driver.findElement(By.cssSelector("#age")).sendKeys(age);
        driver.findElement(By.cssSelector("#salary")).sendKeys(salary);
        driver.findElement(By.cssSelector("#department")).sendKeys(dept);

        driver.findElement(By.cssSelector("#submit")).click();

        int records = driver.findElements(By.xpath("//div[@class='rt-tbody']/div")).size();

        System.out.println(records);

    }
}
