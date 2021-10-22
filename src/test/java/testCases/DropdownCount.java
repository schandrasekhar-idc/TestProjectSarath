package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import credentials.ExcelData;
import credentials.ElementLocators;
import objectRepository.Checkbox;
import objectRepository.Country;
import objectRepository.Employees;
import objectRepository.Industry;
import objectRepository.InputMisc;
import objectRepository.Radio;
import objectRepository.RegPage;

public class DropdownCount {

	int toolPage;
	int radio_Options;
	int checkBox_Options;

	// constructor
	public DropdownCount() {
		// System.out.println("Inside Assessment Constructor");

	}

	public int[] getDropdownCount(WebDriver Project, String url, ExcelData exlData, int tab, int row)
			throws InterruptedException, IOException {

		// declarations
		ElementLocators el = new ElementLocators(Project);
		Radio radioOption = new Radio();
		Checkbox chbox = new Checkbox();
		InputMisc inputMisc = new InputMisc();
		RegPage rPage = new RegPage();
		// array keep count of each list, [0] has country and [1] has industry
		int dropdownList[] = new int[2];

//		Project.manage().window().maximize();
//		Project.get(url);
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		String titlecs = Project.getTitle();
		System.out.println("Text from dev site: TOOL NAME: " + titlecs);

		// Close - Dev Site pop-up modal
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		Thread.sleep(10000);
		Project.findElement(el.DevRibbonBttn).click();

		// AGREE AND CONTINUE - Cookie
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		Thread.sleep(10000);
		if (row == 1)
			//Project.findElement(el.ConsentBttn).click();

		
			
			//==========Consent verify and click===============================================================
			
		{
		
		
			WebElement ConsentBtn = Project.findElement(By.xpath("//*[@id='consent']"));   ////*[@id="consent"]
				if (ConsentBtn.isDisplayed())
					{

						System.out.println("consent exists: "+ConsentBtn);
		
						ConsentBtn.click();
		
		
					}
				else
					{
						System.out.println("consent does not exist");
					} 
	
		}
	
	// ==========================================================================================================================================//

	
			
			// ==========================================================================================================================================//

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		 Thread.sleep(10000);

		// Click - Begin Assessment
		Project.findElement(el.BeginAsmtBttn).click();
		// System.out.println("Begin Assessment button is clicked");
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		 Thread.sleep(10000);
		/////////////////////////////////////// PAGE1
		System.out.println("======PAGE 1 =========");
		Thread.sleep(5000);
		Project.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		toolPage = 1; // radio_Options=8;

		// to get radio options count
		radio_Options = radioOption.getRadioCount(exlData, toolPage, tab);
		radioOption.getRadioOption(Project, toolPage, radio_Options, exlData, tab, row);

		Project.findElement(el.Page1NxtBttn).click();
		// Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		Thread.sleep(2000);
		////////////////////////////////////////////////// PAGE 2
		System.out.println("======PAGE 2 =========");
		Thread.sleep(5000);
		// RADIO 2

		toolPage = 2;

		// to get radio options count
		radio_Options = radioOption.getRadioCount(exlData, toolPage, tab);
		radioOption.getRadioOption(Project, toolPage, radio_Options, exlData, tab, row);

		// Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		Thread.sleep(2000);

		Project.findElement(el.Page2NxtBttn).click();
		Thread.sleep(2000);

		////////////////////////////////////////////////// PAGE 3
		System.out.println("======PAGE 3 =========");
		Thread.sleep(5000);
		Country countryVal = new Country();
		Thread.sleep(2000);
		// countryVal.getCountryFromList(Project.findElement(el.Country),1);
		countryVal.getCountryFromList(Project.findElement(el.Country), row);
		dropdownList[0] = countryVal.getCountryListSize(Project.findElement(el.Country));
		// System.out.println("======PAGE 3 COUNTRY LIST SIZE ========="+ a[0]);
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// Thread.sleep(20000);

		// Select Industry
		Industry industryValue = new Industry();
		industryValue.getIndustryFromList(Project.findElement(el.Industry), row);
		dropdownList[1] = industryValue.getIndustryListSize(Project.findElement(el.Industry));
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// Get Employees
		Employees emp = new Employees();
		emp.getEmployee(Project, exlData, tab, row);

		Project.findElement(el.Page3NxtBttn).click();

		////////////////////////////////////////////////// PAGE 4
		System.out.println("======PAGE 4 =========");
		Thread.sleep(5000);

		Project.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		inputMisc.getInput(Project, exlData, tab, row, el.MiscInput0);

		Project.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Thread.sleep(20000);
		// CHECKBOX

		toolPage = 4;
		// to get check options count

		checkBox_Options = chbox.getCheckCount(exlData, toolPage, tab);

		chbox.getCheckboxOption(Project, toolPage, checkBox_Options, exlData, tab, row);

		Project.findElement(el.Page4NxtBttn).click();

		////////////////////////////////////////////////// PAGE 5
		System.out.println("======PAGE 5 =========");
		Thread.sleep(5000);
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		inputMisc.getInput(Project, exlData, tab, row, el.MiscInput1);

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		inputMisc.getInput(Project, exlData, tab, row, el.MiscInput2);

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		inputMisc.getInput(Project, exlData, tab, row, el.MiscInput3);

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		inputMisc.getInput(Project, exlData, tab, row, el.MiscInput4);
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		inputMisc.getInput(Project, exlData, tab, row, el.MiscInput5);

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		inputMisc.getInput(Project, exlData, tab, row, el.MiscInput6);

		Project.findElement(el.Page5NxtBttn).click();
		////////////////////////////////////////////////// PAGE 6
		System.out.println("======PAGE 6 =========");
		Thread.sleep(5000);
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		inputMisc.getInput(Project, exlData, tab, row, el.MiscInput7);
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		inputMisc.getInput(Project, exlData, tab, row, el.MiscInput8);

		Project.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// SLIDER
		WebElement slider = Project.findElement(el.Slider1);
		// new Actions(Project).dragAndDropBy(slider, 12000, 0).build().perform();
		Thread.sleep(5000);
		new Actions(Project).clickAndHold(slider).moveByOffset(100, 0).release().perform();

		Project.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		inputMisc.getInput(Project, exlData, tab, row, el.MiscInput9);

		Project.findElement(el.Page6NxtBttn).click();

		////////////////////////////////////////////////// REG PAGE
		System.out.println("===== REG PAGE ======");
		Thread.sleep(5000);
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		rPage.InputRegPage(Project, exlData, tab, row, el.FirstName, "FirstName");

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		rPage.InputRegPage(Project, exlData, tab, row, el.LastName, "LastName");

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		rPage.InputRegPage(Project, exlData, tab, row, el.email, "Email");

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		rPage.InputRegPage(Project, exlData, tab, row, el.CompanyName, "CompanyName");

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		Project.findElement(el.ThankYou).click();
		// Project.findElement(By.xpath("//a[@href='https://www.redirecturl.com/']")).click();
		return dropdownList;
		////////////////////////////////////////////////// DONE

	}

}
