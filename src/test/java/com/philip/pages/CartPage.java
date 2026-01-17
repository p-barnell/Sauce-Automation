package com.philip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CartPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By checkout = By.id("checkout");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(checkout));
		driver.findElement(checkout).click();
	}
}
