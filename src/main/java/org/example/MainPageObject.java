package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class MainPageObject extends BasePageObject {

    //Кнопка принятия куки
    private final By cookieAcceptButton = By.xpath(".//button[@id='rcc-confirm-button']");
    //Кнопка заказа внизу страницы
    private final By orderButtonDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //Кнопка заказа вверху страницы
    private final By orderButtonUp = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Логотип яндекс
    private final By yandexLogo = By.xpath(".//img[@src='/assets/ya.svg']");
    //Логотип самоката
    private final By scooterLogo = By.xpath(".//img[@src='/assets/scooter.svg']");
    //Кнопка статуса заказа
    private final By orderStatus = By.xpath(".//button[@class='Header_Link__1TAG7' and text()='Статус заказа']");
    //Поле ввода номера заказа
    private final By inputOrderNumberField = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    //Кнопка проверки номера заказа
    private final By buttonCheckOrder = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO' and text()='Go!']");
    //Картинка заказ не найден
    private final By imgOrderNotFound = By.xpath(".//img[@alt='Not found']");

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
        //Панели вопросов
        final String questionPanel = ".//div[@id='accordion__heading-%d']";
        //Текст ответов выпадающих панелей
        final String accordionPanel = "//div[@id='accordion__panel-%d']/p";

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

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).isDisplayed();
        driver.findElement(yandexLogo).click();
    }

    public void clickScooterLogo() {
        driver.findElement(scooterLogo).isDisplayed();
        driver.findElement(scooterLogo).click();
    }

    public void clickOrderStatus() {
        driver.findElement(orderStatus).isDisplayed();
        driver.findElement(orderStatus).click();
    }

    public void setOrderNumber(String number) {
        driver.findElement(inputOrderNumberField).isDisplayed();
        driver.findElement(inputOrderNumberField).sendKeys(number);
    }

    public void clickButtonCheckOrder() {
        driver.findElement(buttonCheckOrder).isDisplayed();
        driver.findElement(buttonCheckOrder).click();
    }

    public By getInputOrderNumberField() {
        return inputOrderNumberField;
    }

    public By getImgOrderNotFound() {
        return  imgOrderNotFound;
    }

}
