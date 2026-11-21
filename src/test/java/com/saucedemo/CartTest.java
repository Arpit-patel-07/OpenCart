package com.saucedemo;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {
    private ProductsPage productsPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(baseUrl);
        loginPage.login("standard_user", "secret_sauce");
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void testViewItemInCart() {
        productsPage.addBackpackToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assertions.assertEquals("Your Cart", cartPage.getTitle());
        Assertions.assertEquals("Sauce Labs Backpack", cartPage.getItemName());
    }

    @Test
    public void testRemoveItemFromCart() {
        productsPage.addBackpackToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assertions.assertTrue(cartPage.isItemDisplayed());

        cartPage.removeBackpack();
        Assertions.assertFalse(cartPage.isItemDisplayed());
    }

    @Test
    public void testContinueShopping() {
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assertions.assertEquals("Your Cart", cartPage.getTitle());

        cartPage.clickContinueShopping();
        Assertions.assertEquals("Products", productsPage.getTitle());
    }
}
