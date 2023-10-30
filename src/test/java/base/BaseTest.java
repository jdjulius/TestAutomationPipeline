package base;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import entity.UserProfile;


public class BaseTest {

    public static WebDriver driver;

    String configFileName;
    Properties configProperty;
    public static UserProfile user;
    public static List<UserProfile> userList;

    @BeforeTest(alwaysRun = true)
    @Parameters({ "id", "dataprovider", "nametest" })
    private void setUp(@Optional int id, @Optional String dataprovider, @Optional String nametest) throws Exception {


        System.out.println("inicio");


       // configFileName = Routes.currentWorkingDirectory + Routes.fileNameConfig;
       // configProperty = ConfigUtils.readProperties(configFileName);

        //userList = csv.readFromCSV(dataprovider, UserProfile.class);
       // user = userList.get(id);

        // BrowserStackConnection connection = new BrowserStackConnection();
        // driver = connection.initBrowserStack(configProperty.getProperty("BWCONFIG"),
        // nametest);

       //System.setProperty("webdriver.chrome.driver", Routes.currentWorkingDirectory + Routes.driverChrome);
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);

        //Wait.sleep(2);

        //String usr = configProperty.getProperty("USER");
       // String pwd = configProperty.getProperty("PASS");
        String url = configProperty.getProperty("URL");

        driver.manage().window().maximize();

        // JavascriptExecutor jse = (JavascriptExecutor)driver;
        // jse.executeScript("browserstack_executor: {\"action\": \"sendBasicAuth\",
        // \"arguments\": {\"username\":\""+usr+"\", \"password\": \""+pwd+"\",
        // \"timeout\": \"10\"}}");

        // ((HasAuthentication) driver).register(UsernameAndPassword.of(usr, pwd));

        driver.get(url);
        //driver.get("https://" + usr + ":" + pwd + "@" + url);

       // Wait.sleep(10);

    }

    @AfterTest()
    public void tearDown() {

        try {
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
