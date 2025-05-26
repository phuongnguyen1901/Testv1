Feature:  DK1
  Background: Given login page
    When Tại màn hình đăng ký

  Scenario:  DK_2
    Then Hiển thị các thông tin

  Scenario:  DK_3
    And Nhập email đã tồn tại và nhập các trường khác hợp lệ
    And Click button đăng ký
    Then Hiển thị thông báo lỗi : Email đã được sử dụng

  Scenario:  DK_4
    And  Nhập mật khẩu hợp lệ và nhập xác nhận mật khẩu không khớp với mật khẩu
    And Click button đăng ký
    Then Mật khẩu không khớp. Hãy nhập lại

  Scenario:  DK_5
    And Nhập mật khâu và xác nhận mật khẩu hợp lệ
    Then Click Hiển thị mật khẩu và Hiển thị mật khẩu đã nhập

#  Scenario:  DK_6
#    And Nhập các trường hợp lệ
#    And Click button đăng ký tài khoản người tìm việc
#    Then Hiển thị màn hình gửi mã email thành công