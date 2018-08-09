package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class ElementsMyWallet {
    public ElementsMyWallet(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#amountval-val")
    public WebElement amountalValue;

    @FindBy (css = "#amountval .noUi-handle-lower")
    public WebElement slider;


}
