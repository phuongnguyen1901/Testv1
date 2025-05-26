Feature: Create new cover letter
  Background: Sign in with valid credential
    Given The login page is showed
    When The user attempt to login with username "phuonglethi1901@gmail.com" and password "Lethiphuong1901"

  Scenario: Create new cover letter
    Given The Cover Letter is showed
    When The User attempt to cover letter
    Then Create cover letter is showed
