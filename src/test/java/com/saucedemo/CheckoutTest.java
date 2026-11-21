package com.saucedemo;

import com.saucedemo.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckoutTest extends BaseTest {
    private ProductsPage productsPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(baseUrl);
        loginPage.login("standard_user", "secret_sauce");
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void testCompleteEndToEndCheckout() {
        // 1. Add product to cart and proceed to cart
        productsPage.addBackpackToCart();
        productsPage.goToCart();

        // 2. Checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // 3. Enter personal information
        CheckoutStepOnePage stepOne = new CheckoutStepOnePage(driver);
        Assertions.assertEquals("Checkout: Your Information", stepOne.getTitle());
        stepOne.fillInformation("John", "Doe", "12345");
        stepOne.clickContinue();

        // 4. Verify order overview and finish
        CheckoutStepTwoPage stepTwo = new CheckoutStepTwoPage(driver);
        Assertions.assertEquals("Checkout: Overview", stepTwo.getTitle());
        Assertions.assertEquals("Sauce Labs Backpack", stepTwo.getItemName());
        Assertions.assertTrue(stepTwo.getItemTotal().contains("29.99"));
        stepTwo.clickFinish();

        // 5. Verify confirmation
        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        Assertions.assertEquals("Checkout: Complete!", completePage.getTitle());
        Assertions.assertEquals("Thank you for your order!", completePage.getCompleteHeader());

        // 6. Return back home
        completePage.clickBackHome();
        Assertions.assertEquals("Products", productsPage.getTitle());
    }

    @Test
    public void testCheckoutMissingFirstName() {
        productsPage.addBackpackToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutStepOnePage stepOne = new CheckoutStepOnePage(driver);
        stepOne.fillInformation("", "Doe", "12345");
        stepOne.clickContinue();

        Assertions.assertTrue(stepOne.getErrorMessage().contains("First Name is required"));
    }

    @Test
    public void testCheckoutMissingPostalCode() {
        productsPage.addBackpackToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutStepOnePage stepOne = new CheckoutStepOnePage(driver);
        stepOne.fillInformation("John", "Doe", "");
        stepOne.clickContinue();

        Assertions.assertTrue(stepOne.getErrorMessage().contains("Postal Code is required"));
    }
}
