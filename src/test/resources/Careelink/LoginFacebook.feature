Feature: Check login facebook
  Background: Sign in with valid credential
    Given The login page is showed
    When The user attempt to login with username "phuonglethi1901@gmail.com" and password "Lethiphuong1901"

Scenario: Đăng nhập facebook with username and password
  When Điền thông tin user và password
  And Click button đăng nhập
  Then Thực hiện bắn lỗi không thể đăng nhập thành công

Scenario: Đăng nhập facebook with username
  When Điền thông tin user
  And Click button login
  Then Kiểm tra thông tin lỗi thiếu password trên màn hình

Scenario: Đăng nhập facebook with password
  When Điền thông tin password
  And button đăng nhập
  Then Kiểm tra thông tin lỗi không điền username trên màn hình