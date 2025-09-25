package lambdaTestTestng.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
    protected RemoteWebDriver driver;

    @BeforeClass
    @Parameters({"browser", "version", "platform"})
    public void setUp(String browser, String version, String platform) {
        ChromeOptions browserOptions = new ChromeOptions();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "m-naveen.b.kumar@capgemini.com");
        ltOptions.put("accessKey", "LT_U9QUwERvCXqr5BD6XD6Xty0R4j6nOyBzb47wCIXqQzoq5VL");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("build", "Lambda_Build_Version_1.0");
        ltOptions.put("project", "LambdaTest");
        ltOptions.put("name", this.getClass().getSimpleName());
        ltOptions.put("platformName", platform);
        ltOptions.put("browserName", browser);
        ltOptions.put("browserVersion", version);
        ltOptions.put("network", true);
        ltOptions.put("console", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        try {
            driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
        } catch (MalformedURLException e) {
            System.err.println("Invalid LambdaTest hub URL: " + e.getMessage());
        }
    }

    @AfterClass
    public void testClosure() {
        if (driver != null) {
            driver.quit();
        }
    }
}