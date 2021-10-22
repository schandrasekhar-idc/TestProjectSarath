package objectRepository;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import credentials.ExcelData;

public class Industry {
	static int firstRow=0;	
	// constructor
	public Industry() {
	//	System.out.println("Inside Assessment Constructor");

	}

	public void getIndustry(ExcelData exlData, int tab, int row, WebElement Industry)
			throws InterruptedException, IOException {

		// Select Industry
		//WebElement Industry = Project.findElement(By.cssSelector("#Q4-QI5"));
		
		Industry.click();
		
		Select IndustryClick = new Select(Industry);
		
		for (int cell = 1; cell <= exlData.excelColumnCount(tab); cell++) {
			if (exlData.getExcelData(tab, firstRow, cell).toString().contains("Industry")) {

				IndustryClick.selectByVisibleText(exlData.getExcelData(tab, row, cell).toString());
				break;
			}

		}
	}
	public int getIndustryListSize(WebElement Industry) {
		Select IndustryClick = new Select(Industry);

		// Select selection= new Select(driver.findElement(By.id("Drop down id")));

		// #Q3-QI3 option:nth-child(2)
		// IndustryClick.selectByIndex(2);

		int size = IndustryClick.getOptions().size();
		//System.out.println("Industry cOUNT " + size);
		return size;
	}

	public void getIndustryFromList(WebElement Industry, int Index) throws InterruptedException {
		Select IndustryClick = new Select(Industry);
		//System.out.println("Industry Index  " + Index);
		Thread.sleep(2000);
		// Select selection= new Select(driver.findElement(By.id("Drop down id")));

		// #Q3-QI3 option:nth-child(2)
		IndustryClick.selectByIndex(Index);
		// IndustryClick.selectByValue("Afghanistan");

		//System.out.println("Industry  ");

	}
}
