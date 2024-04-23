package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SystemUsersPage extends PageBase {
	JavascriptExecutor js;
	public SystemUsersPage(WebDriver driver) {

		super(driver);

	}

	public int getNumberOfUsers() {

		String 	NumberOfUsers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']"))).getText();

		NumberOfUsers = NumberOfUsers.substring(NumberOfUsers.indexOf("(")+1, NumberOfUsers.indexOf(")"));

		System.out.println(NumberOfUsers);

		return Integer.parseInt(NumberOfUsers);


	}


	public void clickAddUserBtn() {


		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()=' Add ']")))).click();

	}

	public void enterUserName() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Username']//following::input)[1]"))).sendKeys(Helper.username);

	}

	public void clickSearchBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()=' Search ']")))).click();		

	}


	public void searchForUser() {
		enterUserName();
		clickSearchBtn();

	}

	public void selectUser() {

		js = (JavascriptExecutor) driver;

		WebElement checkbox=driver.findElement(By.className("oxd-table-card-cell-checkbox"));

		js.executeScript("arguments[0].scrollIntoView();", checkbox);

		wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();		

	}

	public void clickDeleteSelectedBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()=' Delete Selected ']")))).click();		

	}

	public void clickConfirmDeleteBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")))).click();		

	}

	public void clickResetBtn() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='No Records Found']")));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Reset ']"))).click();		

	}

	public void deleteUser() {

		selectUser();
		clickDeleteSelectedBtn();
		clickConfirmDeleteBtn();
	}

}
