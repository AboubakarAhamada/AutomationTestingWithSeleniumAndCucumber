Feature: Test Contact Form
  Scenario Outline: Send message with invalid email
    Given user is on the contact page
    When user enters "<name>" as name and "<email>" as email
    And user types "Un projet intéressant pour toi" as subject and "Nous avons besoins d'un ingénieur en automatisation de test" as message
    And user clicks send button
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