Feature: Test Contact Form
  Scenario Outline: Send message with invalid email
    Given user enters "<name>" as name and "<email>" as email
    When user clicks send button
    Then user cannot submit message
    Examples:
    |name|email|
    |ali   | ali@  |
    |karim benzema|k.benzema|
    |Toni Kroos|@kroos|

  Scenario: Send message with valid email
    Given user is on contact page
    When user fulled form contact with "Monsieur Bonhomme" as name, "m.bonhome@gmail.com" as email, "Besoin de collaboration" as object and "Appelez moi sur le numéro 0600000000" as message
    And user clicks send message button
    Then user is redirected to CAPTCHA page