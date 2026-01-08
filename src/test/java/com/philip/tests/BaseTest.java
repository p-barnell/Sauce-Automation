package com.philip.tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.philip.utils.ConfigReader;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
  // We make this "protected" so the Test classes can see the driver
  protected WebDriver driver;
  
  @BeforeMethod
  public void setup() {
	  // 1. Create Options to configure Chrome
	  ChromeOptions options = new ChromeOptions();
	  
	  // 2. Turn off the "Save password" and "Breach Warning" features
	  Map<String, Object> prefs = new HashMap<String, Object>();
	  prefs.put("credentials_enable_service", false);
	  prefs.put("profile.password_manager_enabled", false);
	  options.setExperimentalOption("prefs", prefs);
	  
	  // 3. Add other useful switches (blocks "Show Notifications" popups too)
	  options.addArguments("--disable-notifications");
	  options.addArguments("--incognito");
	  
	  // 4. Start the driver with these options
	  driver = new ChromeDriver(options);
	  
	  // 5. Maximise Window
	  driver.manage().window().maximize();
	  
	  // 6. Set a "Wait" (We will improve this later, but this is fine for now)
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  // 7. Go to URL (Reading from config file!)
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
