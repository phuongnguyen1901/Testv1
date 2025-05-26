Feature: Check when not entering information in 1 of 2 fields
  Background: Sign in with valid credential
    Given The user to login with username and password
    And At the screen to create a cover letter

  Scenario: Cover_letter_3 Check when not entering information in 1 of 2 fields
    When Do not enter Title and import content
    And Click the button Create a cover letter
    Then Show error message error title

  Scenario: Cover_letter_4 Check when not entering information in 1 of 2 fields
    When Enter Title and do not enter content
    And Click the button create letter
    Then Show error message error content

  Scenario: Cover_letter_5 Check when entering information in 2 fields
    When Enter Title and enter content
    And Click the button create a cover
    Then Create mail success