package objectRepository;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import credentials.ExcelData;

public class Radio {
	int totalOptions;
	static int firstRow=0;
	static int secondRow=1;
	// constructor
	public Radio() {
		// System.out.println("Inside RADIO Constructor");

	}
	
	public int getRadioCount( ExcelData exlData, int page, int tab) throws NumberFormatException, IOException
	{
		for (int cell = 1; cell <= exlData.excelColumnCount(tab); cell++) 
			if (exlData.getExcelData(tab, firstRow, cell).toString().contains("Radio_Page" + page)) 
				totalOptions =Integer.parseInt(exlData.getExcelData(tab, secondRow, cell));
		System.out.println("      totalOptions            "+ totalOptions);
		return totalOptions;
	}

	public void getRadioOption(WebDriver Project, int page, int option, ExcelData exlData, int tab,
			int row) throws InterruptedException, IOException {

		for (int cell = 1; cell <= exlData.excelColumnCount(tab); cell++) {
			if (exlData.getExcelData(tab, firstRow, cell).toString().contains("Radio_Page" + page)) {
				
				
				if (row == 1) {
					option = option + 0;

				} else {
					if (option >= row) {
						if (option - row == 0) {

							option = 1;

						} else {

							option = option - row;

						}
					} else if (option <= row) {

						if (option == row) {

							option = row;

						} else if (option < row - option) {  // option 2 and assessment number (row) row 5-2=3  1-5 15 15-5=10
							option = (int) (Math.random() * (option - 1)) + 1;
						//	System.out.println("#######RANDOM            "+ option);
							// option--;
						} else {
							option = row - option;

						}
						//System.out.println("#######option            "+ option);
					}
				}
				Thread.sleep(2000);
				Project.findElement(By.cssSelector("#section" + page + "page1Form label:nth-child(" + option + ") > i"))
						.click();
			//	System.out.println("====== Row====" + row + "==OPTION==" + option);

				break;
			}

		}

	}

}
