package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.Configuration;

public class baseClass {
	
	public WebDriver initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", Configuration.driverPath);
		
		WebDriver driver=new ChromeDriver();
		driver.get(Configuration.appUrl);
		driver.manage().window().maximize();
		return driver;
	}

}
