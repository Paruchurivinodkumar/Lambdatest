package lambdaTestTestng.base;


import java.net.URI;
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
	   public void setup(String browser, String version, String platform) throws Exception {
	       ChromeOptions browserOptions = new ChromeOptions();
	       browserOptions.setPlatformName(platform);
	       browserOptions.setBrowserVersion(version);
	    
	       HashMap<String, Object> ltOptions = new HashMap<String, Object>();
	       ltOptions.put("user", "m-naveen.b.kumar@capgemini.com");   
	       ltOptions.put("accessKey", "LT_U9QUwERvCXqr5BD6XD6Xty0R4j6nOyBzb47wCIXqQzoq5VL"); 
	       ltOptions.put("project", "Lambdatesting");
	       ltOptions.put("selenium_version", "4.0.0");
	       ltOptions.put("w3c", true);
	    
	       browserOptions.setCapability("LT:Options", ltOptions);
	    
	       URL url = URI.create("https://hub.lambdatest.com/wd/hub").toURL();
	        driver = new RemoteWebDriver( url, browserOptions);
	   }

	@AfterClass
	public void testClosure() {
		driver.quit();
		//logger.info("Chrome driver is closed/quit");
		//logger.info("*******TC__Register Stop********");
	}
	

}
