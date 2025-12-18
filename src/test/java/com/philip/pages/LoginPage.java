package com.philip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
  private WebDriver driver;
  private WebDriverWait wait;
  
  // 1. LOCATORS (The "map" of the page)
  // We keep these private so the Test doesn't touch them directly
  private By usernameField = By.id("user-name");
  private By passwordField = By.id("password");
  private By loginButton = By.id("login-button");
  private By errorMessage = By.cssSelector("h3[data-test='error']");
  
  // 2. CONSTRUCTOR
  // The test passes the 'driver' to this class so it can control the browser.
  public LoginPage(WebDriver driver) {
	  this.driver = driver;
	  // Initialise the wait (Give it a 10-second timeout)
	  this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }
  
  // 3. ACTIONS (The "Buttons" on the remote control)
  
  public void enterUsername(String username) {
	  //wait until the box is visible, then type
	  wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));	  
	  driver.findElement(usernameField).sendKeys(username);
  }
  
  public void enterPassword(String password) {
	  //wait until the box is visible, then type
	  wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
	  driver.findElement(passwordField).sendKeys(password);
  }
  
  public void clickLogin() {
	  //wait until the button is visible, then click
	  wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
	  driver.findElement(loginButton).click();
  }
  
  //A helper method to do it all in one step
  public void login(String user, String password) {
	  enterUsername(user);
	  enterPassword(password);
	  clickLogin();
  }
  
  // For negative testing later
  public String getErrorMessage() {
	  //wait until the error message is on the screen
	  wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
	  return driver.findElement(errorMessage).getText();
  }
  
}