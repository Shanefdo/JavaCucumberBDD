package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageStepDefinition {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);

        // throw new io.cucumber.java.PendingException();
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterEmail("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");

        //throw new io.cucumber.java.PendingException();
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickOnLoginButton();

        //throw new io.cucumber.java.PendingException();
    }

    @Then("I should be able to logged in successfully")
    public void i_should_be_able_to_logged_in_successfully() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(loginPage.checkLogoutLink(),true);

        //throw new io.cucumber.java.PendingException();
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
    }
}
