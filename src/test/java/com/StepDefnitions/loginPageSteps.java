package com.StepDefnitions;

import com.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginPageSteps {

    LoginPage login = new LoginPage();

    @When("user enter username and password")
    public void user_enter_username_and_password() {
        login.enterUserAndPassword();
    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        login.clickOnLoginBtn();
    }

    @Then("Validate user is successfully loggedIn")
    public void validate_user_is_successfully_logged_in() {
        
    }
}