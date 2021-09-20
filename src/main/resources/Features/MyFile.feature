@smoke
Feature: Test the e-commerce app landing page for smoke test
  1. URL redirection
  2. Landing page title test
  3. Application logo display test
  4. Create an account


  @redirection
  Scenario: Test the Url redirection for the application
    Given User open the browser
    And user maximixe the browser
    When user open the Url "http://automationpractice.com/"
    Then user is gets redirected to "http://automationpractice.com/index.php"
    And user is able to see the app title "My Store"
    And user close the browser

  @productcategory
  Scenario: App main product categary list validation
    Given  User open the browser
    And user maximixe the browser
    And user open the Url "http://automationpractice.com/"
    Then User is able to see the main categories
      | WOMEN    |
      | DRESSES  |
      | T-SHIRTS |
    And user close the browser

  @LogoDisplay
  Scenario: Page application display test
    Given User open the browser
    And user maximixe the browser
    When user open the Url "http://automationpractice.com/"
    Then user is able to see the app logo
    And user is able to see logo width=350 and height=99
    And And user close the browser

  @PageTitletest
  Scenario: Signin Page title test
    Given User open the browser
    And user maximixe the browser
    When user open the Url "http://automationpractice.com/"
    And  And User clicks on signin button
    Then Then user is able to see the app title "Login - My Store"
    And And user close the browser

  @Creataccount
  Scenario: Signin Page title test
    Given User open the browser
    And user maximixe the browser
    And user open the Url "http://automationpractice.com/"
    And  User clicks on signin button
    When user fills new email for registration "ghkolhe@gmail.com"
    And user clicks on  create an account button
    And user is able to see the text "CREATE AN ACCOUNT"
    Then user click on Mrs. redio button
    And user enters the following details
      | Chitrali|
      |Last Name |
      | 1234567 |
    And user select date of birth
        | 2 |
        | 4 |
        | 1990 |
    And user click box of "Sign up for our newsletter"
#    And user click box of "Receive special offers from our partners"
    And user fill form for your address section
      | Techium |
      | Pune   |
      | abc    |
      |  Pune  |
      |   6    |
      | 55140 |
      | jhsdsj |
      |   245624841  |
      |   4458514 |
      |  -my new address|
    And  user click on register botton
    And User first and last name is displayed as "Chaitrali Last Name " in top right corner

  @DressSearch
  Scenario: Search box test
    Given User open the browser
    And user maximixe the browser
    And user open the Url "http://automationpractice.com/"
    And User clicks on signin button
    When User enter his registered id "ghkolhe@gmail.com"
    And User enters his password "1234567"
    And User clicks on sign in button
    Then user verify that the search box enabled or not.
    And user search "Dresses" in search box
    And user close the browser

  @Pricetotal
  Scenario: product price total test
    Given User open the browser
    And user maximixe the browser
    And user open the Url "http://automationpractice.com/"
    And User clicks on signin button
    When User enter his registered id "ghkolhe@gmail.com"
    And User enters his password "1234567"
    And User clicks on sign in button
    Then user is able to see "DRESSES" option
    And user get price of dresses
      | 152.87 |
    And user close the browser