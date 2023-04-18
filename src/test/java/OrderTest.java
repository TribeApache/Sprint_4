import ru.yandex.PageObjectModelHomePage;
import ru.yandex.PageObjectModelOrderSamokat;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.yandex.PageObjectModelHomePage.*;
import static ru.yandex.PageObjectModelOrderSamokat.*;

@RunWith(Parameterized.class)
public class OrderTest {
    private final By orderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final By color;
    private final String comment;
    private WebDriver driver;

    public OrderTest(By orderButton, String name, String surname, String address,
                     String metroStation, String phoneNumber, String date, String rentalPeriod, By color, String comment) {
        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {ORDER_BUTTON_UP,
                        "Иванов", "Иван", "Полевая 68, кв 10", "Коломенская", "+79175256365",
                        "17.04.2023", "сутки", SELECT_BLACK, "Можно без звонка"},
                {ORDER_BUTTON_DOWN,
                        "Пупкин", "Сергей", "Коломенская 10 кв 27", "Братиславская", "89653256414",
                        "25.04.2023", "двое суток", SELECT_GRAY, "Звоните"},
        };
    }

    @Test
    public void createNewOrderTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        PageObjectModelHomePage Accordion = new PageObjectModelHomePage(driver);
        Accordion.runBrowser();
        Accordion.scrollToOrderButton(orderButton);
        Accordion.clickOrderButton(orderButton);
        PageObjectModelOrderSamokat orderPage = new PageObjectModelOrderSamokat(driver);
        orderPage.setDataFirstPageOrder(name, surname, address, metroStation, phoneNumber);
        orderPage.setDataSecondPageOrder(date, rentalPeriod, color, comment);
        orderPage.clickYesButton();
        boolean isDisplayed = orderPage.isOrderWindowDisplayed();
        Assert.assertTrue(isDisplayed);
        orderPage.getTextFromPopupOrderWindow();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
