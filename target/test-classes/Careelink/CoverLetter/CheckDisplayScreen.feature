Feature: Cover_letter_2 Check the display of the cover letter
  Background: Sign in with valid credential
    Given The user login to page with username and password

  Scenario: Check the display of the cover letter creation screen
    Given At the job application screen and at the cover letter folder
    And Click the button Create new mail
    Then Show screen create new mail
