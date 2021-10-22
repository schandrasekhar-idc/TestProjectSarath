package objectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import credentials.ExcelData;

public class RegPage
{	
	static int firstRow=0;	
	//constructor
		public  RegPage()
		{
			//System.out.println("Inside Reg Page Constructor");
			
		}
		
	
	
	public void InputRegPage(WebDriver Project, ExcelData exlData, int tab, int row, By by, String inputValue)
			throws InterruptedException, IOException {
		Project.findElement(by).clear();
		for (int cell = 1; cell <= exlData.excelColumnCount(tab); cell++) {
			if (exlData.getExcelData(tab, firstRow, cell).toString().contains(inputValue)) {
			
				Project.findElement(by)
						.sendKeys(exlData.getExcelData(tab, row, cell).toString());
				
						break;
			}
		}

	}

}
