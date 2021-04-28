Feature: Apply Credit Card page

Scenario: Page Title
Given user is on apply credit card page
When user see the title of the page
Then page  title should be "Cards"

Scenario Outline: Apply for credit card
Given user is on apply credit card page
When user enters name "<name>"
And user enters email "<email>"
And user enters address "<address>"
And user clicks on submit button
Then user should the eligible credit card name "<card_name>"
Examples:
 |name    |email             |address  |card_name|
 |Boris  | boris@gmail.com   |london   |C1|
 |Angela |angelia@gmail.com  |Reading  |C1C2|
 |Theresa|theresa@gmail.com  |Brimigham|C2|
