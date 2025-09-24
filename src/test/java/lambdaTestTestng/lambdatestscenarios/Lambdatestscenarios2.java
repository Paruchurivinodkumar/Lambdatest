package lambdaTestTestng.lambdatestscenarios;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import lambdaTestTestng.base.BaseClass;

public class Lambdatestscenarios2 extends BaseClass {
	@Test

	public void ts02() {

		driver.findElement(By.linkText("Drag & Drop Sliders")).click();

		// Step 3: Locate the slider and its value display

		WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));

		if (slider.isDisplayed() && slider.isEnabled()) {

			Actions action = new Actions(driver);

			action.clickAndHold(slider).moveByOffset(212, 0).release().perform();

		}

		String value = driver.findElement(By.xpath("//output[@id='rangeSuccess']")).getText();

		if (value.equals("95")) {

			System.out.println("\u2714 Slider moved to 95 successfully.");

		} else {

			System.out.println("\u2718 Slider value is " + value);

		}
	}

}
