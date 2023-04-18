import ru.yandex.PageObjectModelHomePage;
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

@RunWith(Parameterized.class)
public class HomePageTest {

    private final By accordionButtonHeading;
    private final By accordionButtonPanel;
    private final String accordionTextExpected;
    private WebDriver driver;

    public HomePageTest(By accordionButtonHeading, String accordionTextExpected, By accordionButtonPanel) {
        this.accordionButtonHeading = accordionButtonHeading;
        this.accordionTextExpected = accordionTextExpected;
        this.accordionButtonPanel = accordionButtonPanel;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {ACCORDION_1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", OPEN_ACCORDION_1},
                {ACCORDION_2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", OPEN_ACCORDION_2},
                {ACCORDION_3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", OPEN_ACCORDION_3},
                {ACCORDION_4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", OPEN_ACCORDION_4},
                {ACCORDION_5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", OPEN_ACCORDION_5},
                {ACCORDION_6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", OPEN_ACCORDION_6},
                {ACCORDION_7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", OPEN_ACCORDION_7},
                {ACCORDION_8, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", OPEN_ACCORDION_8},
        };
    }

    @Test
    public void checkAccordionListTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        PageObjectModelHomePage accordion = new PageObjectModelHomePage(driver);
        accordion.runBrowser();
        accordion.scrollAccordion();
        accordion.clickAccordionButton(accordionButtonHeading);
        accordion.isTextAccordionDisplayed(accordionButtonPanel);
        String accordionTextActual = accordion.getTextAccordion(accordionButtonPanel);
        Assert.assertEquals(accordionTextExpected, accordionTextActual);
        System.out.println("Тест пройден");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
