package com.mukesh.sel.hybrid.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		
		this.driver=ldriver;
		
	}
	
	
	@FindBy(id="user_email")
	WebElement userNameTextBox;
	
	@FindBy(name="user[password]")
	WebElement passwordTextBox;
	
	@FindBy(id="btn-signin")
	WebElement signInButton;
	
	By myDashboard = By.xpath("//a[contains(text(),'My Dashboard')]");

	
	
	public void loginToApplication(String username, String password) {
		
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		signInButton.click();
	}
	
	public void verifyMyDashboardLink() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(myDashboard));
		
		String text = ele.getText();
		
		Assert.assertTrue(text.contains("My Dashboard"), "My Dashboard link is not verified properly");
		
		System.out.println("My Dashboard link is verified");
	
	}
	

}
