package SamokatBothTestsTogether;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Samokat {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // ��������� ���� � chromedriver.exe �� ����� ������
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test(priority = 1)
    public void testDropdown() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("App_CookieButton__3cvqF")));
        cookiesButton.click();

        // ������� ������� ��������� � ���������� ������ � ������� �� ����, ��������� ����� Actions
        WebElement dropdownArrow = driver.findElement(By.xpath("//div[@id='accordion__heading-0' and @class='accordion__button'][text()='������� ��� �����? � ��� ��������?']"));
        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dropdownArrow);
        dropdownArrow.click();

        //������� ��������������� ����� � ���������, ��� �� ������������
        WebElement dropdownText = driver.findElement(By.xpath("//div[@id='accordion__panel-0' and @class='accordion__panel'][p/text()='����� � 400 ������. ������ ������� � ��������� ��� ������.']"));
        Assert.assertTrue(dropdownText.isDisplayed(), "����� � 400 ������. ������ ������� � ��������� ��� ������.");
    }

    @Test(priority = 2)
    public void testScooterOrder() {
        // ������� ������ ������ ������ �������� � ������� �� ���
        WebElement orderButtonTop = driver.findElement(By.className("Button_Button__ra12g"));
        orderButtonTop.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("App_CookieButton__3cvqF")));
        cookiesButton.click();

        // ��������� ����� ������
        //�������
        WebElement nameInput = driver.findElement(By.xpath("//input[contains(@class, 'Input_Input') and contains(@placeholder, '* ���')]"));
        nameInput.sendKeys("������");

        //���
        WebElement surname = driver.findElement(By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* �������']"));
        surname.sendKeys("����");

        //�����
        WebElement adress = driver.findElement
                (By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* �����: ���� �������� �����']"));
        adress.sendKeys("���������");

        //�������� ������� �����
        WebElement list = driver.findElement
                (By.xpath("//input[@class='select-search__input' and @placeholder='* ������� �����']"));
        Actions actions = new Actions(driver);
        list.click();
        WebElement list2 = driver.findElement
                (By.xpath(".//button[@value='29']"));
        list2.click();

        //��������� ����� ��������
        WebElement telefonNumber = driver.findElement
                (By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* �������: �� ���� �������� ������']"));
        telefonNumber.sendKeys("+79999999999");


        //�������� "�����" � ��������� �� ��������� �����
        WebElement submitButton = driver.findElement
                (By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='�����']"));
        submitButton.click();

        //�������� ���� �������� �������
        WebElement bringScooter = driver.findElement
                (By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* ����� �������� �������' and @type='text']"));
        bringScooter.click();
       WebElement dateSelection = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[4]"));
       dateSelection.click();

//�������� �� ������� ���� ��������
        WebElement leasing = driver.findElement
                (By.xpath("//div[@class='Dropdown-placeholder']"));
        leasing.click();
        WebElement chooseLeasing = driver.findElement
                (By.className("Dropdown-option"));
        chooseLeasing.click();

//�������� ���� ��������
        WebElement tableColor = driver.findElement
        (By.className("Checkbox_Input__14A2w"));
        tableColor.click();

//����� ����������� �������
       WebElement courier = driver.findElement
               (By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='����������� ��� �������']"));
        courier.sendKeys("�������!");
        //�������� ����� � ��������� � ����� ������������� �� ��� ���
        WebElement clickButton = driver.findElement
                (By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='��������']"));
        clickButton.click();

//� ����� ������������� �������� ���
        WebElement clickButton2 = driver.findElement
                (By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i\" and text()=\"���\"]"));
        clickButton2.click();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
