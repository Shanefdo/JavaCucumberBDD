Feature: Login Functionality for OpenCart E-commerce Website

  As a user of the openCart website
  I want to be able to login with my account
  So that I can access my account-related features and manage my orders

  Background:
    Given I am on the OpenCart login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be able to logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username          | password        | error_message                                         |  |
      | invalid@email.com | invalidPassword | Warning: No match for E-Mail Address and/or Password. |  |
      | abccc             | validpassword   | Warning: No match for E-Mail Address and/or Password. |  |
      | valid@email.com   | abccc           | Warning: No match for E-Mail Address and/or Password. |  |

