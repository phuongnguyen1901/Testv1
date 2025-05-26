Feature: Login
  Scenario: The correct type of input field are using on login form
    Given The login page is showed
    Then  The type of email should be email and type of password field should be password

  Scenario: Show password in clear text after select Show password option
    Given The login page is showed
    When The user enter their credential
    And The user select show password option
    Then The password should show in clear text

  Scenario Outline: Show error message for invalid username or wrong password
    Given The login page is showed
    When The user attempt to login with username "<username>" and password "<password>"
    Then The error message "E-Mail hoặc mật khẩu bị sai. Vui lòng nhập lạihss" should be showed
    Examples:
    |username|password|
    |phuong@gmail.com|7654232|
    |phuong@gmail.com|7654232|

  Scenario: Show dashboard for valid credential
    Given The login page is showed
    When The user attempt to login with username "phuonglethi1901@gmail.com" and password "Lethiphuong1901"
    Then The dashboard with user name "Phương" is showed on profile menu

  Scenario: The forgot password is showed
    Given The login page is showed
    When The click button forgot password
    Then Show forgot password page

