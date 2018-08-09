package logic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainLogic {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * Waits until all JQuery code is executed in a page
     */
    public void waitForJQueryToBeLoaded() {
        wait.until(webDriver -> (Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
    }

    /**
     * Waits until web-element is visible on a page
     *
     * @param element the web-element, which should be visible
     * @return the passed element will be returned
     */
    public WebElement waitForVisible(WebElement element) {
        waitForJSToBeLoaded();
        wait.until(ExpectedConditions.visibilityOf(element));
        highlightElement(element);
        return element;
    }

    /**
     * Waits until all web-elements in list are visible
     *
     * @param elements the list of web-elements
     * @return the same list of elements will be returned
     */
    public List<WebElement> waitForVisible(List<WebElement> elements) {
        waitForJSToBeLoaded();
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        return elements;
    }

    /**
     * Clicks a web-element after it becomes visible
     *
     * @param element a web-element
     * @return the passed element will be returned
     */
    public WebElement clickWhenReady(WebElement element) {
        waitForVisible(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return element;
    }

    /**
     * Waits until all JavaScript code is executed in a page
     */
    private void waitForJSToBeLoaded() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Highlights found element
     * @param element - element which should be highlighted
     */
    private void highlightElement(WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("element = arguments[0];" +
                    "original_style = element.getAttribute('style');" +
                    "element.setAttribute('style', original_style + \"; background: lightblue; border: 3px dashed black;\");" +
                    "setTimeout(function(){" +
                    "element.setAttribute('style', original_style);" +
                    "}, 60);", element);
        }
    }
}
