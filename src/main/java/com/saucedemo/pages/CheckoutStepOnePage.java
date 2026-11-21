package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage {
    private final By title = By.cssSelector(".title");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementText(title);
    }

    public void fillInformation(String firstName, String lastName, String postalCode) {
        if (firstName != null && !firstName.isEmpty()) {
            enterText(firstNameField, firstName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            enterText(lastNameField, lastName);
        }
        if (postalCode != null && !postalCode.isEmpty()) {
            enterText(postalCodeField, postalCode);
        }
    }

    public void clickContinue() {
        clickElement(continueButton);
    }

    public void clickCancel() {
        clickElement(cancelButton);
    }

    public String getErrorMessage() {
        return getElementText(errorMessage);
    }
}
