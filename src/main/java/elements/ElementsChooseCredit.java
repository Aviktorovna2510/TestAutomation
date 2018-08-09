package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsChooseCredit {

    public ElementsChooseCredit(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//div[@id='money']//div[@class='noUi-pips noUi-pips-horizontal']/div[12]" )
    public WebElement value6000;

    @FindBy (css = ".first")
    public WebElement creditResults;

    @FindBy (xpath = "//div[contains(@class, 'full_commission')]/following-sibling::div[@class='cell']")
    public List <WebElement> listOfCommission;
}
