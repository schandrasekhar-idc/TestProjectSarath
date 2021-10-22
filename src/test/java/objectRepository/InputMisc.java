package objectRepository;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import credentials.ExcelData;

public class InputMisc
{	
	static int firstRow=0;	
	//constructor
		public  InputMisc()
		{
			//System.out.println("Inside Misc Input  Constructor");
			
		}

	
		public void getInput(WebDriver Project, ExcelData exlData, int tab, int row, By by)
				throws InterruptedException, IOException {
			Project.findElement(by).clear();
			for (int cell = 1; cell <= exlData.excelColumnCount(tab); cell++) {
				if (exlData.getExcelData(tab, firstRow, cell).toString().contains("MiscInput")) {
					Project.findElement(by)
							.sendKeys(exlData.getExcelData(tab, row, cell).toString());
						break;
				}
			}

		}
}
