package tests;

import elements.ElementsChooseCredit;
import elements.ElementsMyWallet;
import logic.LogicChooseCredit;
import logic.LogicMyWallet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverWaitHelper;

public class SmokeTest {
    private static final String START_PAGE = "https://sravnizajm.com.ua/vyberi-luchshij-kredit-onlajn/";
    private LogicChooseCredit logicChooseCredit;
    private LogicMyWallet logicMyWallet;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = DriverWaitHelper.generateWaits(driver, 5, 30, 3);
        ElementsChooseCredit elementsChooseCredit = new ElementsChooseCredit(driver);
        logicChooseCredit = new LogicChooseCredit(driver, wait, elementsChooseCredit);
        ElementsMyWallet elementsMyWallet = new ElementsMyWallet(driver);
        logicMyWallet = new LogicMyWallet(driver, wait, elementsMyWallet);
        driver.get(START_PAGE);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        logicChooseCredit.chooseAmountOfCredit();
        //logicMyWallet.useJavaScriptForSliderStyleChanging();
        logicMyWallet.dragAndDrop();
    }
}
