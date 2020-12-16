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
  Scenario: Select option by text
    Given user is on the dropdown page
    When user selects "Option 2"
    Then "Option 2" is selected

  @tag2
  Scenario Outline: Select option by text with outline
    Given user is on the dropdown page
    When user selects "<option>"
    Then "<option>" is selected

    Examples: 
      | option  |
      | Option 1 |
      | Option 2 |
