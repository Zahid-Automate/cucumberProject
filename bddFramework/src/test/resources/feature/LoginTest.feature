Feature: Validation of Login

  @Login
  Scenario Outline: Validating login functionality
    Given I launch the URL
    When I enter existing username "<validUname>" and existing Email "<existingEmail>"
    Then I verify the error message
    And I login with valid credentials "<validUname>" and "<validPwd>"

    Examples: 
      | validUname                | validPwd | existingEmail             |
      | Smitha Chauhan            | changeme | smitachauhan191@gmail.com |
