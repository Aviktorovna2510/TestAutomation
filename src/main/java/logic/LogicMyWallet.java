package logic;

import elements.ElementsMyWallet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogicMyWallet extends MainLogic{
    private ElementsMyWallet elements;

    public LogicMyWallet(WebDriver driver, WebDriverWait wait, ElementsMyWallet elements) {
        super(driver, wait);
        this.elements = elements;
    }

    public void useJavaScriptForSliderStyleChanging() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#amountval .noUi-handle-lower').setAttribute('class','noUi-handle noUi-handle-lower noUi-active');");
        js.executeScript("document.querySelector('#amountval .noUi-origin').style=\"left: 100%;\";");
        js.executeScript("document.querySelector('#amountval .noUi-connect').style=\"left: 0%; right: 0%;\";");
        js.executeScript("document.querySelector('#amountval .noUi-handle-lower').setAttribute('aria-valuemax','100.0');");
        js.executeScript("document.querySelector('#amountval .noUi-handle-lower').setAttribute('aria-valuenow','100.0');");
        js.executeScript("document.querySelector('#amountval .noUi-handle-lower').setAttribute('aria-valuetext','6000');");
        //js.executeScript("document.querySelector('#amountval-val').setAttribute('style','6000');");
        waitForJSToBeLoaded();
        waitForJQueryToBeLoaded();
    }

    public void dragAndDrop () {
        waitForVisible(elements.slider);
        WebElement slider = driver.findElement(By.cssSelector("#amountval .noUi-handle-lower"));
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(slider, 100, 0).build();
        action.perform();
    }




}
