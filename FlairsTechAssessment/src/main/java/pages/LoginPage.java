package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {


	public LoginPage(WebDriver driver){

		super(driver);	

	}

	public void setUserName(String userName) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(userName);

	}


	public void setPassword(String password) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(password);


	}


	public void clickLoginBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("button")))).click();
	}


}
