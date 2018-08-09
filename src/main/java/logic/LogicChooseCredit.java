package logic;

import elements.ElementsChooseCredit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class LogicChooseCredit extends MainLogic {

    private ElementsChooseCredit elements;

    public LogicChooseCredit(WebDriver driver, WebDriverWait wait, ElementsChooseCredit elements) {
        super(driver, wait);
        this.elements = elements;
    }

    public void chooseAmountOfCredit() {
        // Sets need limit
        waitForVisible(elements.value6000);
        clickWhenReady(elements.value6000);
        waitForVisible(elements.creditResults);
        // Gets elements blocks
        waitForVisible(elements.listOfBlocks);

//        By.xpath("//ul[@class='available']//li[contains(@class, 'proposition')]")

        WebElement rootList = driver.findElement(By.xpath("//div[@id='banks_by_condition']//ul[@class='available']"));
        List<WebElement> foundElements = rootList.findElements(By.tagName("li"));

//        List<WebElement> foundElements = driver.findElements(By.tagName("li"));

        System.out.println("Size - " + foundElements.size());

        for(WebElement element: foundElements){
            WebElement commision = element.findElement(By.xpath("//div[contains(@class, 'full_commission')]/following-sibling::div[@class='cell']"));
            System.out.println(commision.getText());
        }

        List<WebElement> listOfBlocks = this.elements.listOfBlocks;

//        for (WebElement block : listOfBlocks) {
//            System.out.println("BLOCK ELEMENT - " + block);
//
//
//            WebElement elementComimssion = block.findElement(By.xpath("//div[contains(@class, 'full_commission')]/following-sibling::div[@class='cell']"));
//            System.out.println(elementComimssion.getText());
//
//        }


        Integer minimumCommission = findMinimumCommission(this.elements.listOfCommission);
        //div[contains(@class, 'full_commission')]/following-sibling::div[@class='cell']//span[text()='595']
        clickWhenReady(this.elements.buyBtn);


//        System.out.println(listOfBlocks);


    }
}
