#Author:Jay Mane
@tag
Feature: Verification of Login Page

  @tag1 @jay
  Scenario: Verify all the title images fields button are displayed on Login Page
    Given website is launched successfully and cookies are accepted
    And user verify "homePage.companyLogo" element is present on the page
    And user verify "homePage.loginText" element is present on the page
    And user verify "homePage.demoCredentails" element is present on the page
    And user verify "homePage.userNameIcon" element is present on the page
    And user verify "homePage.usernameText" element is present on the page
    And user verify "homePage.userNameInputField" element is present on the page
    And user verify "homePage.passwordIcon" element is present on the page
    And user verify "homePage.passwordText" element is present on the page
    And user verify "homePage.passwordInputField" element is present on the page
    And user verify "homePage.loginButton" element is present on the page
    And user verify "homePage.forgotPasswordLink" element is present on the page
    And user verify "homePage.footerElement" element is present on the page
    And user verify "homePage.footerSocialMediaLinks" element is present on the page
    Then user checks each link present on the page
