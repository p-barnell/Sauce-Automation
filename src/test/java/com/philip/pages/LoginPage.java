package com.philip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  private WebDriver driver;
  
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
  }
  
  // 3. ACTIONS (The "Buttons" on the remote control)
  
  public void enterUsername(String username) {
	  driver.findElement(usernameField).sendKeys(username);
  }
  
  public void enterPassword(String password) {
	  driver.findElement(passwordField).sendKeys(password);
  }
  
  public void clickLogin() {
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
	  return driver.findElement(errorMessage).getText();
  }
  
}