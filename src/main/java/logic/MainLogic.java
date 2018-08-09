package logic;

import elements.ElementsChooseCredit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainLogic {
    public WebDriver driver;
    public WebDriverWait wait;

    public MainLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * Waits until all JavaScript code is executed in a page
     */
    public void waitForJSToBeLoaded() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Waits until all JQuery code is executed in a page
     */
    public void waitForJQueryToBeLoaded(){
        wait.until(webDriver -> (Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
    }

    public void highlightElement(WebElement element){
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript( "element = arguments[0];" +
                    "original_style = element.getAttribute('style');" +
                    "element.setAttribute('style', original_style + \"; background: lightblue; border: 3px dashed black;\");" +
                    "setTimeout(function(){" +
                    "element.setAttribute('style', original_style);" +
                    "}, 60);", element);
        }
    }

    /**
     * Waits until web-element is visible on a page
     * @param element the web-element, which should be visible
     * @return the passed element will be returned
     */
    public WebElement waitForVisible(WebElement element){
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.visibilityOf(element));
        highlightElement(element);
        return element;
    }

    /**
     * Waits until all web-elements in list are visible
     * @param elements the list of web-elements
     * @return the same list of elements will be returned
     */
    public List<WebElement> waitForVisible(List<WebElement> elements){
        waitForJSToBeLoaded();
        for(WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        return elements;
    }


    /**
     * Waits until web-element is invisible on a page
     * @param element the web-element, which should be invisible
     * @return the passed element will be returned
     */
    public WebElement waitForInvisible(WebElement element){
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

    /**
     * Clicks a web-element after it becomes visible
     * @param element a web-element
     * @return the passed element will be returned
     */
    public WebElement clickWhenReady(WebElement element) {
        waitForVisible(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return element;
    }

    public Integer findMinimumCommission ( List<WebElement> listOfCommission) {
        List<WebElement> webElementsCommissions = listOfCommission;
        List<Integer> commissions = new ArrayList<>();

        for (WebElement item : webElementsCommissions) {
            String textSum = item.getText();
            String sum = textSum.replaceAll("грн", "").trim();
            int convertedValue = Integer.parseInt(sum);
            commissions.add(convertedValue);
        }

        Integer minCommission = Collections.min(commissions);
        return minCommission;
    }







}
