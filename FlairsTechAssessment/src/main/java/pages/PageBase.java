package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	
	static WebDriver driver ;
	
	static WebDriverWait wait;
	
	PageBase(WebDriver driver){
		
		this.driver = driver;
			
		wait = new WebDriverWait(driver, 60);
		
		
	}

}
