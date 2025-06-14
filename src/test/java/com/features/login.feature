Feature: Login functionality

Background: user in on application



@smoke 
Scenario: Verify login functionality with valid details
When user enter username and password
And user click on login button
Then Validate user is successfully loggedIn