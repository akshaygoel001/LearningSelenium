package com.automationpractice.task_12_jan_2026;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShadowDOMPractice {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        actions = new Actions(driver);
    }

    @Test
    public void fillDummyForm(){
        actions.moveToElement(driver.findElement(By.xpath("//input[@name = 'email']"))).build().perform();
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("abc@gmail.com");

        driver.findElement(By.xpath("//input[@name = 'Password']")).sendKeys("Test123456");

        driver.findElement(By.xpath("//div[@class='userform']/div[1]//input[@name = 'company']")).sendKeys("ABC");

        driver.findElement(By.xpath("//div[@class='userform']/div[1]//input[@name = 'mobile number']")).sendKeys("9876543987");

        driver.findElement(By.xpath("//div[@class='userform']/div[1]//label/input")).sendKeys("India");

        actions.moveToElement(driver.findElement(By.xpath("//div[@class='userform']/button"))).build().perform();
        driver.findElement(By.xpath("//div[@class='userform']/button")).click();

        actions.moveToElement(driver.findElement(By.xpath("//div[@class='userform']/input[@id='inp_val']"))).build().perform();
        driver.findElement(By.xpath("//div[@class='userform']/input[@id='inp_val']")).sendKeys("ABC");

    }

    @Test
    public void shadowDOM(){
        String parentWindow = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement learningHubLink = (WebElement)js.executeScript("return document.querySelector('div#userName').shadowRoot.querySelector('a')");

        actions.moveToElement(learningHubLink).click().build().perform();

        driver.switchTo().window(parentWindow);

        WebElement userName = (WebElement)js.executeScript("return document.querySelector('div#userName').shadowRoot.querySelector('input')");

        actions.moveToElement(userName).build().perform();
        userName.sendKeys("abc");

        WebElement pizzaName = (WebElement)js.executeScript("return document.querySelector('div#userName').shadowRoot.querySelector('div#app2').shadowRoot.querySelector('input')");

        actions.moveToElement(pizzaName).build().perform();
        pizzaName.sendKeys("farmhouse");

    }

    @Test
    public void bottomModal(){
        actions.moveToElement(driver.findElement(By.xpath("//button[@id='myBtn']"))).build().perform();
        driver.findElement(By.xpath("//button[@id='myBtn']")).click();

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-header']/span")));

        driver.findElement(By.xpath("//div[@class='modal-header']/span")).click();

    }

    @Test
    public void paymentPage(){

        actions.moveToElement(driver.findElement(By.xpath("//input[@id='cardName']"))).build().perform();
        driver.findElement(By.xpath("//input[@id='cardName']")).sendKeys("john doe");

        actions.moveToElement(driver.findElement(By.xpath("//input[@id='cardNumber']"))).build().perform();
        driver.findElement(By.xpath("//input[@id='cardNumber']")).sendKeys("1234567812345678");

        actions.moveToElement(driver.findElement(By.xpath("//input[@id='expiry']"))).build().perform();
        driver.findElement(By.xpath("//input[@id='expiry']")).sendKeys("0329");

        actions.moveToElement(driver.findElement(By.xpath("//input[@id='cvv']"))).build().perform();
        driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys("123");

        actions.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).build().perform();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
