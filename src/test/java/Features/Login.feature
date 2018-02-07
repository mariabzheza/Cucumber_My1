Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct user name and password
    Given I navigate to the login page
    And I enter the users email address as Email:admin
    And I verify the count of my salary digits for GBR 1000
    And I enter the following for Login
      | UserName | Password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the user's form page

#  Scenario Outline: Login with correct user name and password using Scenario Outline
#    Given I navigate to the login page
#    And I enter <UserName> and <Password> for Login
#    And I click login button
#    Then I should see the user's form page

#    Examples:
#      | UserName    | Password        |
#      | executeName | executePassword |
#      | admin       | adminpswd       |
#      | qa          | qapasswd        |
