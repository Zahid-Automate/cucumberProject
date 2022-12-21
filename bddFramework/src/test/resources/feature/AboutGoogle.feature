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
@AboutGoogle
Feature: Verify About Google Page

  @AboutGoogleDropDown
  Scenario Outline: Select Dropdown from AboutGoogle Page
    Given website about google
    When user clicks on stories
    And user selects <value> from Stories about dropdown
    Then I validate the text on the button

    Examples: 
      | value           | 
      | crisis response |
    
