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
  Scenario: Click a checkbox
    Given user is on the checkbox page
    When user clicks the "checkbox 1" box
    Then the "checkbox 1" box is "checked"

  @tag2
  Scenario Outline: Click a checkbox with outline
    Given user is on the checkbox page
    When user clicks the "<label>" box
    Then the "<label>" box is "<desiredState>"

    Examples: 
      | label  | desiredState |
      | checkbox 1 | checked |
      | checkbox 2 | unchecked |
