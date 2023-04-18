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
                {ACCORDION_1, "����� � 400 ������. ������ ������� � ��������� ��� ������.", OPEN_ACCORDION_1},
                {ACCORDION_2, "���� ��� � ��� ���: ���� ����� � ���� �������. ���� ������ ���������� � ��������, ������ ������ ������� ��������� ������� � ���� �� ������.", OPEN_ACCORDION_2},
                {ACCORDION_3, "��������, �� ���������� ����� �� 8 ���. �� �������� ������� 8 ��� � ������� ���. ������ ������� ������ ���������� � �������, ����� �� �������� ����� �������. ���� �� �������� ������� 8 ��� � 20:30, �������� ������ ���������� 9 ��� � 20:30.", OPEN_ACCORDION_3},
                {ACCORDION_4, "������ ������� � ����������� ���. �� ����� ������ �����������.", OPEN_ACCORDION_4},
                {ACCORDION_5, "���� ��� ���! �� ���� ���-�� ������� � ������ ����� ��������� � ��������� �� ��������� ������ 1010.", OPEN_ACCORDION_5},
                {ACCORDION_6, "������� ��������� � ��� � ������ ��������. ����� ������� �� ������ ����� � ���� ���� ������ �������� ��� ��������� � �� ���. ������� �� �����������.", OPEN_ACCORDION_6},
                {ACCORDION_7, "��, ���� ������� �� ��������. ������ �� �����, �������������� ������� ���� �� ��������. ��� �� ����.", OPEN_ACCORDION_7},
                {ACCORDION_8, "��, �����������. ���� ���������! � ������, � ���������� �������.", OPEN_ACCORDION_8},
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
        System.out.println("���� �������");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
