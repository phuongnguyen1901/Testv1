
Feature: Create CV
  Background: Sign in with valid credential
    Given The login page is showed
    When The user attempt to login with username "phuonglethi1901@gmail.com" and password "Lethiphuong1901"

  Scenario: Show Created Profile in CV List after create CV successfully
    Given The Create CV is showed
    When The User attempt to create CV with their information stored from Json file
    Then The Create CV will be showed in the CV List
