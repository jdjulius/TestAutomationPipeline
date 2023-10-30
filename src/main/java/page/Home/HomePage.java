package page.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class HomePage extends BasePage {

    WebElement input;

    public HomePage(WebDriver driver) {
        super(driver, "");

        this.input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));


    }

    public WebElement getInput() {
        return input;
    }

    public void setInput(WebElement input) {
        this.input = input;
    }

    

}
