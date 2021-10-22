package IDCProject.Generic;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ibmSCBN {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception 
  {
    
	//========================================================================================
		String path = System.getProperty("user.dir"); // return project folder path
		System.out.println("project folder path for chrome: "+path);	
		
		String driverpath = path + "\\Chrome\\chromedriver.exe";   // return driver folder path 
		
		System.setProperty("webdriver.chrome.driver",driverpath);
		//==================================================================================================
		
	  
	  
	  driver = new ChromeDriver();
  //  baseUrl = "https://www.blazedemo.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testIbmScbn() throws Exception {
    // Label: Test
    // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1280,578 | ]]
  //  driver.get(baseUrl + "chrome://newtab/");
    driver.get("https://dev-digital-supply-chain.webappuat.com/");
    driver.findElement(By.cssSelector("div.modal-footer.text-center > a.btn.btn-success.btn-rounded.animated.pulse.infinite.waves-effect.waves-light")).click();
    driver.findElement(By.id("begin")).click();
    driver.findElement(By.id("Q1-QI1-AC1")).click();
    driver.findElement(By.id("Q1-QI1-AC1")).clear();
    driver.findElement(By.id("Q1-QI1-AC1")).sendKeys("1Test");
    driver.findElement(By.id("select2-Q2-QI2-container")).click();
    driver.findElement(By.cssSelector("section.custom-section")).click();
    driver.findElement(By.id("select2-Q3-QI4-container")).click();
    driver.findElement(By.id("select2-Q16-QI18-container")).click();
    driver.findElement(By.id("btnNext")).click();
    driver.findElement(By.id("Q4-QI6-AC6")).click();
    driver.findElement(By.id("Q4-QI6-AC6")).clear();
    driver.findElement(By.id("Q4-QI6-AC6")).sendKeys("1,400");
    driver.findElement(By.id("Q5-QI7-AC7")).click();
    driver.findElement(By.cssSelector("#sectionForm2 > div.col-md-12.mx-auto.mb-0 > section.custom-section > div.row > div.col-md-12.text-center.mt-2.mb-3 > #btnNext")).click();
    driver.findElement(By.cssSelector("div.col-md-12.text-center.mt-3.mb-3 > #btnNext")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
