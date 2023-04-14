package Test2;

import PomForTest2.HomePage;
import PomForTest2.OrderPage;
import PomForTest2.OrderPage2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SamokatTest2 {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 2)
    public void testScooterOrder() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderForm();
        OrderPage2 orderPage2 = new OrderPage2(driver);
        orderPage2.fillOrderForm2();
    }
}
