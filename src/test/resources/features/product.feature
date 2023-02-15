Feature: Search Functionality
  As a user, I want to be able to search for products in the demo store so that I can find what I am looking for quickly and easily.

  Scenario Outline: Search for items containing orange
    Given  I use path parameter orange
    When I get status code
      | Status Code   |
      | <Status Code> |
    Then I want to see several products containing orange in their title
      | Existing product   |
      | <Existing product> |
    And I don't see orange products containing non-corresponding titles
      | Non-existing product   |
      | <Non-existing product> |
    Examples:
      | Status Code | Existing product    | Non-existing product       |
      | 200         | Fanta Orange 8-pack | Grapes-Orange 8-pack-Juice |

  Scenario Outline: Search for items containing apple
    Given  I use path parameter apple
    Then I get status code
      | Status Code   |
      | <Status Code> |
    Then I want to see several products containing apple in their title
      | Existing product   |
      | <Existing product> |
    And I don't see apple products containing non-corresponding titles
      | Non-existing product   |
      | <Non-existing product> |
    Examples:
      | Status Code | Existing product                          | Non-existing product |
      | 200         | Apple Bandit Cider juicy apple 0.0 6-pack | Pear Juice           |
