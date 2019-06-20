Feature: baidu search
  open baidu and search

  Scenario: baidu  search selenium
    Given Go to baidu.com
    When I find baidu logo
    And Type the search text "selenium"
    And Click the submit
    Then wait the query result