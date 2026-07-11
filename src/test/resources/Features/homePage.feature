#Author:Jay Mane
@tag
Feature: Verification of Home Page
  
  @tag1 @jay
  Scenario: Verify all the title images are displayed on Home Page 
    Given website is launched successfully and cookies are accepted 
    And user verify "headerPage.logo" element is present on the page
    And user verify "homePage.mainSliderElement" element is present on the page
    
