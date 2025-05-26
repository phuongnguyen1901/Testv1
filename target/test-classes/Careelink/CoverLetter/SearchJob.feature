Feature:  Check tìm kiếm công việc
  Background: In login page
    When Đăng nhập vào trang chủ
#    And Ấn button tìm kiếm

  Scenario:  Search_2
    Then Hiển thị các ô input

  Scenario:  Search_3
    And Bỏ trống 2 trường click button tìm kiếm
    Then Hiển thị toàn bộ kết quả

  Scenario:  Search_4
    And Nhập Tên vị trí, công ty từ khóa và click button tìm kiếm
    Then Hiển thị toàn bộ kết quả khi nhập tên vị trí

  Scenario:  Search_5
    And Nhập tỉnh, thành phố và click button tìm kiếm
    Then  Hiển thị toàn bộ kết quả khi nhập tỉnh, thành phố

  Scenario:  Search_6
    And Nhập 2 trường tìm kiếm và click button tìm kiếm
    Then Hiển thị toàn bộ kết quả khi nhập thông tin 2 trường tìm kiếm
