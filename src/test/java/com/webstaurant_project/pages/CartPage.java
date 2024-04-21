package com.webstaurant_project.pages;

import com.webstaurant_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends BasePage {
    /**
     * In POM constructor is used to initialize page object and elements.
     */
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Empty Cart']")
    private WebElement emptyCartButton;
    @FindBy(xpath = "//footer/button[.='Empty Cart']")
    private WebElement confirmationEmptyCartButton;
    @FindBy(xpath = "//p[.='Your cart is empty.']")
    private WebElement yourCartIsEmptyMessage;
    @FindBy(xpath = "(//input[contains(@name,\"itemNumber\")])[1]")
    private WebElement itemNumberInCart;

    public void clickEmptyCartButton() {
        emptyCartButton.click();
    }

    public void clickConfirmationEmptyCartButton() {
        confirmationEmptyCartButton.click();
    }

    /**
     * Created method that asserts empty cart message is displayed after cart is emptied.
     */
    public void assertYourCartIsEmptyMessageDisplayed() {
        Assert.assertTrue(yourCartIsEmptyMessage.isDisplayed());
    }

    /**
     * Created method to assert that last item on page that was selected is actual item in cart.
     */
    public void assertItemInCartIsSelectedItem() {
        String actualItemNumberInCart = itemNumberInCart.getAttribute("value");
        Assert.assertEquals(actualItemNumberInCart,SearchPage.expectedItemNumberInCart);
    }
}
