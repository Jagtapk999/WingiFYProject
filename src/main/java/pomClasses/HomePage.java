package pomClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="//div[@id='logged-user-name']") private WebElement UName;
	@FindBy(xpath="//td[@class='text-right bolder nowrap']") private List<WebElement> tBody;
	@FindBy(xpath="//table[@id='transactionsTable']//tr") private List<WebElement> row;
	@FindBy(xpath="//table[@id=\"transactionsTable\"]//th") private List<WebElement> cell;
	@FindBy(id="amount") private WebElement amount;
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public String getUserName() {
		String Unm = UName.getText();
		System.out.println();
		return Unm;
	}
	public void clickOnAmount() {
		amount.click();
	}
	public ArrayList getOriginalData() {
		int elements=tBody.size();
		ArrayList ar=new ArrayList();
		
		for(int i=0;i<=elements-1;i++) {
			String str = tBody.get(i).getText().replaceAll("[A-Z ,]","");
			double t = Double.parseDouble(str);
			ar.add(t);
			
		}
		System.out.println(ar);
		
	return ar;
		
	}
	public ArrayList getTempData() {
		int elements=tBody.size();
		ArrayList temp=new ArrayList();
		for(int i=0;i<=elements-1;i++) {
			String str=tBody.get(i).getText().replaceAll("[A-Z ,]","");
			double t = Double.parseDouble(str);
			temp.add(t);
			
		}
		Collections.sort(temp);
		System.out.println(temp);
	    return temp;
		
	}
	public int getRowCount() {
		int rowSize=row.size();
		return rowSize;
	}
	

}
