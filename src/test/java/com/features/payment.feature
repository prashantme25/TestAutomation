Feature: Payment functionality

@test
Scenario: Verify user is able to place an order
  When user enter username and password
  And user click on login button
  When user add product into the basket
  And user navigate to checkout
  And user enter FirstName "Test" LastName "Automation" and PostalCode "243122"
  And user place an order
  Then validate the success message "THANK YOU FOR YOUR ORDER"