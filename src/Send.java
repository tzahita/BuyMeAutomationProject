import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Send {
    public static void enterPrice(WebDriver driver){
        driver.findElement(By.xpath(Constant.ENETR_SUM)).sendKeys(Constant.SUM);
        driver.findElement(By.xpath(Constant.ENETR_SUM)).sendKeys(Keys.ENTER);
    }

    public static void fillInformationForm(WebDriver driver){

        List<WebElement> toWho = driver.findElements(By.xpath(Constant.SEND_TO_WHO));
        System.out.println(toWho.size());
        toWho.get(0).click();
        List<WebElement> senderReciver = driver.findElements(By.tagName(Constant.SENDER_RECIVER_ELEMENT));
        System.out.println(senderReciver.size());
        senderReciver.get(8).sendKeys(Constant.RECIVER_NAME);
        senderReciver.get(9).clear();
        senderReciver.get(9).sendKeys(Constant.SENDER_NAME);
        senderReciver.get(11).sendKeys(Constant.PIC_PATH);

        List<WebElement> findDropDown = driver.findElements(By.className(Constant.FIND_DROPDOWN));
        findDropDown.get(6).click();
        List<WebElement> findCategory = driver.findElements(By.className(Constant.FIND_ELEMENTS_IN_DROPDOWN));
        findCategory.get(1).click();

        driver.findElement(By.tagName(Constant.TEXT_AREA)).clear();
        driver.findElement(By.tagName(Constant.TEXT_AREA)).sendKeys(Constant.BLC_TEXT);
        driver.findElement(By.className(Constant.SEND_NOW)).click();
        driver.findElement(By.className(Constant.ICON_EMAIL)).click();
        driver.findElement(By.className(Constant.EMAIL_BTN)).sendKeys(Constant.EMAIL_TO_SEND);
        driver.findElement(By.xpath(Constant.SAVE_BTN)).click();
        driver.findElement(By.xpath(Constant.SUBMIT_BTN)).click();


    }

}
