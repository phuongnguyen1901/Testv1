Feature:  Check login
  Background: Given login page

  Scenario:  login_1
    Given Kiểm tra màn hình bao gồm các thông tin

  Scenario:  login_2
    Given Nhập thông tin email hợp lệ và nhập password hợp lệ và  Click button Đăng nhập
    Then Đăng nhập thành công, hiển thị màn hình home

  Scenario:  login_3
    Given Nhập password
    Then Click button Hiển thị mật khẩu và Hiển thị mật khẩu đã nhập

  Scenario:  login_4
    Given Nhập email không tồn tại và nhập password hợp lệ và Click button đăng nhập
    Then Hiển thị thông báo lỗi : E-mail hoặc mật khẩu bị sai. Vui lòng đăng nhập lại

  Scenario:  login_5
    And  Nhập email tồn tại và nhập password không hợp lệ và Click button đăng nhập page
    Then E-mail hoặc mật khẩu bị sai. Vui lòng đăng nhập lại

  Scenario:  login_6
    And Click button Quên mật khẩu
    Then Hiển thị màn hình quên mật khẩu

  Scenario:  login_7
    And Click button Đăng kí
    Then Hiển thị màn hình đăng kí


