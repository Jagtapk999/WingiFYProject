package pomClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import config.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Wingify {
	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", Configuration.driverPath);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(Configuration.appUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ASC");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123e");
		driver.findElement(By.xpath("//button[@id='log-in']")).click();
		Thread.sleep(2000);

		List<WebElement> elements = driver.findElements(By.xpath("//td[@class='text-right bolder nowrap']"));
		for (int i = 0; i <= elements.size() - 1; i++) {
			//System.out.print(elements.get(i).getText()+" ");
		}
		driver.findElement(By.id("amount")).click();
		List<WebElement> elements1 = driver.findElements(By.xpath("//td[@class='text-right bolder nowrap']"));

		System.out.println();
		ArrayList ar=new ArrayList();
		for (int i = 0; i <= elements1.size() - 1; i++) {
			ar.add(elements1.get(i).getText());
		}
		System.out.println(ar);
		Thread.sleep(2000);
		//
		Collections.reverse(ar);
		Collections.sort(ar);
		System.out.println(ar);

		driver.close();
	}

}
