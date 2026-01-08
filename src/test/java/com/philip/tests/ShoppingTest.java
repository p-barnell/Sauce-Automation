package com.philip.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.philip.pages.InventoryPage;
import com.philip.pages.LoginPage;


public class ShoppingTest extends BaseTest {
	
	@Test
	public void testAddBackpackToCart() {
		// 1. Login
		LoginPage loginPage = new LoginPage(driver);	
		loginPage.login("standard_user", "secret_sauce");
		
		// 2. Initialise Inventory Page
		InventoryPage inventoryPage = new InventoryPage(driver);
		
		// 3. Action: Add the specific item
		inventoryPage.addItemToCart("Sauce Labs Backpack");
		
		// 4. Verification: check cart has 1 item
		int itemsInCart = inventoryPage.getCartItemCount();
		System.out.println("Items in cart is " + itemsInCart);
		Assert.assertEquals(itemsInCart, 1);
	}
}
