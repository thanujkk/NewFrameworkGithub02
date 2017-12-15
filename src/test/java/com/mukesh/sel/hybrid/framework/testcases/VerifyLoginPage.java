package com.mukesh.sel.hybrid.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.mukesh.sel.hybrid.framework.factory.BrowserFactory;
import com.mukesh.sel.hybrid.framework.factory.DataProviderFactory;
import com.mukesh.sel.hybrid.framework.pages.HomePage;
import com.mukesh.sel.hybrid.framework.pages.LoginPage;

public class VerifyLoginPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = BrowserFactory.getBrowser("firefox");
		
		driver.get(DataProviderFactory.getConfigDataProvider().getApplicationUrl());
	}
	
	
	@Test
	public void testLoginPage() throws Exception {
		
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String actualTitle = home.getApplicationTitle();
		
		String expectedTitle = "Ultimate QA";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		System.out.println("Title Verified");
		
		home.clickOnSignInLink();
		
		Thread.sleep(3000);
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.loginToApplication(DataProviderFactory.getExcelDataProvider().getData(0, 0, 0), DataProviderFactory.getExcelDataProvider().getData(0, 0, 1));
		
		Thread.sleep(3000);
		
		login.verifyMyDashboardLink();
				
				
	}
	
	@AfterMethod
	public void tearDown() {
		
		BrowserFactory.closeBrowser(driver);
	}

}
