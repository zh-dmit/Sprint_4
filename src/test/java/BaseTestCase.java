import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTestCase {
    protected final WebDriver driver;
    private final String testURL = "https://qa-scooter.praktikum-services.ru/";

    public BaseTestCase() {
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.get(testURL);
    }

    @Before
    public void waitLoadElement() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
