Feature: Forgot Password
  Scenario: The correct type of input field are using on forgot password form
    Given The forgot password page is showed
    Then  The type of email should be email and require for input


  Scenario Outline: Show error message for invalid Email
    Given The forgot password page is showed
    When The user attempt to reset password with Email "<email>"
    Then The email not exist message "Your Email address does not exist." should be showed
    Examples:
      |email|
      |phuonglethi1901@gmail.co|
      |phuong@gmail.com|

  Scenario Outline: Show success message for valid email
    Given The forgot password page is showed
    When The user attempt to reset password with Email "<email>"
    Then The success message "Bạn sẽ nhận được tin nhắn chỉ dẫn bằng email và đường link để thay đổi mật khẩu của bạn. Hãy kiểm tra cả thư mục spam" will be showed
    Examples:
      |email|
      |  phuonglethi1901@gmail.com  |
      |khanh@live.com|