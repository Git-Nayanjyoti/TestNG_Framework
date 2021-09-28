package CapgeminiSelenium.pages;

//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CapgeminiSelenium.main.Base;

public class Loginpage extends Base {

	
	//PageFactory. This is a better way of coding 
	@FindBy(id = "txtUsername")
	WebElement username;

	@FindBy(id = "txtPassword")
	WebElement password;
	
	@FindBy(id = "btnLogin")
	WebElement loginBtn;
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public DashboardPage validateLogin(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		return new DashboardPage();
	}

	//Not a good practice to do it in this way
	/*
	public void validateLogin() throws InterruptedException {
		
	
		driver.findElement(By.id("txtUsername"));
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

	}
	*/
}
