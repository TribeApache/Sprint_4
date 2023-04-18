package ru.yandex;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class PageObjectModelHomePage {
        public static final By ACCORDION_1 = By.id("accordion__heading-0");
        public static final By ACCORDION_2 = By.id("accordion__heading-1");
        public static final By ACCORDION_3 = By.id("accordion__heading-2");
        public static final By ACCORDION_4 = By.id("accordion__heading-3");
        public static final By ACCORDION_5 = By.id("accordion__heading-4");
        public static final By ACCORDION_6 = By.id("accordion__heading-5");
        public static final By ACCORDION_7 = By.id("accordion__heading-6");
        public static final By ACCORDION_8 = By.id("accordion__heading-7");
        public static final By OPEN_ACCORDION_1 = By.id("accordion__panel-0");
        public static final By OPEN_ACCORDION_2 = By.id("accordion__panel-1");
        public static final By OPEN_ACCORDION_3 = By.id("accordion__panel-2");
        public static final By OPEN_ACCORDION_4 = By.id("accordion__panel-3");
        public static final By OPEN_ACCORDION_5 = By.id("accordion__panel-4");
        public static final By OPEN_ACCORDION_6 = By.id("accordion__panel-5");
        public static final By OPEN_ACCORDION_7 = By.id("accordion__panel-6");
        public static final By OPEN_ACCORDION_8 = By.id("accordion__panel-7");
        public static final By ORDER_BUTTON_UP = By.cssSelector(".Button_Button__ra12g");
        public static final By ORDER_BUTTON_DOWN = By.cssSelector(".Home_FinishButton__1_cWm");
        private static final By ACCORDION_LIST = By.className("Home_FAQ__3uVm4");
        private static final By COOKE_CLOSE_BUTTON = By.id("rcc-confirm-button");
        private final WebDriver driver;

        public PageObjectModelHomePage(WebDriver driver) {
            this.driver = driver;
        }

        public PageObjectModelHomePage runBrowser() {
            driver.get("https://qa-scooter.praktikum-services.ru/");
            driver.findElement(COOKE_CLOSE_BUTTON).click();
            return this;
        }

        public PageObjectModelHomePage scrollAccordion() {
            WebElement element = driver.findElement(ACCORDION_LIST);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            return this;
        }

        public PageObjectModelHomePage clickAccordionButton(By accordionButtonHeading) {
            WebDriverWait wait = new WebDriverWait(driver, (10));
            wait.until(ExpectedConditions.elementToBeClickable(accordionButtonHeading));
            driver.findElement(accordionButtonHeading).click();
            return this;
        }

        public PageObjectModelHomePage isTextAccordionDisplayed(By accordionButtonPanel) {
            new WebDriverWait(driver, (10))
                    .until(ExpectedConditions.visibilityOfElementLocated(accordionButtonPanel));
            boolean isDisplayed = driver.findElement(accordionButtonPanel).isDisplayed();
            Assert.assertTrue(isDisplayed);
            return this;
        }

        public String getTextAccordion(By accordionButtonPanel) {
            return driver.findElement(accordionButtonPanel).getText();
        }

        public PageObjectModelHomePage scrollToOrderButton(By orderButton) {
            WebElement element = driver.findElement(orderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            return this;
        }

        public void clickOrderButton(By orderButton) {
            driver.findElement(orderButton).click();
        }
    }

