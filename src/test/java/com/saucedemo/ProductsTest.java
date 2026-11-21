package com.saucedemo;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public void testAddMultipleProductsToCart() {
        productsPage.addBackpackToCart();
        productsPage.addBikeLightToCart();
        Assertions.assertEquals("2", productsPage.getCartCount());
    }

    @Test
    public void testSortNameAtoZ() {
        productsPage.selectSortOption("az");
        List<String> names = productsPage.getAllItemNames();
        List<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);
        Assertions.assertEquals(sortedNames, names);
    }

    @Test
    public void testSortNameZtoA() {
        productsPage.selectSortOption("za");
        List<String> names = productsPage.getAllItemNames();
        List<String> sortedNames = new ArrayList<>(names);
        sortedNames.sort(Collections.reverseOrder());
        Assertions.assertEquals(sortedNames, names);
    }

    @Test
    public void testSortPriceLowToHigh() {
        productsPage.selectSortOption("lohi");
        List<Double> prices = productsPage.getAllItemPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        Assertions.assertEquals(sortedPrices, prices);
    }

    @Test
    public void testSortPriceHighToLow() {
        productsPage.selectSortOption("hilo");
        List<Double> prices = productsPage.getAllItemPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Collections.reverseOrder());
        Assertions.assertEquals(sortedPrices, prices);
    }
}
