import org.example.MainPageObject;
import org.example.OrderPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class ChecksErrorForOrderTests extends BaseTestCase {
    MainPageObject mainPage = new MainPageObject(driver);
    OrderPageObject orderPage = new OrderPageObject(driver);
    Duration duration = Duration.ofSeconds(10);

    @Test
    public void checksErrorForOrderFieldPageWhoIsTheScooterFor() {
        final String positionButton = "кнопка вверху";
        final String wrongValueForField = "!";
        final By errorForNameField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректное имя']");
        final By errorForSecondNameField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректную фамилию']");
        final By errorForAddressField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректный адрес']");
        final By errorForMetroField = By.xpath(".//div[@class='Order_MetroError__1BtZb' and text()='Выберите станцию']");
        final By errorForNumberField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректный номер']");
        final String expectedErrorNameField = "Введите корректное имя";
        final String expectedErrorSecondNameField = "Введите корректную фамилию";
        final String expectedErrorAddressField = "Введите корректный адрес";
        final String expectedErrorMetroField = "Выберите станцию";
        final String expectedErrorNumberField = "Введите корректный номер";

        mainPage.clickOrderButtonMainPage(positionButton);
        orderPage.setNameField(wrongValueForField);
        orderPage.setSecondNameField(wrongValueForField);
        orderPage.setAddressField(wrongValueForField);
        orderPage.setPhoneNumberField(wrongValueForField);
        orderPage.clickNextButton();
        assertEquals(expectedErrorNameField, driver.findElement(errorForNameField).getText());
        assertEquals(expectedErrorSecondNameField, driver.findElement(errorForSecondNameField).getText());
        assertEquals(expectedErrorAddressField, driver.findElement(errorForAddressField).getText());
        assertEquals(expectedErrorMetroField, driver.findElement(errorForMetroField).getText());
        assertEquals(expectedErrorNumberField, driver.findElement(errorForNumberField).getText());
    }

    @Test
    public void checkForSearchWrongOrderNumber() {
        final By expectedImg = By.xpath(".//img[@alt='Not found']");
        final String wrongValueForField = "!";

        mainPage.clickOrderStatus();
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(mainPage.getInputOrderNumberField()));
        mainPage.setOrderNumber(wrongValueForField);
        mainPage.clickButtonCheckOrder();

        assertEquals("Ошибка, ожидалась картинка 'заказ не найден'", expectedImg, mainPage.getImgOrderNotFound());
    }

}
