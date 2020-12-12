#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Dropdown functionality

	Background: Web Browser
    Given user launches a web browser
	
  @tag1
  Scenario: Sign in with valid user and pass
    Given user is on the form authentication page
    When user types "tomsmith" into the username field
    And user types "SuperSecretPassword!" into the password field
    And user presses the submit button
    Then the user is on the secure page

  @tag2
  Scenario Outline: Invalid sign in outline
    Given user is on the form authentication page
    When user types "<username>" into the username field
    And user types "<password>" into the password field
    And user presses the submit button
    Then the user is on the login page

    Examples: 
      | username  | password |
      | user | pass |
      | tomsmith | password |
      
