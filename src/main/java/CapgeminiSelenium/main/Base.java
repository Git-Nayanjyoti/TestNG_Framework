package CapgeminiSelenium.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	


	//Reading which browser to select from CapgeminiSelenium.config
	public Base() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/CapgeminiSelenium/config/config.properties");
			System.out.println(fis);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!!!");
		} catch (IOException e) {
			System.out.println("Unable to read the file!!!");
		}
	}

	//checking what borwser is there in the config file
	public void initialization() {
		logger = Logger.getLogger(Base.class);
		logger.info("Trying to read browser name");
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			logger.info("Identified the browser as " + browser);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("safari")) {
			logger.info("Identified the browser as " + browser);
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (browser.equals("ie")) {
			logger.info("Identified the browser as " + browser);
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		logger.info("Trying to launch the application");
		driver.get(prop.getProperty("url"));
		logger.info("Application launched successfully");
	}

	//method to quit the driver  
	public void tearDown() {
		driver.quit();
		logger.info("Closing the browser");
	}
}