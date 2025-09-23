package lambdaTestTestng.base;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	//public WebDriver driver;
	//public Logger logger;
	
	

	   protected RemoteWebDriver driver;
	   @Parameters({"browser", "version", "platform"})
	   @BeforeClass
	   public void setUp(String browser, String version, String platform) throws Exception {
	       ChromeOptions browserOptions = new ChromeOptions();
	       HashMap<String, Object> ltOptions = new HashMap<String, Object>();
	       ltOptions.put("username", "m-naveen.b.kumar@capgemini.com");
	       ltOptions.put("accessKey", "LT_U9QUwERvCXqr5BD6XD6Xty0R4j6nOyBzb47wCIXqQzoq5VL");
	       ltOptions.put("visual", true);
	       ltOptions.put("video", true);
	       ltOptions.put("build", "Lambda_Build_Version _1.0");
	       ltOptions.put("project", "LambdaTest");
	       ltOptions.put("name", this.getClass().getSimpleName());
	       ltOptions.put("platformName", platform);
	       ltOptions.put("browserName", browser);
	       ltOptions.put("browserVersion", version);
	       ltOptions.put("network", true);
	       ltOptions.put("console", true);
	       browserOptions.setCapability("LT:Options", ltOptions);
	       driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
	}

	@AfterClass
	public void testClosure() {
		driver.quit();
		//logger.info("Chrome driver is closed/quit");
		//logger.info("*******TC__Register Stop********");
	}
	

}
