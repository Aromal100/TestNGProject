Feature: Add Ebook

  Scenario Outline: Check Ebook is adding in digitallibrary
    Given User is on login page
    And user clicks on the login button
    Then user give username as "<username>" and clicks on the next button
    Then user need to give password as "<password>" and clicks on the submit button
    And user enters the home page
    Then user need go to the digital library
    And click on the add button
    Then click on the upload ebook
    And then user need to upload the file
    Then need to upload the thumbnail

    Examples: 
      | username       | password    |
      | admin@tria.plc | school@dmin |
