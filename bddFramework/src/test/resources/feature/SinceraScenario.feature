Feature: Sincera Mini project

  @Login
  Scenario Outline: Validating login functionality
    Given I launch the URL
    When I enter existing mail "<existingEmail>"
    Then I verify the error message
    And I login with valid credintials "<validUname>" and "<validPwd>"

    Examples: 
      | validUname                | validPwd | existingEmail             |
      | smitachauhan191@gmail.com | changeme | smitachauhan191@gmail.com |
