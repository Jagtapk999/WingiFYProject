package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//input[@id='username']") private WebElement un;
	@FindBy(xpath="//input[@id='password']") private WebElement pass;
	@FindBy(xpath="//button[@id='log-in']") private WebElement loginBtn;
	@FindBy(xpath="//label[@class='form-check-label']") private WebElement rembMe;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void enterUN(String user) {
		un.sendKeys(user);
	}
	public void refershUN() {
		un.clear();
	}
	public void refershPass() {
		pass.clear();
	}
	public void enterPass(String pwd) {
		pass.sendKeys(pwd);
	}
	public void clickOnLogin(){
		loginBtn.click();
	}
	public void clickOnRemMe() {
		rembMe.click();
	}
	

}
