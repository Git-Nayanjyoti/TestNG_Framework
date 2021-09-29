package CapgeminiSelenium.maintest;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CapgeminiSelenium.main.Base;
import CapgeminiSelenium.pages.Loginpage;
import CapgeminiSelenium.util.ExcelReader;
import CapgeminiSelenium.pages.DashboardPage;



//using inheritance to favour reuse of code
public class AppLoginPageTest extends Base {
	
	ExcelReader reader;
	Loginpage lp;
	DashboardPage dp;

	@BeforeTest
	public void reportSetup() {
		extentReportSetup();
	}
	
	@BeforeMethod
	public void browserSetup() {
		initialization();
		lp = new Loginpage();
	}
	
	@Test(priority = 1)
	public void validateTitleTest() {
		ExtentTest test = extent.createTest("OrangeHRM Title Test");
		logger.info("Starting with validateTitleTest Testcase");
		String expectedTitle = "OrangeHRM";
		String actualTitle = lp.validateTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		test.log(Status.PASS, "Validate title TC Passed");
		logger.info("Completed with validateTittleTest Testcase ");
	}
	
	@Test(priority = 2)
	public void validateLoginTest() throws InterruptedException {
		ExtentTest test = extent.createTest("Validating Login TC");
		logger.info("Starting with validateLoginTest TestCase ");
		//better way to code
		dp = lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		boolean bool = dp.validateDashboardTab();
		Assert.assertTrue(bool);
		logger.info("Completed with validateLoginTest Testcase ");
		test.log(Status.PASS, "Validate Loging TC is Passed");
		
		//not a good practice
		//lp.validateLogin();
	}
	
	@Test(dataProvider = "getData")
	public void validateMultipleLogin(String userName, String password) {
		dp = lp.validateLogin(userName, password);
	}
	
	@DataProvider(name = "getData")
	public Object[][] getLoginData(){
		Object data[][] = null;
		String excelPath = "./src/test/resources/TestData/data.xlsx";
		String sheetName = "data";
		reader = new ExcelReader(excelPath, sheetName);
		data = reader.getTestData();
		return data;
	}
	
	@Parameters({"username", "password"})
	public void getDataFromTestNGXMLFile(String username, String password) {
		System.out.println(username);
	}
	
	@AfterMethod
	public void closeBrowserSetup() {
		tearDown();
	}
	
	@AfterTest
	public void closeReportSetup() {
		closeExtentReportSetup();
	}
}
