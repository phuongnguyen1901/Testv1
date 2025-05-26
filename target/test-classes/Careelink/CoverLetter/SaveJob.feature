Feature:  Check Lưu công việc
  Background: Given login page
    Given Đăng nhập vào trang web

  Scenario:  Save_job_1
    And Nhập 2 trường và click button tìm kiếm
    And Click button lưu
    Then Lưu thành công, button chuyển sang trạng thái lưu thành công

  Scenario:  Save_job_2
    And Tại màn hình lưu công việc
    Then Hiển thị công việc đã lưu
