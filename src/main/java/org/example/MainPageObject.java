package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Objects;

public class MainPageObject extends BasePageObject {

    //Панели вопросов
    private final String questionPanel = ".//div[@id='accordion__heading-%d']";
    //Текст ответов выпадающих панелей
    private final String accordionPanel = "//div[@id='accordion__panel-%d']/p";
    //Кнопка принятия куки
    private final By cookieAcceptButton = By.xpath(".//button[@id='rcc-confirm-button']");
    //Кнопка заказа внизу страницы
    private final By orderButtonDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //Кнопка заказа вверху страницы
    private final By orderButtonUp = By.xpath(".//button[@class='Button_Button__ra12g']");

    public MainPageObject (WebDriver driver) {
        super(driver);
    }

    public void acceptCookie() {
        WebElement cookieAccept = driver.findElement(cookieAcceptButton);
        if (cookieAccept.isDisplayed()) {
            cookieAccept.click();
        }
    }

    public String getAccordionPanelText(int itemIndex) {
        acceptCookie();
        driver.findElement(By.xpath(String.format(questionPanel, itemIndex))).click();
        return driver.findElement(By.xpath(String.format(accordionPanel, itemIndex))).getAttribute("textContent");
    }

    public void clickOrderButtonMainPage(String positionButton) {
        if (Objects.equals(positionButton, "кнопка вверху")) {
            driver.findElement(orderButtonUp).isDisplayed();
            driver.findElement(orderButtonUp).click();
        }
        if (Objects.equals(positionButton, "кнопка внизу")) {
            driver.findElement(orderButtonDown).isDisplayed();
            driver.findElement(orderButtonDown).click();
        }

    }

}
