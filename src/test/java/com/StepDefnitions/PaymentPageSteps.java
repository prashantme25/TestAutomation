package com.StepDefnitions;

import com.pages.PaymentPage;
import com.pages.ProductPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentPageSteps {

    ProductPage product = new ProductPage();
    PaymentPage payment = new PaymentPage();

    @When("user add product into the basket")
    public void user_add_product_into_the_basket() {
        product.addtocart();
    }

    @When("user navigate to checkout")
    public void user_navigate_to_checkout() {
        product.clickonCartIcon();
        product.clickOnCheckoutBtn();
    }

  
    @When("user enter FirstName {string} LastName {string} and PostalCode {string}")
    public void user_enter_first_name_last_name_and_postal_code(String fname, String lname, String pcode) {
    	payment.EnterUserDetails(fname, lname, pcode);
    }

    @When("user place an order")
    public void user_place_an_order() {
        payment.plaeOrder();
    }

    @Then("validate the success message {string}")
    public void validate_the_success_message(String message) {
    	payment.validateOrderConnfirmation(message);
      
    }
}