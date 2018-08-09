package utils;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;

public class DriverInstances {
    static {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe");
    }



}
