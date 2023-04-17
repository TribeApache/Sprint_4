package Test2;

import pomsamokatrent.HomePageYandexSamokat;
import pomsamokatrent.WhoTheScooterIsForPage;
import pomsamokatrent.AboutRentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SamokatTestRentFromFirstButton {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 2)
    public void testScooterOrder() {
        HomePageYandexSamokat homePageYandexSamokat = new HomePageYandexSamokat(driver);
        homePageYandexSamokat.clickOrderButton();
        WhoTheScooterIsForPage whoTheScooterIsForPage = new WhoTheScooterIsForPage(driver);
        whoTheScooterIsForPage.fillOrderForm("Иван", "Иванов", "Москва", "Театральная", "+79994528789");
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.fillOrderForm2("fast delivery");
    }
}
