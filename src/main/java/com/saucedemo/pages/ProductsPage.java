package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    private final By title = By.cssSelector(".title");
    private final By addToCartSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By removeSauceLabsBackpack = By.id("remove-sauce-labs-backpack");
    private final By addToCartSauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By cartLink = By.cssSelector(".shopping_cart_link");
    private final By sortDropdown = By.cssSelector(".product_sort_container");
    private final By itemNames = By.cssSelector(".inventory_item_name");
    private final By itemPrices = By.cssSelector(".inventory_item_price");
    private final By burgerMenuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementText(title);
    }

    public void addBackpackToCart() {
        clickElement(addToCartSauceLabsBackpack);
    }

    public void removeBackpackFromCart() {
        clickElement(removeSauceLabsBackpack);
    }

    public void addBikeLightToCart() {
        clickElement(addToCartSauceLabsBikeLight);
    }

    public String getCartCount() {
        return getElementText(cartBadge);
    }

    public boolean isCartBadgeDisplayed() {
        return isElementDisplayed(cartBadge);
    }

    public void goToCart() {
        clickElement(cartLink);
    }

    public void selectSortOption(String sortValue) {
        selectFromDropdown(sortDropdown, sortValue);
    }

    public List<String> getAllItemNames() {
        List<WebElement> elements = findElements(itemNames);
        List<String> names = new ArrayList<>();
        for (WebElement element : elements) {
            names.add(element.getText());
        }
        return names;
    }

    public List<Double> getAllItemPrices() {
        List<WebElement> elements = findElements(itemPrices);
        List<Double> prices = new ArrayList<>();
        for (WebElement element : elements) {
            String priceText = element.getText().replace("$", "").trim();
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }

    public void openMenu() {
        clickElement(burgerMenuButton);
    }

    public void clickLogout() {
        clickElement(logoutLink);
    }
}
