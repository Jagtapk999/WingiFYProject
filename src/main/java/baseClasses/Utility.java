package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import config.Configuration;

public class Utility {
	public static void takeScreenShot(WebDriver driver,String tcId) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(Configuration.srcshotPath+tcId+"_image.jpg");
		FileHandler.copy(source, dest);
	}
	public static String readExcel(int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream(Configuration.excelPath);
		Sheet sht = WorkbookFactory.create(file).getSheet("Wingify");
		String data = sht.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

}
