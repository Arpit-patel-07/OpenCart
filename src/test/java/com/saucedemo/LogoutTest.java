package com.saucedemo;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogoutSuccessfully() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(baseUrl);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assertions.assertEquals("Products", productsPage.getTitle());

        productsPage.openMenu();
        productsPage.clickLogout();

        // Verify redirected back to Login page
        Assertions.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
        Assertions.assertTrue(driver.getPageSource().contains("login-button"));
    }
}
