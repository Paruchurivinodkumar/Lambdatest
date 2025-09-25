
package lambdaTestTestng.lambdatestscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import lambdaTestTestng.base.BaseClass;
import java.time.Duration;

public class Lambdatestscenarios2 extends BaseClass {
    @Test
    public void ts02() {
        try {
            driver.get("https://www.lambdatest.com/selenium-playground");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Drag & Drop Sliders")));
            link.click();

            WebElement slider = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='15']")));
            Actions action = new Actions(driver);
            action.clickAndHold(slider).moveByOffset(212, 0).release().perform();

            String value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//output[@id='rangeSuccess']"))).getText();
            if (value.equals("95")) {
                System.out.println("✔ Slider moved to 95 successfully.");
            } else {
                System.out.println("✘ Slider value is " + value);
            }
        } catch (Exception e) {
            System.err.println("Test Scenario 2 failed: " + e.getMessage());
        }
    }
}
