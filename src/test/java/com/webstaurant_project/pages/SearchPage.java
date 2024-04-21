package com.webstaurant_project.pages;

import com.webstaurant_project.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchPage extends BasePage {
    /**
     * In POM constructor is used to initialize page object and elements.
     */
    public SearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(@aria-label,\'last page\')]")
    private WebElement lastPage;
    @FindBy(xpath = "//div[@data-testid='productBoxContainer']")
    private List<WebElement> pageItemsList;
    @FindBy(xpath = "(//input[@name='addToCartButton'])[last()]")
    private WebElement lastAddCartButtonOnPage;
    @FindBy(xpath = "//a[.='View Cart']")
    private WebElement viewCartButton;
    @FindBy(xpath = "(//span[.='Item number'])[last()]/following-sibling::span[2]")
    private WebElement lastItemNumber;

    /**
     * Created method that take an int parameter to click on page number button on search results pages.
     */
    public void clickPageNumber(int pageNumber) {
        Driver.getDriver().findElement(By.xpath("//a[.='" + pageNumber + "']")).click();
    }
    /**
     * Created a method that gets page number of last search result page and sets its int value to "totalPages".
     * Then uses the "totalPages" to set loop condition and then loops through each item on each page.
     * It will then assert that each item in list contains word "Table" in title.
     * It will also return items that don't contain "Table" and the corresponding item# and page#.
     */
    public void verifyEachPageItemContains(String word) {
        int totalPages = Integer.parseInt(lastPage.getText());

        for (int pageNumber = 1; pageNumber <= totalPages; ) {
            SoftAssert softAssert = new SoftAssert();
            for (WebElement eachItemInList : pageItemsList) {
                softAssert.assertTrue(eachItemInList.getText().contains(word));
                if (!eachItemInList.getText().contains(word)) {
                    System.out.println("Item# " + eachItemInList.getAttribute("data-item-number").toUpperCase() + " on page " + pageNumber + " does not contain \"" + word + "\".");
                }
            }
            pageNumber++;
            if (pageNumber <= totalPages) {
                clickPageNumber(pageNumber);
            }
        }
    }

    /**
     * Created static variable to store item number of last item selected to use later in assertion.
     */
    public static String expectedItemNumberInCart;

    /**
     * Created method that adds last item to cart and stores item number in static variable for later
     * use in assertion.
     */
    public void addLastItemToCart() {
        lastAddCartButtonOnPage.click();
        expectedItemNumberInCart = lastItemNumber.getText().toUpperCase();
    }

    public void clickViewCartButton() {
        viewCartButton.click();
    }
}
