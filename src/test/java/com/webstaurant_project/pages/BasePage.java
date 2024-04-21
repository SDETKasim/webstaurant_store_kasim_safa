package com.webstaurant_project.pages;

import com.webstaurant_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created a BasePage to extend to page classes in order to access common header and footer elements.
 */
public abstract class BasePage {
    /**
     * In POM, constructor is used to initialize page object and elements.
     */
    protected BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "searchval")
    private WebElement searchBox;

    @FindBy(xpath = "(//button[@value='Search'])[1]")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-testid=\'cart-button\']")
    private WebElement cartButton;

    public void searchFor(String keywords) {
        searchBox.sendKeys(keywords);
        searchButton.click();
    }
    public void goToCart() {
        cartButton.click();
    }
}
