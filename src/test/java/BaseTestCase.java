import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTestCase {
    protected final WebDriver driver;
    private final String testURL = "https://qa-scooter.praktikum-services.ru/";

    public BaseTestCase() {
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.get(testURL);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
