import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.MainPageObject;
import org.example.OrderPageObject;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class ChecksOrderPageTest {

    private final WebDriver driver;
    String positionButton;
    String name;
    String secondName;
    String address;
    String metro = "Войковская";
    String phoneNumber;
    String date;
    String rentalTime;
    String colour;
    String comment;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }

    public ChecksOrderPageTest(String positionButton, String name, String secondName, String address, String metro, String phoneNumber, String date, String rentalTime, String colour, String comment) {
        this.positionButton = positionButton;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalTime = rentalTime;
        this.colour = colour;
        this.comment = comment;
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"кнопка вверху", "Евгений", "Дмитриев", "Ул. Ленина дом 15", "Войковская", "89164318487", "25.05.2024", "сутки", "чёрный жемчуг", "Домофон не работает"},
                {"кнопка внизу", "Евгений", "Дмитриев", "Ул. Ленина дом 15", "Войковская", "89164318487", "25.05.2024", "двое суток", "серая безысходность", "Домофон не работает"}
        };
    }

    @Test
    public void placeOrder() {
        MainPageObject mainPage = new MainPageObject(driver);
        OrderPageObject orderPage = new OrderPageObject(driver);
        mainPage.acceptCookie();
        mainPage.clickOrderButtonMainPage(positionButton);
        orderPage.setNameField(name);
        orderPage.setSecondNameField(secondName);
        orderPage.setAddressField(address);
        orderPage.setMetroField(metro);
        orderPage.setPhoneNumberField(phoneNumber);
        orderPage.clickNextButton();
        orderPage.setDateSelect(date);
        orderPage.setRentalTime(rentalTime);
        orderPage.setColourSelect(colour);
        orderPage.setCommentField(comment);
        orderPage.clickOrderButton();
        orderPage.clickConfirmOrderButton();
        orderPage.checkSuccessfulOrder();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
