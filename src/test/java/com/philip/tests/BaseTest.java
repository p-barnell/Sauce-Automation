package com.philip.tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.philip.utils.ConfigReader;

public class BaseTest {
  // We make this "protected" so the Test classes can see the driver
  protected WebDriver driver;
  
  @BeforeMethod
  public void setup() {
	  // 1. Launch Browser
	  driver = new ChromeDriver();
	  
	  // 2. Maximise Window
	  driver.manage().window().maximize();
	  
	  // 3. Set a "Wait" (We will improve this later, but this is fine for now)
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  // 4. Go to URL (Reading from config file!)
	  driver.get(ConfigReader.getProperty("url"));
  }
  
  @AfterMethod
  public void tearDown() {
	  //Close the browser automatically after every test
	  if (driver != null) {
		  driver.quit();
	  }
  }
}
