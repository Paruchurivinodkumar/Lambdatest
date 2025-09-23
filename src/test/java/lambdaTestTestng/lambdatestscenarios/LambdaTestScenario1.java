package lambdaTestTestng.lambdatestscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lambdaTestTestng.base.BaseClass;

public class LambdaTestScenario1 extends BaseClass {
	@Test

	public void ts01() {

		WebElement simple = driver.findElement(By.xpath("//a[text()='Simple Form Demo']"));

		if (simple.isDisplayed() && simple.isEnabled()) {

			simple.click();

		}

		String str = "Welcome to Lambda Test";

		WebElement usermessage = driver.findElement(By.id("user-message"));

		if (usermessage.isDisplayed() && usermessage.isEnabled()) {

			usermessage.sendKeys(str);

		}

		WebElement checkedvalue = driver.findElement(By.xpath("//button[text()='Get Checked Value']"));

		if (checkedvalue.isDisplayed() && checkedvalue.isEnabled()) {

			checkedvalue.click();

		}

		String s = driver.findElement(By.xpath("//p[@id='message']")).getText();

		// System.out.println(s);

		if (s.equals(str)) {

			System.out.println("Message validsation Passed" + " " + s);

		}

		else {

			System.out.println("Message Validation Failed" + s);

		}
	}
}
