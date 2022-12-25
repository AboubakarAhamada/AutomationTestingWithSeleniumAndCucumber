Feature: Test Contact Form
  Scenario Outline: Send message with invalid email
    Given user enters "<name>" as name and "<email>" as email
    When user clicks send button
    Then nothing happens
    Examples:
    |name|email|
    |ali   | ali@  |
    |karim benzema|k.benzema|
    |Toni Kroos|@kroos|