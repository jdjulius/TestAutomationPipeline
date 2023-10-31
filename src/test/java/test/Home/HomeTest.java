package test.Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import base.BaseTest;
import page.Home.HomePage;

public class HomeTest {

    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);

        this.driver.get("https://www.google.com/");

    }

    @Test(groups = { "validateMountQuote" })
    public void validateMountQuote() {

        HomePage home = new HomePage(driver);

        home.getInput().sendKeys("Python para data science");

        System.out.println("prueba0");

    }

    @Test(groups = { "validateFaceBookLink" })
    public void validateFaceBookLink() {

        // HomePage home = new HomePage(driver);

        System.out.println("prueba1");

    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        try {
            this.driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
