package tests;

import constants.GlobalConstants;
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

    private LogicChooseCredit logicChooseCredit;
    private LogicMyWallet logicMyWallet;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, GlobalConstants.CHROME_DRIVER_WINDOWS_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = DriverWaitHelper.generateWaits(driver, 5, 30, 3);
        ElementsChooseCredit elementsChooseCredit = new ElementsChooseCredit(driver);
        logicChooseCredit = new LogicChooseCredit(driver, wait, elementsChooseCredit);
        ElementsMyWallet elementsMyWallet = new ElementsMyWallet(driver);
        logicMyWallet = new LogicMyWallet(driver, wait, elementsMyWallet);
        driver.get(GlobalConstants.START_PAGE);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testVerifyCreditFunctionality() {
        logicChooseCredit.chooseAmountOfCredit();
        logicChooseCredit.choosePropositionWithMinimalCommission();
        logicMyWallet.verifyCreditAvailability();
        logicMyWallet.verifyResult();
    }
}
