package com.mukesh.sel.hybrid.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.mukesh.sel.hybrid.framework.factory.BrowserFactory;
import com.mukesh.sel.hybrid.framework.factory.DataProviderFactory;
import com.mukesh.sel.hybrid.framework.pages.HomePage;
import com.mukesh.sel.hybrid.framework.pages.LoginPage;
import com.mukesh.sel.hybrid.framework.utility.Helper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyLoginPageWithExtentReportsAndScreenshotsFail {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp() {
		
		report = new ExtentReports("./Reports/LoginPageReport.html", false);
		logger = report.startTest("VerifyLoginPageWithExtentReportsAndScreenshotsFail");
		
		
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfigDataProvider().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "Application is launched");
	
	}
	
	@Test
	public void testHomePage() {
		
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String actualTitle = home.getApplicationTitle();
		
		String expectedTitle = "Ultimate QA";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		logger.log(LogStatus.PASS, "Home page is launched and verified");
		
		System.out.println("Title Verified");
		logger.log(LogStatus.INFO, "Sign in link is clicked");
		
			
	}
	
	
	@Test
	public void testLoginPage() throws Exception {
		
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String actualTitle = home.getApplicationTitle();
		
		String expectedTitle = "Ultimate QA";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		logger.log(LogStatus.PASS, "Home page is launched and verified");
		
		home.clickOnSignInLink();
		
		logger.log(LogStatus.INFO, "Sign in link is clicked");
		
		Thread.sleep(3000);
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.loginToApplication(DataProviderFactory.getExcelDataProvider().getData(0, 0, 0), DataProviderFactory.getExcelDataProvider().getData(0, 0, 2));
		
		logger.log(LogStatus.INFO, "User logged in to application successfully");
		
		Thread.sleep(3000);
		
		login.verifyMyDashboardLink();
		
		Thread.sleep(3000);
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "ValidateMyDashboardLink")));
		
		logger.log(LogStatus.PASS, "My Dashboard link is verified successfully");
				
				
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			String path = Helper.captureScreenshot(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
			
			
		}
		
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
