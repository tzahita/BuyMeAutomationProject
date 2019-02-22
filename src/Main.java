import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import jdk.internal.org.xml.sax.SAXException;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Main {
    private static WebDriver driver;
    private static ExtentReports extent = new ExtentReports();
    ExtentTest test = extent.createTest(Constant.TEST_NAME, Constant.DESCRIPTION);

    @BeforeClass
    public static void main() throws org.xml.sax.SAXException, ParserConfigurationException, SAXException, IOException {
        if (getData("DRIVER").equals("Chrome"))
        System.setProperty(Constant.CHROM_DRIVER, Constant.CHROM_DRIVER_PATH);

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        driver = new ChromeDriver(option);

        driver.manage().timeouts().implicitlyWait(Constant.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getData("URL"));
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Constant.REPORT_PATH);
        extent.attachReporter(htmlReporter);
    }
    @Test //register to Buyme
    public void test01_Registration() throws IOException {
        Registration.pressOnRegistration(driver);
        Registration.enterPersonalInformation(driver);
        // add screenshot
        test.pass("test", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constant.FOLDER_PATH + new Random())).build());
    }
    @Test // Search for present
    public void test02_HomeScreen() throws InterruptedException, IOException {
        HomeScreen.searchForPresent(driver);
        // add screenshot
        test.pass("test", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constant.FOLDER_PATH + new Random())).build());
    }
    @Test // Choose gift
    public void test03_ChooseGift() throws InterruptedException, IOException {
        Assert.assertEquals(Constant.EXPECTED_URL,driver.getCurrentUrl());
        ChooseGiftScreen.choosegift(driver);
        // add screenshot
        test.pass("test", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constant.FOLDER_PATH + new Random())).build());
    }
    @Test // Enter price and send message
    public void test04_SendGift() throws InterruptedException, IOException {
        //driver.navigate().to("https://buyme.co.il/supplier/352936");
        Send.enterPrice(driver);
        // add screenshot
        test.pass("test", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constant.FOLDER_PATH + new Random())).build());
        Send.fillInformationForm(driver);
        // add screenshot
        test.pass("test", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constant.FOLDER_PATH + new Random())).build());

    }

    @AfterClass
    public static void afterClass() {
// end test and save data into report file
        extent.flush();
    }

    // Read from XML
    private static String getData(String keyName) throws ParserConfigurationException, IOException, SAXException, org.xml.sax.SAXException {
        File configXmlFile = new File(Constant.FILE_PATH);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }


    // take scrrenshot and return picture path
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }
}
