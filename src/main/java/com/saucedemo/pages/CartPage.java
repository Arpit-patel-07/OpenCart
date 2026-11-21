package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By title = By.cssSelector(".title");
    private final By cartItemName = By.cssSelector(".inventory_item_name");
    private final By checkoutButton = By.id("checkout");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By removeBackpackButton = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementText(title);
    }

    public String getItemName() {
        return getElementText(cartItemName);
    }

    public boolean isItemDisplayed() {
        return isElementDisplayed(cartItemName);
    }

    public void clickCheckout() {
        clickElement(checkoutButton);
    }

    public void clickContinueShopping() {
        clickElement(continueShoppingButton);
    }

    public void removeBackpack() {
        clickElement(removeBackpackButton);
    }
}
