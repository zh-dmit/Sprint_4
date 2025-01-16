import org.example.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class ChecksLogoMainPageTests extends BaseTestCase {

    private MainPageObject mainPage = new MainPageObject(driver);
    private Duration duration = Duration.ofSeconds(10);

    @Test
    public void checkRedirectFromYandexLogoToDzenPage() {

        By dzenSearchButton = By.xpath(".//button[@class='dzen-search-arrow-common__button']");

        mainPage.clickYandexLogo();
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(dzenSearchButton));

        assertEquals("Ошибка: нажатие на лого яндекс, не открывает страницу дзен.", "https://dzen.ru/?yredirect=true", driver.getCurrentUrl());
    }

    @Test
    public void checkRedirectFromScooterLogoToMainScooterPage() {
        mainPage.clickScooterLogo();
        assertEquals("Ошибка: нажатие на лого самоката, не открывает главную страницу.", "https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }
}
