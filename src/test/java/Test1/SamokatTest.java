package Test1;

import pomhomepageyandexsamokat.HomePageYandexSamokat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SamokatTest {
    private WebDriver driver;
    private HomePageYandexSamokat homePageYandexSamokat;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        homePageYandexSamokat = new HomePageYandexSamokat(driver);
        homePageYandexSamokat.open();
    }

    @Test(priority = 1)
    public void testDropdown() {
        homePageYandexSamokat.acceptCookies();
        homePageYandexSamokat.openDropdown();
        Assert.assertTrue(homePageYandexSamokat.isDropdownTextDisplayed(), "����� � 400 ������. ������ ������� � ��������� ��� ������.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
