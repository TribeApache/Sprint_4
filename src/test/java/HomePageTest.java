import PoForTest.PageObjectModelHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static PoForTest.PageObjectModelHomePage.*;

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
                {accordion1, "����� � 400 ������. ������ ������� � ��������� ��� ������.", openAccordion1},
                {accordion2, "���� ��� � ��� ���: ���� ����� � ���� �������. ���� ������ ���������� � ��������, ������ ������ ������� ��������� ������� � ���� �� ������.", openAccordion2},
                {accordion3, "��������, �� ���������� ����� �� 8 ���. �� �������� ������� 8 ��� � ������� ���. ������ ������� ������ ���������� � �������, ����� �� �������� ����� �������. ���� �� �������� ������� 8 ��� � 20:30, �������� ������ ���������� 9 ��� � 20:30.", openAccordion3},
                {accordion4, "������ ������� � ����������� ���. �� ����� ������ �����������.", openAccordion4},
                {accordion5, "���� ��� ���! �� ���� ���-�� ������� � ������ ����� ��������� � ��������� �� ��������� ������ 1010.", openAccordion5},
                {accordion6, "������� ��������� � ��� � ������ ��������. ����� ������� �� ������ ����� � ���� ���� ������ �������� ��� ��������� � �� ���. ������� �� �����������.", openAccordion6},
                {accordion7, "��, ���� ������� �� ��������. ������ �� �����, �������������� ������� ���� �� ��������. ��� �� ����.", openAccordion7},
                {accordion8, "��, �����������. ���� ���������! � ������, � ���������� �������.", openAccordion8},
        };
    }

    @Test
    public void checkAccordionListTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        PageObjectModelHomePage Accordion = new PageObjectModelHomePage(driver);
        Accordion.runBrowser();
        Accordion.scrollAccordion();
        Accordion.clickAccordionButton(accordionButtonHeading);
        Accordion.isTextAccordionDisplayed(accordionButtonPanel);
        String accordionTextActual = Accordion.getTextAccordion(accordionButtonPanel);
        Assert.assertEquals(accordionTextExpected, accordionTextActual);
        System.out.println("���� �������");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
