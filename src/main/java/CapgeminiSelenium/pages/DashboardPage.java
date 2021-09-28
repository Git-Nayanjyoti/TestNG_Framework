package CapgeminiSelenium.pages;

import org.openqa.selenium.By;

import CapgeminiSelenium.main.Base;

public class DashboardPage extends Base {

	public boolean validateDashboardTab() {
		return driver.findElement(By.xpath("//b[text()='Dashboard']")).isDisplayed();
	}
}