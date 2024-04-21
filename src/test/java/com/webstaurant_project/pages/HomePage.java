package com.webstaurant_project.pages;

import com.webstaurant_project.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    /**
     * In POM constructor is used to initialize page object and elements.
     */
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
