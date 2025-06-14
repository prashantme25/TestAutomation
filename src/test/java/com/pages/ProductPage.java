package com.pages;

import org.openqa.selenium.By;

import com.helper.Base;

public class ProductPage extends Base {

	By addtocart = By.xpath("//div[@id='shopping_cart_container']");
	By cartIcon = By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']");
	By checkOutBtn = By.xpath("//a[@class='btn_action checkout_button']");

	public void addtocart() {

		clickOnElement(addtocart);

	}

	public void clickonCartIcon() {
		clickOnElement(cartIcon);

	}

	public void clickOnCheckoutBtn() {
		clickOnElement(checkOutBtn);

	}
}
