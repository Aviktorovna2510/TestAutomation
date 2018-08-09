package logic;

import elements.ElementsMyWallet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LogicMyWallet extends MainLogic {

    private ElementsMyWallet elements;
    private WebDriver driver;

    public LogicMyWallet(WebDriver driver, WebDriverWait wait, ElementsMyWallet elements) {
        super(driver, wait);
        this.elements = elements;
        this.driver = driver;
    }

    /**
     * Step 4 - Verify that credit is available for sum 6000
     */
    public void verifyCreditAvailability() {
        waitForVisible(elements.slider);
        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(elements.slider, 100, 0).build();
        action.perform();
    }

    /**
     * Step 5 - Resolution verifying
     */
    public void verifyResult() {
        final int limit = 6000;
        final String emptyString = "",
                whitespace = " ";

        waitForVisible(elements.amountalValue);
        String maximumValue = elements.amountalValue.getText().replace(whitespace, emptyString);

        if (limit <= Integer.parseInt(maximumValue)) {
            Reporter.log("КРЕДИТ ВЗЯТЬ МОЖНО");
        } else {
            Reporter.log("КРЕДИТ ВЗЯТЬ НЕЛЬЗЯ");
        }
    }
}
