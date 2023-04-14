package Test1;

import PomForTest1.SamokatPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SamokatTest {
    private WebDriver driver;
    private SamokatPage samokatPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        samokatPage = new SamokatPage(driver);
        samokatPage.open();
    }

    @Test(priority = 1)
    public void testDropdown() {
        samokatPage.acceptCookies();
        samokatPage.openDropdown();
        Assert.assertTrue(samokatPage.isDropdownTextDisplayed(), "����� � 400 ������. ������ ������� � ��������� ��� ������.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
