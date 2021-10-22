package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyElementsPresence {
	
	public WebElement elementPresent(WebDriver driver, WebElement element1, String page) {
		WebElement element2 = element1;
		String elementText=element2.getText();
		if (element2.isDisplayed()) {
			System.out.println(page+ " " +elementText+ " element present");
			//element2.click();
		}else {
			System.out.println(page+ " " +elementText+ " element NOT present");
		}
		return element2;
	}
	

}
