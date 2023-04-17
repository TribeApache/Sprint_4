package pomsamokatrent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhoTheScooterIsForPage {
    private WebDriver driver;
    private WebElement cookiesButton;
    private WebElement nameInput;
    private WebElement surnameInput;
    private WebElement adressInput;
    private WebElement metroInput;
    private WebElement telefonNumberInput;
    private WebElement submitButton;

    public WhoTheScooterIsForPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        cookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("App_CookieButton__3cvqF")));
        nameInput = driver.findElement(By.xpath("//input[contains(@class, 'Input_Input') and contains(@placeholder, '* ���')]"));
        surnameInput = driver.findElement(By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* �������']"));
        adressInput = driver.findElement(By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* �����: ���� �������� �����']"));
        metroInput = driver.findElement(By.xpath("//input[@class='select-search__input' and @placeholder='* ������� �����']"));
        telefonNumberInput = driver.findElement(By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* �������: �� ���� �������� ������']"));
        submitButton = driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='�����']"));
    }

    public void fillOrderForm(String name, String surname, String address, String metro, String phoneNumber) {
        //��������� ����
        cookiesButton.click();

        //��������� �������
        nameInput.sendKeys(name);

        //��������� ���
        surnameInput.sendKeys(surname);

        //��������� �����
        adressInput.sendKeys(address);

        //�������� ������� �����
        Actions actions = new Actions(driver);
        metroInput.click();
        WebElement station = driver.findElement(By.xpath(String.format(".//button[@value='29']", metro)));
        station.click();

        //��������� ����� ��������
        telefonNumberInput.sendKeys(phoneNumber);

        //�������� "�����" � ��������� �� ��������� �����
        submitButton.click();
    }
}


