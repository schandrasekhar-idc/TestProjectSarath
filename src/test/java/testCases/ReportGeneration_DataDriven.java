package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import credentials.ExcelData;
import credentials.LaunchURL;
import credentials.PickBrowser;

@Test
public class ReportGeneration_DataDriven {
	static int tab=0;
		// @SuppressWarnings("unlikely-arg-type")
	public static void genericLGFucntion() throws IOException, InterruptedException, FileNotFoundException

	{

		// ==========================================================================================================================================//
	
		// EXCEL FILE DECLARATION
		ExcelData exlData = new ExcelData();
		//rowCount is number of assessments user wants to run through excel sheet
		int rowCount =  exlData.excelRowCount(tab);
		rowCount = rowCount-1;
		System.out.println("*****  row count  ** "+ exlData.excelRowCount(tab));
		
		// LAUNCH BROWSER
		PickBrowser browser = new PickBrowser();
		//browser.ChromeBrowserLaunch();
		//WebDriver Project = new ChromeDriver();
		
		//---------------------
		
		
		WebDriver Project = browser.pickBrowser("Chrome");
		//WebDriver Project = browser.pickBrowser("Firefox");
		
		//Browser browser = new Browser();


		
		//------------------------
		
		
		// LAUNCH URL
		LaunchURL urlObj = new LaunchURL();
		String url = urlObj.lauchURL(Project);
		
		// ASSESSMENT OBJECT
		Assessment asmt = new Assessment();
		
		//call assessment function for how many assessments user wants or assessment data present in excel sheet
		
		//for (int i = 1; i <= rowCount; i++) {
		//OR
			for (int i = 1; i <= 3; i++) {
		
			//	System.out.print("ITERATION  " + i);
			// RUN ASSESSMENTS WITH DATA FROM EXCEL SHEET AT GIVEN LOCATION
			asmt.RunAssessment(Project, url, exlData, tab, i);
			System.out.println("TEST CASE " + i + "  is Done.");
		}
		System.out.println("*****  ASSESSMENTS ARE DONE  ******");
     Project.close();
	}
}
