package com.philip.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.philip.pages.LoginPage;


public class LoginFailTest extends BaseTest {
	
	@Test 
	public void lockedOutUser () {
		LoginPage loginPage = new LoginPage(driver);
		
		//1. Enter a username that we know is locked out
		loginPage.enterUsername("locked_out_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
		
		//2. Check error message is on screen
		String errorMessage = loginPage.getErrorMessage();
		System.out.println("Error found" + errorMessage);
		
		//3. Verify the text matches completely
		Assert.assertTrue(errorMessage.contains("Sorry, this user has been locked out"));
		
	}
}
