Feature: Testing credit card api

  
  Scenario Outline: testing POST method
  Given I have the the POST request body with "<name>" and "<email>" and "<address>"
  When I the the URL "http://localhost:8080/eligibility/check"
  Then I should get response code as "200"
  And I should get card details in result
  Examples:
  |name|email|address|
  |Boris|boris@gmail.com|london|
  |Angela|djhsaf@gmail.com|reading|
  |Theresa|djhasv@gmail.com|london|
  
  Scenario Outline: testing POST method with no cards
  Given I have the the POST request body with "<name>" and "<email>" and "<address>"
  When I the the URL "http://localhost:8080/eligibility/check"
  Then I should get response code as "200"
  And I should get no cards for customer
  Examples:
  |name|email|address|
  |amit|boris@gmail.com|london|
  