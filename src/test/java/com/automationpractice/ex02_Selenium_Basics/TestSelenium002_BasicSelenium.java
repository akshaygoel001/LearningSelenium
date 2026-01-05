package com.automationpractice.ex02_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium002_BasicSelenium {

    @Test
    public void test_basic(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://google.com");

    }
}
