package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class AddUserPage extends PageBase {

	public AddUserPage(WebDriver driver) {

		super(driver);

	}


	public void setUserRole() {

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.className("oxd-select-text--after")).get(0))).click();

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@role='option']/span[text()='Admin']")))).click();





	}

	public void setEmployeeName() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Employee Name']//following::input)[1]"))).sendKeys("T");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option']/span")))).click();
		
  

	}

	public void setEmployeeStatus() {

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.className("oxd-select-text--after")).get(1))).click();

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@role='option']/span[text()='Enabled']")))).click(); 


	}



	public void setEmployeeUsername() {
		
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss");
		Date date = new Date(); 
		String username = "test_"+dateFormat.format(date);
		Helper.username = username;
 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Username']//following::input)[1]"))).sendKeys(username);


	}

	public void setEmployeePassword() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Password']//following::input)[1]"))).sendKeys("Admin123");

	}

	public void confirmEmployeePassword() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Confirm Password']//following::input)[1]"))).sendKeys("Admin123");

	}


	public void fillAllEmployeeInfo() {

		setUserRole();
		setEmployeeName();
		setEmployeeStatus();
		setEmployeeUsername();
		setEmployeePassword();
		confirmEmployeePassword();


	} 

	public void saveEmployeeInfo() {

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@type='submit']")))).click(); 

	}





}
