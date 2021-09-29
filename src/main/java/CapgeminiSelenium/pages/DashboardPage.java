package CapgeminiSelenium.pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CapgeminiSelenium.main.Base;

public class DashboardPage extends Base {
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//b[text()='Dashboard']")
	WebElement dashboard;

	public boolean validateDashboardTab() {
		// return driver.findElement(By.xpath("//b[text()='Dashboard']")).isDisplayed();
		return dashboard.isDisplayed();
	}
}