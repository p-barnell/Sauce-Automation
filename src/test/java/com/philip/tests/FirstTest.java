package com.philip.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void myFirstAutomation() {
        // 1. Tell Selenium to launch Chrome
        // Note: You don't need to download chromedriver.exe anymore! 
        // Selenium 4.6+ handles it automatically.
        WebDriver driver = new ChromeDriver();

        // 2. Go to a website
        driver.get("https://www.google.com");

        // 3. Print the title to the console to prove we were there
        System.out.println("The page title is: " + driver.getTitle());
        
        // 4. Close the browser (Clean up your mess!)
        driver.quit();
    }
}