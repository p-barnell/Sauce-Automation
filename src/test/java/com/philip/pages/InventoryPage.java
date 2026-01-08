package com.philip.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	// Locators
	// Note: We are getting the list of all items, not just one
	private By itemNames = By.className("inventory_item_name");
	private By addToCartButtons = By.xpath("//button[text()='Add to cart']");
	private By cartBadge = By.className("shopping_cart_badge");
	
	public InventoryPage (WebDriver driver) {
		this.driver = driver;		
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// Actions
	
	/** 
	 * Loops through all items on the page
	 * When it finds one with the name we want, it clicks the corresponding button
	 */
	
	public void addItemToCart(String productName) {
		// 1. Get all the product names into a List
		wait.until(ExpectedConditions.visibilityOfElementLocated(itemNames));	  
		List<WebElement> allProducts = driver.findElements(itemNames);
		
		// 2. Get all the "Add to cart" buttons into a List
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButtons));
		List<WebElement> allButtons = driver.findElements(addToCartButtons);
		
		// 3. Loop through the list
		
		for (int i = 0; i < allProducts.size(); i++) {
			// Get the text of the current item name i.e. backpack
			String currentItemName = allProducts.get(i).getText();
			
			if (currentItemName.equalsIgnoreCase(productName)) {
				allButtons.get(i).click();
				System.out.println("Found and clicked " + productName);
				wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
				break;
			}						
		}
	}
	
	public int getCartItemCount() {
		// If the badge isn't there, Selenium might throw an error
		// So we check if it exists first.
		if (driver.findElements(cartBadge).isEmpty()) {
			System.out.println("Did not find the shopping cart");
			return 0;
		}		
		
		String count = driver.findElement(cartBadge).getText();
		System.out.println("Count value is " + count);
		return Integer.parseInt(count);		
	}
}
