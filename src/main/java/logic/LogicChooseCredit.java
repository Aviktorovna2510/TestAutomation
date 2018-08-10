package logic;

import elements.ElementsChooseCredit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LogicChooseCredit extends MainLogic {

    private ElementsChooseCredit elements;
    private WebDriver driver;

    public LogicChooseCredit(WebDriver driver, WebDriverWait wait, ElementsChooseCredit elements) {
        super(driver, wait);
        this.elements = elements;
        this.driver = driver;
    }

    /**
     * Step 2 - choose sum with value 6000
     */
    public void chooseAmountOfCredit() {
        waitForVisible(elements.value6000);
        clickWhenReady(elements.value6000);
        waitForVisible(elements.creditResults);
    }

    /**
     * Step 3 - choose proposition with minimal commission and click on it
     */
    public void choosePropositionWithMinimalCommission() {
        Integer minimumCommission = findMinimumCommission(elements.listOfCommission);
        clickWhenReady(getMinimalCommissionButton(minimumCommission));

    }

    /**
     * Finds minimal commission value in list with commissions
     *
     * @param listOfCommission - list with all existing commissions of WebElement type
     * @return minimal commission value
     */
    private Integer findMinimumCommission(List<WebElement> listOfCommission) {
        List<Integer> commissions = new ArrayList<>();

        for (WebElement item : listOfCommission) {
            String textSum = item.getText();
            String sum = textSum.replaceAll("грн", "").trim();
            int convertedValue = Integer.parseInt(sum);
            commissions.add(convertedValue);
        }

        return Collections.min(commissions);
    }

    /**
     * Gets minimal commission Button WebElement
     *
     * @param minimalCommission - minimal commision value which will be used in xpath
     * @return minimal commission button WebElement
     */
    private WebElement getMinimalCommissionButton(Integer minimalCommission) {
        return driver.findElement(By.xpath("//div[@class='cell']/span[.='" + minimalCommission + "']/ancestor::div[@class='bank-position']//a[@class='submit']"));
    }
}
