package com.philip.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.philip.pages.*; //Import all pages
import com.philip.utils.ConfigReader;


public class EndToEndTest extends BaseTest {
  
	@Test
	public void testFullPurchaseFlow() {
		// 1. Login
		LoginPage login = new LoginPage(driver);
		login.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		
		// 2. Add item
		InventoryPage invPage = new InventoryPage(driver);
		invPage.addItemToCart("Sauce Labs Backpack");
		invPage.clickShoppingCart();
		
		// 3. Cart Page
		CartPage cart = new CartPage(driver);
		cart.clickCheckout();
		
		// 4. Checkout Page
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.enterDetails("Philip", "Barnell", "B78 1PS"); 
		checkout.FinishOrder();
		
		// 5. Verify
		String message = checkout.getOrderSuccessMessage();
		Assert.assertEquals(message, "Thank you for your order!");		
	}
}
