Feature: Search job
  Background: Sign in with valid credential
    Given The login page is showed
    When The user attempt to login with username "phuonglethi1901@gmail.com" and password "Lethiphuong1901"

  Scenario: Show search result list
    Given The Homepage is showed
    When The user attempts to search job from Json file
    Then The Job search results is showed on the screen