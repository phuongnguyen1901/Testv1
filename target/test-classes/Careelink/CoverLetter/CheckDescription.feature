Feature:  Check when entering content < 10 characters and content > 10 characters
  Background: Sign in with valid credential
    Given The user login with username and password
    And In the screen to create a cover letter

  Scenario:  Check when entering content < 10 characters
    When Enter Valid Title and enter text <10 characters
    And Click the button create
    Then Show error message

  Scenario:  Check when entering content > 10 characters
    And Enter Valid Title and enter text >10 characters
    And Click the button create a cover letter
    Then Create mail successfully
#  "phuonglethi1901@gmail.com"
#  "Lethiphuong1901"