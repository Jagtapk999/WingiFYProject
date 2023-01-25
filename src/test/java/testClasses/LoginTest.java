package testClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.Utility;
import baseClasses.baseClass;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class LoginTest {
	WebDriver driver;
	baseClass base;
	LoginPage login;
	HomePage home;
	String tcId;
	@BeforeClass
	public void launchBrowser() {
		base=new baseClass();
		driver=base.initializeBrowser();
		login=new LoginPage(driver);
		home=new HomePage(driver);	
	}
	@BeforeMethod
	public void refersh() {
	//	login.refershUN();
		//login.refershPass();
		//driver.navigate().refresh();
	}
	@Test
	public void tc01() throws InterruptedException {
		tcId="WNG-1";
		Reporter.log("LoginPage Validation",true);
		String actTitle = driver.getTitle();
		String expTitle="Demo App";
		Thread.sleep(2000);
		Assert.assertEquals(actTitle, expTitle);
	}
	@Test
	public void tco2() throws EncryptedDocumentException, IOException, InterruptedException {
		tcId="WNG-2";
		Reporter.log("HomePage Validation",true);
		login.enterUN(Utility.readExcel(1, 0));
		login.enterPass(Utility.readExcel(1, 1));
		login.clickOnLogin();
		Thread.sleep(2000);
	/*	String actTitle=driver.getTitle();
		String expTitle = "Demo App";
		Assert.assertEquals(actTitle, expTitle);
		Thread.sleep(2000);*/
		String actUser=home.getUserName();
		System.out.println(home.getUserName());
		String expUser = "John Doe"; //
		Thread.sleep(2000);
		Assert.assertEquals(actUser, expUser);
		driver.navigate().back();
	}
	@Test(priority=1)
	public void tc03() throws EncryptedDocumentException, IOException, InterruptedException {
		tcId="WNG-3";
		login.enterUN(Utility.readExcel(1, 0));
		login.enterPass(Utility.readExcel(1, 1));
		login.clickOnLogin();
		Thread.sleep(2000);
		home.clickOnAmount();
		Thread.sleep(2000);
		Reporter.log("Table data sorted Validation",true);
		ArrayList actList = home.getOriginalData();
		ArrayList expList = home.getTempData();
		Assert.assertEquals(actList, expList);
		Reporter.log("After Click on Amount Header Options are Sorted");
		driver.navigate().back();
		
	}
	@AfterMethod
	public void take(ITestResult result) throws IOException, InterruptedException {
		if(result.getStatus()==result.FAILURE) {
			Utility.takeScreenShot(driver, tcId);
		}
		Thread.sleep(2000);
		login.refershUN();
		login.refershPass();
	}
	@AfterClass
	public void Close() {
		driver.close();
	}

}
