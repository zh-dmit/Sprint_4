import org.example.MainPageObject;
import org.example.OrderPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class ChecksErrorForOrderTests extends BaseTestCase {

    private MainPageObject mainPage = new MainPageObject(driver);
    private OrderPageObject orderPage = new OrderPageObject(driver);
    private Duration duration = Duration.ofSeconds(10);

    @Test
    public void checksErrorForOrderFieldPageWhoIsTheScooterFor() {
        String positionButton = "кнопка вверху";
        String wrongValueForField = "!";
        By errorForNameField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректное имя']");
        By errorForSecondNameField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректную фамилию']");
        By errorForAddressField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректный адрес']");
        By errorForMetroField = By.xpath(".//div[@class='Order_MetroError__1BtZb' and text()='Выберите станцию']");
        By errorForNumberField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6' and text()='Введите корректный номер']");
        String expectedErrorNameField = "Введите корректное имя";
        String expectedErrorSecondNameField = "Введите корректную фамилию";
        String expectedErrorAddressField = "Введите корректный адрес";
        String expectedErrorMetroField = "Выберите станцию";
        String expectedErrorNumberField = "Введите корректный номер";

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
        By expectedImg = By.xpath(".//img[@alt='Not found']");
        String wrongValueForField = "!";

        mainPage.clickOrderStatus();
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(mainPage.getInputOrderNumberField()));
        mainPage.setOrderNumber(wrongValueForField);
        mainPage.clickButtonCheckOrder();

        assertEquals("Ошибка, ожидалась картинка 'заказ не найден'", expectedImg, mainPage.getImgOrderNotFound());
    }

}
