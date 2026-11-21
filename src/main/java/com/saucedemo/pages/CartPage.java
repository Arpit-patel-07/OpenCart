package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By title = By.cssSelector(".title");
    private final By cartItemName = By.cssSelector(".inventory_item_name");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementText(title);
    }

    public String getItemName() {
        return getElementText(cartItemName);
    }

    public void clickCheckout() {
        clickElement(checkoutButton);
    }
}
