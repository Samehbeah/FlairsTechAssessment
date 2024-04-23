package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageBase {
	
	
	public HomePage(WebDriver driver) {
		
		super(driver);

	}
	
	
	public void clickOnAdminTab() {
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Admin']")))).click();
		
		
	}




}
