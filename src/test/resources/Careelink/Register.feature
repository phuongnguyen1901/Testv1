Feature: Register
  Scenario: Show Email not available message for email is in used
    Given The registration page is showed
    When The user attempt to register with email is in used
    Then The Message "Email này đã được đăng ký. Vui lòng nhập email khác" will be showed below email field
    And The Email error message is hidden after input valid email not in used

  Scenario: Show password not matched
    Given The registration page is showed
    When The user attempt to register with different password and confirm password
    Then The Message "Mật khẩu không khớp. Hãy nhập lại" will be showed below password field

  Scenario: Show password in clear text
    Given The registration page is showed
    When The user enter password and confirm password then select Show Password option
    Then The password value will be showed in clear text

  Scenario: Show account is created
    Given The registration page is showed
    When The User attempt to register with all valid information with Email "txk2601@gmail.co"
    Then The message Check result singup




#  Scenario: Show homepage with account name after open confirmation link from email
#    Given The user already registered with all valid information
#    When The user open the activation link from email
#    Then The dashboard will be showed with fullname is showed on profile menu header