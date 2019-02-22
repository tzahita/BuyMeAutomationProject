import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomeScreen {
    public static void searchForPresent(WebDriver driver) throws InterruptedException {
        Thread.sleep(Constant.THREAD_SLEEP);

        List<WebElement> findDropDown = driver.findElements(By.className(Constant.FIND_DROPDOWN));
        findDropDown.get(0).click();
        List<WebElement> findSum = driver.findElements(By.className(Constant.FIND_ELEMENTS_IN_DROPDOWN));
        findSum.get(3).click();

        findDropDown.get(1).click();
        List<WebElement> findRegion = driver.findElements(By.className(Constant.FIND_ELEMENTS_IN_DROPDOWN));
        findRegion.get(1).click();

        findDropDown.get(2).click();
        List<WebElement> findCategory = driver.findElements(By.className(Constant.FIND_ELEMENTS_IN_DROPDOWN));
        findCategory.get(1).click();

        driver.findElement(By.className(Constant.SEARCH_BTN)).click();
    }
}
