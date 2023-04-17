package pomhomepageyandexsamokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePageYandexSamokat {
    private WebDriver driver;
    private WebDriverWait wait;

    // Ћокаторы
    private By cookiesButtonLocator = By.className("App_CookieButton__3cvqF");
    private By dropdownArrowLocator = By.xpath("//div[@id='accordion__heading-0' and @class='accordion__button'][text()='—колько это стоит? » как оплатить?']");
    private By dropdownTextLocator = By.xpath("//div[@id='accordion__panel-0' and @class='accordion__panel'][p/text()='—утки Ч 400 рублей. ќплата курьеру Ч наличными или картой.']");

    public HomePageYandexSamokat(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    public void open() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    public void acceptCookies() {
        WebElement cookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesButtonLocator));
        cookiesButton.click();
    }

    public void openDropdown() {
        WebElement dropdownArrow = driver.findElement(dropdownArrowLocator);
        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dropdownArrow);
        dropdownArrow.click();
    }

    public boolean isDropdownTextDisplayed() {
        WebElement dropdownText = driver.findElement(dropdownTextLocator);
        return dropdownText.isDisplayed();
    }
}
