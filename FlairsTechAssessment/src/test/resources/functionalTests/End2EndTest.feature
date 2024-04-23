Feature: Manage new users in the OrangeHrm Portal
Scenario: Verify adding and deletion of new users in the OrangeHrm Portal
	Given I navigate to OrangeHrm Portal
	When I Enter "Admin" as username
	And I Enter "admin123" as password
	And I click on the login button
	And I click on Admin tab on the left side menu
	Then I could Get the number of users
	When I Click on add button
	And I Fill the required data
	And I Click on save button
	Then number of users increased by One
	When I search for the new user
	And I deleted the new user
	Then number of users decreased by One
	
	
	
	
	
