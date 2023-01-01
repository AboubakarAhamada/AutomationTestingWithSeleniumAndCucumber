Feature: Access contact page from home page
  Scenario: Navigate to contact page from the menu
    Given user is one home page
    When user clicks ME CONTACTER link on the menu
    Then user is redirected to contact page