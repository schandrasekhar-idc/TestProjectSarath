package credentials;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PickBrowser {

	public PickBrowser() {
		//System.out.println("PickBrowser CONSTRUCTOR");

	}

	//---------------------------------
	
	public WebDriver driver;
	public WebDriver DriverList[] = new WebDriver[3];
	
	
	
	public WebDriver pickBrowser(String browser) {

		if (browser == "Chrome") {
			
			//========================================================================================
			/*
			 * String path = System.getProperty("user.dir"); // return project folder path
			 * System.out.println("project folder path for chrome: "+path);
			 * 
			 * String driverpath = path + "\\Chrome\\chromedriver.exe"; // return driver
			 * folder path System.out.println("driverpath: "+driverpath);
			 * System.setProperty("webdriver.chrome.driver",driverpath);
			 * Driver = new ChromeDriver();
			 */
			//====
			 WebDriverManager.chromedriver().setup();

			 ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options); 			
			System.out.println("Browser CHROME");
			return driver;

		} else if (browser == "Edge") {

			// System.setProperty("webdriver.edge.driver", ".\\MicrosoftWebDriver.exe");
			//System.setProperty("webdriver.edge.driver", "driver/MicrosoftWebDriver.exe");
//			System.setProperty("webdriver.edge.driver",
//					"C://Users//akaur//Downloads//edgedriver_win64 (2)//msedgedriver.exe");
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
			return driver;
		}

		else if (browser == "Firefox")

		{
			WebDriverManager.firefoxdriver().setup();
//			  System.setProperty("webdriver.gecko.driver",
//			  "C://Users//akaur//Downloads//geckodriver-v0.30.0-win64//geckodriver.exe");
			 
			driver = new FirefoxDriver();
			return driver;
		}
		return driver;
	}
	
	//-------------------------------------
//	// Chrome
//	public void ChromeBrowserLaunch() {
//		System.setProperty("webdriver.chrome.driver",
//				"C://Users//schandrasekhar//eclipse-workspace//Generic//Chrome//chromedriver.exe");
//		
//		//Chrome Driver Location - C:\Users\schandrasekhar\eclipse-workspace\Generic\Chrome
//		
//	}
//
//	// Edge
//	public void EdgeBrowserLaunch() {
//		// set path to Edge.exe
//		System.setProperty("webdriver.edge.driver", ".\\MicrosoftWebDriver.exe");
//	}
//
//	// Firefox
//	public void FrieFoxBrowserLaunch() {
//
//	}
//	
	

}
