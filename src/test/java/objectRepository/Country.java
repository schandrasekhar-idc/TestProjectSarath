package objectRepository;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import credentials.ExcelData;

public class Country {
	static int firstRow=0;	
	// constructor
	public Country() {
		// System.out.println("Inside Assessment Constructor");

	}

	public void getCountry(ExcelData exlData, int tab, int row, WebElement Country)
			throws InterruptedException, IOException {
		// WebElement Country = Project.findElement(By.cssSelector("#Q3-QI3"));

		// Country.click();
		// System.out.println("Country clicked"); #Q3-QI3
Thread.sleep(5000);
		Select CountryClick = new Select(Country);

		for (int cell = 1; cell <= exlData.excelColumnCount(tab); cell++) {
			//if (exlData.getExcelData(tab, firstRow, cell).toString().contains("Industry")) {
			if (exlData.getExcelData(tab, firstRow, cell).toString().contains("Country")) {
				System.out.println("Country -------------" + exlData.getExcelData(tab, row, cell).toString());
				Thread.sleep(2000);
				CountryClick.selectByValue(exlData.getExcelData(tab, row, cell).toString());
				break;
			}
		}

	}

	public int getCountryListSize(WebElement Country) {
		Select CountryClick = new Select(Country);

		// Select selection= new Select(driver.findElement(By.id("Drop down id")));

		// #Q3-QI3 option:nth-child(2)
		// CountryClick.selectByIndex(2);

		int size = CountryClick.getOptions().size();
		//	System.out.println("Country " + size);
		return size;
	}

	public void getCountryFromList(WebElement Country, int Index) throws InterruptedException {
		Select CountryClick = new Select(Country);
		//System.out.println("Country Index  " + Index);
		Thread.sleep(2000);
		// Select selection= new Select(driver.findElement(By.id("Drop down id")));

		// #Q3-QI3 option:nth-child(2)
		CountryClick.selectByIndex(Index);
		// CountryClick.selectByValue("Afghanistan");

		System.out.println("  Country  ");

	}
}
