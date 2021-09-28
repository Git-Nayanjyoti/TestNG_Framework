package CapgeminiSelenium.maintest;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CapgeminiSelenium.main.Base;
import CapgeminiSelenium.pages.Loginpage;
import CapgeminiSelenium.pages.DashboardPage;

//using inheritance to favour reuse of code
public class AppLoginPageTest extends Base {
	
	Loginpage lp;
	DashboardPage dp;

	@BeforeMethod
	public void browserSetup() {
		initialization();
		lp = new Loginpage();
	}
	
	@Test(priority = 1)
	public void validateTitleTest() {
		logger.info("Starting with validateTitleTest Testcase");
		String expectedTitle = "OrangeHRM";
		String actualTitle = lp.validateTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		logger.info("Completed with validateTittleTest Testcase ");
	}
	
	@Test(priority = 2)
	public void validateLoginTest() throws InterruptedException {
		logger.info("Starting with validateLoginTest TestCase ");
		//better way to code
		dp = lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		boolean bool = dp.validateDashboardTab();
		Assert.assertTrue(bool);
		logger.info("Completed with validateLoginTest Testcase ");
		
		//not a good practice
		//lp.validateLogin();
	}
	
	@AfterMethod
	public void closeBrowserSetup() {
	
	}
}
