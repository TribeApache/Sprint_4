package pomsamokatrent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutRentPage {
    private WebDriver driver;
    private WebElement bringScooter;
    private WebElement dateSelection;
    private WebElement leasing;
    private WebElement chooseLeasing;
    private WebElement tableColor;
    private WebElement courier;
    private WebElement clickButton;
    private WebElement clickButton2;

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
        bringScooter = driver.findElement(By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Когда привезти самокат' and @type='text']"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        dateSelection = driver.findElement(By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]"));
        leasing = driver.findElement(By.xpath("//div[@class='Dropdown-placeholder']"));
        chooseLeasing = driver.findElement(By.className("Dropdown-option"));
        tableColor = driver.findElement(By.className("Checkbox_Input__14A2w"));
        courier = driver.findElement(By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']"));
        clickButton = driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']"));
        clickButton2 = driver.findElement(By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\" and text()=\"Да\"]"));
    }

    public void clickBringScooter() {
        bringScooter.click();
    }

    public void clickDateSelection() {
        dateSelection.click();
    }

    public void clickLeasing() {
        leasing.click();
    }

    public void clickChooseLeasing() {
        chooseLeasing.click();
    }

    public void clickTableColor() {
        tableColor.click();
    }

    public void fillCourier(String comment) {
        courier.sendKeys(comment);
    }

    public void clickOrderButton() {
        clickButton.click();
    }

    public void clickConfirmButton() {
        clickButton2.click();
    }

    public void fillOrderForm2(String comment) {
        clickBringScooter();
        clickDateSelection();
        clickLeasing();
        clickChooseLeasing();
        clickTableColor();
        fillCourier(comment);
        clickOrderButton();
        clickConfirmButton();
    }
}

