package pomsamokatrent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageYandexSamokat {
    private WebDriver driver;

    public HomePageYandexSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton() {
        // Находим кнопку заказа вверху страницы и кликаем на нее
        WebElement orderButtonTop = driver.findElement(By.className("Button_Button__ra12g"));
        orderButtonTop.click();
    }
}


