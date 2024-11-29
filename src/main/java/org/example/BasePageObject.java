package org.example;

import org.openqa.selenium.WebDriver;

public abstract class BasePageObject {

    protected final WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }
}
