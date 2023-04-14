package PomForTest2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage2 {
    private WebDriver driver;

    public OrderPage2(WebDriver driver) {
        this.driver = driver;
    }

    //Выбираем дату доставки скутера
    public void fillOrderForm2() {
        WebElement bringScooter = driver.findElement
                (By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Когда привезти самокат' and @type='text']"));
        bringScooter.click();
        WebElement dateSelection = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[4]"));
        dateSelection.click();

        //Выбираем на сколько дней арендуем
        WebElement leasing = driver.findElement
                (By.xpath("//div[@class='Dropdown-placeholder']"));
        leasing.click();
        WebElement chooseLeasing = driver.findElement
                (By.className("Dropdown-option"));
        chooseLeasing.click();

        //Выбираем цвет Самоката
        WebElement tableColor = driver.findElement
                (By.className("Checkbox_Input__14A2w"));
        tableColor.click();

        //Пишем комментарий курьеру
        WebElement courier = driver.findElement
                (By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']"));
        courier.sendKeys("Быстрее!");

        //Самбитим форму и переходим к форме подтверждения ДА или НЕТ
        WebElement clickButton = driver.findElement
                (By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']"));
        clickButton.click();

        //В форме подтверждения нажимаем ДА
        WebElement clickButton2 = driver.findElement
                (By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\" and text()=\"Да\"]"));
        clickButton2.click();
    }
}


