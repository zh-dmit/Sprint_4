package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class OrderPageObject extends BasePageObject {

    //Поле ввода имени
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода фамилии
    private final By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода адреса
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле выбора станции метро
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле ввода номера телефона
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка далее
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле выбора даты
    private final By dateSelect = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле выбора времени аренды
    private final By rentalTime = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    //Поле выбора черного цвета
    private final By colourSelectBlack = By.xpath(".//input[@id='black' and @class='Checkbox_Input__14A2w']");
    //Поле выбора серого цвета
    private final By colourSelectGrey = By.xpath(".//input[@id='grey' and @class='Checkbox_Input__14A2w']");
    //Поле комментария
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка заказать
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Один день аренды
    private final By oneDaySelect = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    //Два дня аренды
    private final By twoDaysSelect = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
    //Кнопка подтверждения оформления заказа
    private final By confirmOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Текст успешного размещения заказа
    private final By successfulOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
    //Ожидание
    Duration duration = Duration.ofSeconds(3);

    public OrderPageObject(WebDriver driver) {
        super(driver);
    }

    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSecondNameField(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }

    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetroField(String metro) {
        driver.findElement(metroField).click();
        driver.findElement(metroField).sendKeys(metro);
        new WebDriverWait(driver, duration)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@value='"+metro+"']")));
        driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroField).sendKeys(Keys.ENTER);
    }

    public void setPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void setDateSelect(String date) {
        driver.findElement(dateSelect).sendKeys(date);
        driver.findElement(dateSelect).sendKeys(Keys.ENTER);
    }

    public void setColourSelect(String colour) {
        if (Objects.equals(colour, "чёрный жемчуг")) {
            driver.findElement(colourSelectBlack).click();
        } else
        if (Objects.equals(colour, "серая безысходность")) {
            driver.findElement(colourSelectGrey).click();
        } else
            System.out.println("Введен неверный цвет");

    }

    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void setRentalTime(String rental) {
        if (Objects.equals(rental, "сутки")) {
            driver.findElement(rentalTime).click();
            driver.findElement(oneDaySelect).click();
        } else
        if (Objects.equals(rental, "двое суток")) {
            driver.findElement(rentalTime).click();
            driver.findElement(twoDaysSelect).click();
        } else
            System.out.println("Введено неверное время аренды");

    }

    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }

    public void checkSuccessfulOrder() {
        driver.findElement(successfulOrder).isDisplayed();
    }

}
