package com.philip.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.philip.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void validLogin() {
		// 1. The browser is already open at at saucedemo.com
		// (BaseTest.setup() handled this automatically)
		// Create the Page Object
		LoginPage loginPage = new LoginPage(driver);
		
		// 2. User the "Remote Control" methods
		// (SauceDemo standard credentials
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
		
		// 3. Verify we moved to the inventory page
		// Checking the URL is a quick way to verify navigation
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory"), "URL did not contain 'inventory'!");

		
	}	
}
