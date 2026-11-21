package tests;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductsTest extends BaseTest {
    private ProductsPage productsPage;

    @BeforeEach
    public void loginBeforeTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(baseUrl);
        loginPage.login("standard_user", "secret_sauce");
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void testAddProductToCart() {
        productsPage.addBackpackToCart();
        Assertions.assertEquals("1", productsPage.getCartCount());
    }

    @Test
    public void testRemoveProductFromCart() {
        productsPage.addBackpackToCart();
        Assertions.assertEquals("1", productsPage.getCartCount());
        productsPage.removeBackpackFromCart();
        Assertions.assertFalse(productsPage.isCartBadgeDisplayed());
    }

    @Test
    public void testNavigateToCart() {
        productsPage.addBackpackToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assertions.assertEquals("Your Cart", cartPage.getTitle());
        Assertions.assertEquals("Sauce Labs Backpack", cartPage.getItemName());
    }
}
