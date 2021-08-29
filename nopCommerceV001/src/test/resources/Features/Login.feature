Feature: Login

  Scenario: Successful login with valid credentials
    Given User launch chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Page Title shold be "Your store. Login"
    And close browser
