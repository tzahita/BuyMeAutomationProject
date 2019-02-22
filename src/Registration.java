import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Registration {
    public static void pressOnRegistration(WebDriver driver){
        driver.findElement(By.className(Constant.REGISTRATION)).click();
        driver.manage().timeouts().implicitlyWait(Constant.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.findElement(By.className(Constant.REGISTRATION2)).click();
    }



    public static void enterPersonalInformation(WebDriver driver) {
        List<WebElement> findDropDown = driver.findElements(By.className(Constant.INPUT_REGISTRATION_FILEDS));
        findDropDown.get(0).sendKeys(Constant.PERSONAL_NAME);
        findDropDown.get(1).sendKeys(Constant.EMAIL);
        findDropDown.get(2).sendKeys(Constant.PASSWORD);
        findDropDown.get(3).sendKeys(Constant.PASSWORD);
        WebElement elementToClick = driver.findElement(By.className(Constant.AGREE));
        ((JavascriptExecutor)driver).executeScript(Constant.ARGUMENT_TO_CLICK, elementToClick);
        driver.findElement(By.className(Constant.REGISTER_BTN)).click();
    }
}
