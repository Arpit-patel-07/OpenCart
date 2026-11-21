package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    private final By title = By.cssSelector(".title");
    private final By completeHeader = By.cssSelector(".complete-header");
    private final By completeText = By.cssSelector(".complete-text");
    private final By backHomeButton = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementText(title);
    }

    public String getCompleteHeader() {
        return getElementText(completeHeader);
    }

    public String getCompleteText() {
        return getElementText(completeText);
    }

    public void clickBackHome() {
        clickElement(backHomeButton);
    }
}
