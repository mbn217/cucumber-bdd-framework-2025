Feature: User Access Management
  As a user I want to login to my crater Application

Scenario:  User should be able to login with valid credentials
  Given User is navigated to Crater login page
  When User enters valid username and valid password
  And User clicks on crater application Login button
  Then User should be logged in successfully









#1.	Navigate to the login page.
#2.	Enter a valid email address “entityadmin@primetechschool.com”.
#3.	Enter a valid password “primetech@school”.
#4.	Click on the Login button.
#5.	Verify the user is redirected to the dashboard.
#6.	Verify a success message is displayed.
