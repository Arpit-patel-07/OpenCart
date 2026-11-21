package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final By title = By.cssSelector(".title");
    private final By addToCartSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By removeSauceLabsBackpack = By.id("remove-sauce-labs-backpack");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By cartLink = By.cssSelector(".shopping_cart_link");

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

    public String getCartCount() {
        return getElementText(cartBadge);
    }

    public boolean isCartBadgeDisplayed() {
        return isElementDisplayed(cartBadge);
    }

    public void goToCart() {
        clickElement(cartLink);
    }
}
