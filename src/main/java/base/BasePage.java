package base;

import org.openqa.selenium.WebDriver;


public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver, String route) {
        super();

        this.driver = driver;

       
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

   

}
