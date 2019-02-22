import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChooseGiftScreen {
    public static void choosegift(WebDriver driver) throws InterruptedException {
        Thread.sleep(Constant.THREAD_SLEEP);
        List<WebElement> myElements = driver.findElements(By.className(Constant.OPTICANA));
        System.out.println(myElements.size());

        WebElement elementToClick = myElements.get(1);
        ((JavascriptExecutor)driver).executeScript(Constant.ARGUMENT_TO_CLICK, elementToClick);
    }
}
