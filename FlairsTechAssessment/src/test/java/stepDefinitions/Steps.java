package stepDefinitions;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemUsersPage;




public class Steps {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;
	SystemUsersPage systemUsersPage;
	AddUserPage addUserPage;
	int NumberOfUsersfound ;
	@Before
	public void setUp() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);




	}

	@Given("^I navigate to OrangeHrm Portal$")
	public void user_navigate_to_OrangeHrm_Portal(){


		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.manage().window().maximize();		

	}

	@When("^I Enter \"([^\"]*)\" as username$")
	public void enter_username(String userName) {

		loginPage = new LoginPage(driver);

		loginPage.setUserName(userName);

	}

	@When("^I Enter \"([^\"]*)\" as password$")
	public void enter_password(String password) {
		loginPage.setPassword(password);

	}

	@When ("^I click on the login button$")

	public void click_login() {

		loginPage.clickLoginBtn();

	}


	@When ("^I click on Admin tab on the left side menu$")
	public void click_on_Admin_tab() {

		homepage= new HomePage(driver);

		homepage.clickOnAdminTab();

	}

	@Then("^I could Get the number of users$")

	public void get_number_of_users() {

		systemUsersPage = new SystemUsersPage(driver);

		NumberOfUsersfound = systemUsersPage.getNumberOfUsers();


	}

	@When ("^I Click on add button$")

	public void add_user() {

		systemUsersPage.clickAddUserBtn();

	}


	@When ("^I Fill the required data$")

	public void fill_required_user_data() {

		addUserPage = new AddUserPage(driver);

		addUserPage.fillAllEmployeeInfo();

	}

	@When("^I Click on save button$")

	public void save_user_Info() {

		addUserPage.saveEmployeeInfo();

	}

	@Then("^number of users increased by One$")
	public void get_number_of_users_After_Adding() {

		systemUsersPage = new SystemUsersPage(driver);

		assertEquals(NumberOfUsersfound+1, systemUsersPage.getNumberOfUsers());
	}

	@When ("^I search for the new user$")
	public void search_for_new_user() {

		systemUsersPage.searchForUser();

	}

	@When ("^I deleted the new user$")

	public void delete_new_user(){

		systemUsersPage.deleteUser();

	}
	@Then ("^number of users decreased by One$")
	public void get_number_of_users_After_deletion() {

		systemUsersPage.clickResetBtn();

		assertEquals(NumberOfUsersfound, systemUsersPage.getNumberOfUsers());

	}

	@After
	public void tearDown() {

		driver.quit();


	}




}
