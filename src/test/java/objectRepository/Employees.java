package objectRepository;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import credentials.ExcelData;

public class Employees {
	
	static int firstrow=0;
	
	// constructor
	public Employees() {
		//System.out.println("Inside Employee Constructor");

	}

	public void getEmployee(WebDriver Project, ExcelData exlData, int tab, int row)
			throws InterruptedException, IOException {
		Project.findElement(By.cssSelector("#Q5-QI7-AC94")).clear();
		
		for (int cell = 1; cell <= exlData.excelColumnCount(tab); cell++) {
			
			if (exlData.getExcelData(tab, firstrow, cell).toString().contains("EMP")) {
				// System.out.println("====== EMP VALUE =========" + exlData.getExcelData(tab,
				// row, j,excelLoc).toString());
				Project.findElement(By.cssSelector("#Q5-QI7-AC94"))
						.sendKeys(exlData.getExcelData(tab, row, cell).toString());
				// System.out.println("====== TEST =========" + exlData.getExcelData(tab, row,
				// j,excelLoc).toString()+"==ROW= & COL=====" + row +"======="+j);
				break;
			}
		}

	}
}
