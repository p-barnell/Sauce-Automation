package com.philip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CheckoutPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By firstName = By.id("first-name");
	private By secondName = By.id("last-name");
	private By ZipCode = By.id("postal-code");
	private By continueButton = By.id("continue");
	
	// Overview Step Locators
	private By completeHeader = By.className("complete-header");
	private By finishButton = By.id("finish");
		
	public CheckoutPage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void enterDetails(String firstNameText, String secondNameText, String zipCodeTest) {
		// 1. Wait for the elements to be visible.
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
		
	    // 2. Fill in the customer details
		driver.findElement(firstName).sendKeys(firstNameText);
		driver.findElement(secondName).sendKeys(secondNameText);
		driver.findElement(ZipCode).sendKeys(zipCodeTest);	
		driver.findElement(continueButton).click();
	}
	
	public void ClickContinue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
		driver.findElement(continueButton).click();
	}
	
	public void FinishOrder() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
		driver.findElement(finishButton).click();
	}
	
	public String getOrderSuccessMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader));
		return driver.findElement(completeHeader).getText();
		
	}

}
