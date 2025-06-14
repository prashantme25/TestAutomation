package com.pages;

import org.openqa.selenium.By;

import com.helper.Base;

public class PaymentPage extends Base {

	By FirstName = By.xpath("//input[@id='first-name']");
	By LastName = By.xpath("//input[@id='last-name']");
	By PostalCode = By.xpath("//input[@id='postal-code']");
	By continueBtn = By.xpath("//input[@class='btn_primary cart_button']");
	By finishBtn = By.xpath("//a[@class='btn_action cart_button']");
	By Thankumsg = By.xpath("//h2[@class='complete-header']");

	public void EnterUserDetails(String fname, String lname, String pcode) {

		waitForElement(FirstName).sendKeys(fname);
		waitForElement(LastName).sendKeys(lname);
		waitForElement(PostalCode).sendKeys(pcode);
		clickOnElement(continueBtn);

	}

	public void plaeOrder() {
		clickOnElement(finishBtn);

	}

	public void validateOrderConnfirmation(String message) {
		ValidateText(Thankumsg, message);

	}

}
