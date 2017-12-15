package com.mukesh.sel.hybrid.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver ldriver) {
				
		this.driver = ldriver;
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	WebElement signInPageLink;
	
	@FindBy(xpath="//a[contains(text(),'All Courses')]")
	WebElement allCoursesLink;
	
	
	
	public void clickOnSignInLink() {
		
		signInPageLink.click();
	}
	
	public void clickOnAllCoursesLink() {
		
		allCoursesLink.click();
	}
	
	
    public String getApplicationTitle() {
		
		String title = driver.getTitle();
		return title;
	}

}
