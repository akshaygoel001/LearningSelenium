package com.automationpractice.coding_challenge_11012025;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Challenge1 {

    @Test
    public void setupAndNavigation(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.close();

    }
}
