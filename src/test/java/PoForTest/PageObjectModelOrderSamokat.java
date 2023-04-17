package PoForTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectModelOrderSamokat {
    private static final By firstName = By.xpath(".//input[@placeholder='* Имя']");
    private static final By secondName = By.xpath(".//input[@placeholder='* Фамилия']");
    private static final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private static final By clickMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private static final By inputMetro = By.className("Order_Text__2broi");
    private static final By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static final By clickNextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private static final By inputDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By inputRental = By.className("Dropdown-control");
    public static final By selectBlack = By.id("black");
    public static final By selectGrey = By.id("grey");
    private static final By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private static final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By buttonYes = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By orderWindow = By.xpath(".//div[text()='Заказ оформлен']");
    private static final By pageOrder = By.className("App_App__15LM-");
    private final WebDriver driver;

    public PageObjectModelOrderSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {
        driver.findElement(firstName).sendKeys(name);
    }

    public void inputSecondName(String surname) {
        driver.findElement(secondName).sendKeys(surname);
    }

    public void inputAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void inputMetro(String metroStation) {
        driver.findElement(clickMetroStation).sendKeys(metroStation);
        driver.findElement(inputMetro).click();
    }

    public void inputPhone(String phoneNumber) {
        driver.findElement(inputPhone).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(clickNextButton).click();
        WebDriverWait wait = new WebDriverWait(driver,(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageOrder));
    }

    public PageObjectModelOrderSamokat setDataFirstPageOrder(String name, String surname, String address, String metroStation, String phoneNumber) {
        inputName(name);
        inputSecondName(surname);
        inputAddress(address);
        inputMetro(metroStation);
        inputPhone(phoneNumber);
        clickNextButton();
        return this;
    }

    public void inputDate(String date) {
        driver.findElement(inputDate).sendKeys(date, Keys.ENTER);
    }

    public void chooseRentalPeriod(String rentalPeriod) {
        driver.findElement(inputRental).click();
        driver.findElement(By.xpath(".//div[text()='" + rentalPeriod + "']")).click();
    }

    public void color(By color) {
        driver.findElement(color).click();
    }

    public void comment(String comment) {
        driver.findElement(inputComment).sendKeys(comment);
    }

    public void clickCreateOrderButton() {
        driver.findElement(orderButton).click();
    }

    public PageObjectModelOrderSamokat setDataSecondPageOrder(String date, String rentalPeriod, By color, String comment) {
        inputDate(date);
        chooseRentalPeriod(rentalPeriod);
        color(color);
        comment(comment);
        clickCreateOrderButton();
        return this;
    }

    public void clickYesButton() {
        driver.findElement(buttonYes).click();
    }

    public boolean isOrderWindowDisplayed() {
        new WebDriverWait(driver,3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderWindow));
        return driver.findElement(orderWindow).isDisplayed();
    }
    public void getTextFromPopupOrderWindow() {
        System.out.println(driver.findElement(orderWindow).getText());
    }
}