
package lambdaTestTestng.lambdatestscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import lambdaTestTestng.base.BaseClass;
import java.time.Duration;

public class LambdaTestScenario1 extends BaseClass {
    @Test
    public void ts01() {
        try {
            driver.get("https://www.lambdatest.com/selenium-playground");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement simple = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Simple Form Demo']")));
            simple.click();

            String str = "Welcome to Lambda Test";
            WebElement usermessage = wait.until(ExpectedConditions.elementToBeClickable(By.id("user-message")));
            usermessage.sendKeys(str);

            WebElement checkedvalue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Get Checked Value']")));
            checkedvalue.click();

            String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']"))).getText();
            if (s.equals(str)) {
                System.out.println("✔ Message validation Passed: " + s);
            } else {
                System.out.println("✘ Message validation Failed: " + s);
            }
        } catch (Exception e) {
            System.err.println("Test Scenario 1 failed: " + e.getMessage());
        }
    }
}
