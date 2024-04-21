package com.webstaurant_project.tests;

import com.webstaurant_project.base.TestBase;
import com.webstaurant_project.pages.CartPage;
import com.webstaurant_project.pages.HomePage;
import com.webstaurant_project.pages.SearchPage;
import org.testng.annotations.Test;

public class TC_01_WS_Project extends TestBase {
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    CartPage cartPage = new CartPage();
    @Test(priority = 1)
    public void verifyContainsTable(){
        homePage.searchFor("stainless work table");
        searchPage.verifyEachPageItemContains("Table");
    }
    @Test(priority = 2)
    public void addLastItemAndEmptyCart(){
        searchPage.addLastItemToCart();
        searchPage.clickViewCartButton();
        cartPage.assertItemInCartIsSelectedItem();
        cartPage.clickEmptyCartButton();
        cartPage.clickConfirmationEmptyCartButton();
        cartPage.assertYourCartIsEmptyMessageDisplayed();
    }
}
