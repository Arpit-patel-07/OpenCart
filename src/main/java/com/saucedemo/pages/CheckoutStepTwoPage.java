package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage {
    private final By title = By.cssSelector(".title");
    private final By itemName = By.cssSelector(".inventory_item_name");
    private final By itemTotal = By.cssSelector(".summary_subtotal_label");
    private final By tax = By.cssSelector(".summary_tax_label");
    private final By total = By.cssSelector(".summary_total_label");
    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementText(title);
    }

    public String getItemName() {
        return getElementText(itemName);
    }

    public String getItemTotal() {
        return getElementText(itemTotal);
    }

    public String getTax() {
        return getElementText(tax);
    }

    public String getTotal() {
        return getElementText(total);
    }

    public void clickFinish() {
        clickElement(finishButton);
    }

    public void clickCancel() {
        clickElement(cancelButton);
    }
}
