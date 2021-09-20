package com.bdd.cucum.stepdef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class StepDefination {
    WebDriver driver;
    String appurl = "http://automationpractice.com/";

    @Given("User open the browser")
    public void user_open_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("user maximixe the browser")
    public void user_maximixe_the_browser() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @When("user open the Url {string}")
    public void user_open_the_url(String appurl) {
        driver.get(appurl);
    }

    @Then("user is gets redirected to {string}")
    public void user_is_gets_redirected_to(String appExpectedUrl) {
        Assert.assertEquals("Url redirection is not excepted", appExpectedUrl, driver.getCurrentUrl());
    }

    @Then("user is able to see the app title {string}")
    public void user_is_able_to_see_the_app_title(String Pagetitle) {
        Assert.assertEquals("app title is incorrect", Pagetitle, driver.getTitle());
    }

    @Then("user close the browser")
    public void user_close_the_browser() {
        driver.quit();
    }

    @Then("User is able to see the main categories")
    //public void user_is_able_to_see_the_main_categories(io.cucumber.datatable.DataTable dataTable) {
    public void user_is_able_to_see_the_main_categories(List<String> Categories) {

        List<String> mainCatogiesList = Categories;
        List<WebElement> actualMainCategoriesList = driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li"));
        for (int i = 0; i < mainCatogiesList.size(); i++) {
            Assert.assertEquals(mainCatogiesList.get(i), actualMainCategoriesList.get(i).getText());
        }
    }

    @Then("user is able to see the app logo")
    public void user_is_able_to_see_the_app_logo() {
        boolean logopresent = driver.findElement(By.xpath("//img[@class='logo img-responsive']")).isDisplayed();
        Assert.assertTrue(logopresent);
    }

    @Then("user is able to see logo width={int} and height={int}")
    public void user_is_able_to_see_logo_width_and_height(Integer int1, Integer int2) {
        int width = driver.findElement(By.xpath("//img[@class='logo img-responsive']")).getSize().getWidth();
        int height = driver.findElement(By.xpath("//img[@class='logo img-responsive']")).getSize().getHeight();
        Assert.assertEquals(width, 350);
        Assert.assertEquals(height, 99);
    }

    @Then("And user close the browser")
    public void and_user_close_the_browser() {
        driver.quit();
    }

    @When("And User clicks on signin button")
    public void and_user_clicks_on_signin_button() {
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
    }

    @Then("Then user is able to see the app title {string}")
    public void then_user_is_able_to_see_the_app_title(String Ptitle) {
        Assert.assertEquals("wrong title", Ptitle, driver.getTitle());
    }

    @Given("User clicks on signin button")
    public void user_clicks_on_signin_button() {
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
    }

    @When("user fills new email for registration {string}")
    public void user_fills_new_email_for_registration(String string) {
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("hkghangare@gmail.com");

    }

    @When("user clicks on  create an account button")
    public void user_clicks_on_create_an_account_button() {
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

    }

    @When("user is able to see the text {string}")
    public void user_is_able_to_see_the_text(String text) {
        WebElement gol = driver.findElement(By.xpath("//form[@id='create-account_form']/h3"));
        String title = gol.getText();
        Assert.assertEquals(title, text);
    }

    @Then("user click on Mrs. redio button")
    public void user_click_on_mrs_redio_button() {
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
    }

    @Then("user enters the following details")
    public void user_enters_the_following_details(DataTable expectedCucumberTable) {
        List<String> details = expectedCucumberTable.asList(String.class);
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(details.get(0));
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(details.get(1));
        //driver.findElement(By.xpath("//input[@id='email']")).sendKeys(details.get(2));
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(details.get(2));
    }

    @Then("user select date of birth")
    public void user_select_date_of_birth(DataTable expectedCucumberTable) {
        List<String> details = expectedCucumberTable.asList(String.class);
        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByValue(details.get(0));
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByValue(details.get(1));
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByValue(details.get(2));
        //WebElement day = driver.findElement(By.xpath("//div[@id='uniform-days']"));
    }

    @Then("user click box of {string}")
    public void user_click_box_of(String string) {
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();
    }

    @Then("user fill form for your address section")
    public void user_fill_form_for_your_address_section(DataTable expectedCucumberTable) {
        List<String> yourdetails = expectedCucumberTable.asList(String.class);
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(yourdetails.get(0));
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(yourdetails.get(1));
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(yourdetails.get(2));
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(yourdetails.get(3));
        Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
        state.selectByValue(yourdetails.get(4));
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(yourdetails.get(5));
        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(yourdetails.get(6));
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(yourdetails.get(7));
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(yourdetails.get(8));
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(yourdetails.get(9));
    }

    @Then("user click on register botton")
    public void user_click_on_register_botton() {
        driver.findElement(By.id("submitAccount")).click();
    }
    @Then("User first and last name is displayed as {string} in top right corner")
    public void user_first_and_last_name_is_displayed_as_in_top_right_corner(String name)
    {
        WebElement userfullname = driver.findElement(By.xpath("//a[@title='View my customer account']"));
           Assert.assertEquals("User name is not matching",userfullname.getText(),name);
    }
    @When("User enter his registered id {string}")
    public void user_enter_his_registered_id(String id) {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(id);

    }
    @When("User enters his password {string}")
    public void user_enters_his_password(String pass) {
    driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(pass);
    }
    @When("User clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

        @Then("user verify that the search box enabled or not.")
    public void user_verify_that_the_search_box_enabled_or_not() {
    boolean box = driver.findElement(By.xpath("//input[@id='search_query_top']")).isEnabled();
    Assert.assertTrue("not enable",box);
    }
    @Then("user search {string} in search box")
    public void user_search_in_search_box(String dr) {
         driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(dr);
      List<WebElement> listElement = driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));
       for(int i =0;i<listElement.size();i++) {
           String elementText = listElement.get(i).getText();
           System.out.println(elementText);
        }
    }
    @Then("user is able to see {string} option")
    public void user_is_able_to_see_option(String cha)
    {
   String kk = driver.findElement(By.xpath("(//a[@title='Dresses'][normalize-space()='Dresses'])[2]")).getText();
   Assert.assertEquals(kk,cha);
   driver.findElement(By.xpath("(//a[@title='Dresses'][normalize-space()='Dresses'])[2]")).click();
    }
    @Then("user get price of dresses")
    public void user_get_price_of_dresses(DataTable expectedCucumberTable) {
        List<Float> price = expectedCucumberTable.asList(float.class);
       // List<WebElement> hh = driver.findElements(By.xpath("//span[@itemprop='price']"));
        for(int i =0;i<4;i++) {
        }
        float pvalue = driver.get(i).findElement(By.xpath("//span[@itemprop='price'").
            //String elementText = hh.get(i).getText();
            System.out.println();

    }
    }