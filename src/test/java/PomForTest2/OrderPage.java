package PomForTest2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillOrderForm() {
        //��������� ����
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("App_CookieButton__3cvqF")));
        cookiesButton.click();

        //��������� �������
        WebElement nameInput = driver.findElement(By.xpath("//input[contains(@class, 'Input_Input') and contains(@placeholder, '* ���')]"));
        nameInput.sendKeys("������");

        //��������� ���
        WebElement surname = driver.findElement(By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* �������']"));
        surname.sendKeys("����");

        //��������� �����
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
    }
}


