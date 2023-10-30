package browserStack;

import java.io.FileReader;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackConnection {

    public static WebDriver driver;

    public BrowserStackConnection() {

    }

    public RemoteWebDriver initBrowserStack(String config_file, String nameTest) throws Exception {

        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader(System.getProperty("user.dir") + "/config/" + config_file));

//                .parse(new FileReader(Routes.currentWorkingDirectory + Routes.fileConfigSuiteBW + config_file));

        MutableCapabilities capabilities = new MutableCapabilities();

        capabilities.setCapability("browserName", config.get("browserName"));

        JSONObject browserstackOptions = (JSONObject) config.get("bstack:options");

        browserstackOptions.put("sessionName", nameTest);

        capabilities.setCapability("bstack:options", browserstackOptions);

        driver = new RemoteWebDriver(new URL(
                "https://" + config.get("user") + ":" + config.get("key") + "@" + config.get("server") + "/wd/hub"),
                capabilities);

        return (RemoteWebDriver) driver;
    }

    public static void markTestStatus(String status, String reason, WebDriver driver) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""
                + status + "\", \"reason\": \"" + reason + "\"}}");

    }

}
