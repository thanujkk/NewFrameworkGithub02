package com.mukesh.sel.hybrid.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mukesh.sel.hybrid.framework.factory.BrowserFactory;
import com.mukesh.sel.hybrid.framework.factory.DataProviderFactory;
import com.mukesh.sel.hybrid.framework.pages.HomePage;

public class VerifyHomePage {
	
	@Test
	public void testHomePage() {
		
		WebDriver driver = BrowserFactory.getBrowser("firefox");
		
		driver.get(DataProviderFactory.getConfigDataProvider().getApplicationUrl());
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String actualTitle = home.getApplicationTitle();
		
		String expectedTitle = "Ultimate QA";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		System.out.println("Title Verified");
		
		BrowserFactory.closeBrowser(driver);
		
		
	}

}
