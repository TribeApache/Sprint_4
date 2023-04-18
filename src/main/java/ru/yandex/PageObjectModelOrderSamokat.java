package ru.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectModelOrderSamokat {
    private static final By FIRST_NAME = By.xpath(".//input[@placeholder='* Имя']");
    private static final By SECOND_NAME = By.xpath(".//input[@placeholder='* Фамилия']");
    private static final By ADDRESS_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private static final By CLICK_METRO_STATION = By.xpath(".//input[@placeholder='* Станция метро']");
    private static final By INPUT_METRO = By.className("Order_Text__2broi");
    private static final By INPUT_PHONE = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static final By CLICK_NEXT_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private static final By INPUT_DATE = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By INPUT_RENTAL = By.className("Dropdown-control");
    public static final By SELECT_BLACK = By.id("black");
    public static final By SELECT_GRAY = By.id("grey");
    private static final By INPUT_COMMENT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private static final By ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By BUTTON_YES = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By ORDER_WINDOWS = By.xpath(".//div[text()='Заказ оформлен']");
    private static final By PAGE_ORDER = By.className("App_App__15LM-");
    private final WebDriver driver;

    public PageObjectModelOrderSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {
        driver.findElement(FIRST_NAME).sendKeys(name);
    }

    public void inputSecondName(String surname) {
        driver.findElement(SECOND_NAME).sendKeys(surname);
    }

    public void inputAddress(String address) {
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
    }

    public void inputMetro(String metroStation) {
        driver.findElement(CLICK_METRO_STATION).sendKeys(metroStation);
        driver.findElement(INPUT_METRO).click();
    }

    public void inputPhone(String phoneNumber) {
        driver.findElement(INPUT_PHONE).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(CLICK_NEXT_BUTTON ).click();
        WebDriverWait wait = new WebDriverWait(driver,(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_ORDER));
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
        driver.findElement(INPUT_DATE).sendKeys(date, Keys.ENTER);
    }

    public void chooseRentalPeriod(String rentalPeriod) {
        driver.findElement(INPUT_RENTAL).click();
        driver.findElement(By.xpath(".//div[text()='" + rentalPeriod + "']")).click();
    }

    public void color(By color) {
        driver.findElement(color).click();
    }

    public void comment(String comment) {
        driver.findElement(INPUT_COMMENT).sendKeys(comment);
    }

    public void clickCreateOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
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
        driver.findElement(BUTTON_YES).click();
    }

    public boolean isOrderWindowDisplayed() {
        new WebDriverWait(driver,3)
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_WINDOWS));
        return driver.findElement(ORDER_WINDOWS).isDisplayed();
    }

    public String getTextFromPopupOrderWindow() {
        return driver.findElement(ORDER_WINDOWS).getText();
    }
}