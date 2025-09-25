
package lambdaTestTestng.lambdatestscenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import lambdaTestTestng.base.BaseClass;

public class LambdaTestScenario3 extends BaseClass {

    @Test
    public void ts3() throws IOException {
        try {
            driver.get("https://www.lambdatest.com/selenium-playground");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Input Form Submit']")));
            input.click();

            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\\\Testdata\\\\Book1.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(1);

            String name = row.getCell(0).getStringCellValue();
            String email = row.getCell(1).getStringCellValue();
            String password = row.getCell(2).getStringCellValue();
            String company = row.getCell(3).getStringCellValue();
            String website = row.getCell(4).getStringCellValue();
            String city = row.getCell(5).getStringCellValue();
            String address1 = row.getCell(6).getStringCellValue();
            String address2 = row.getCell(7).getStringCellValue();
            String state = row.getCell(8).getStringCellValue();
            int zip = (int) row.getCell(9).getNumericCellValue();

            WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
            submit.click();

            String validationMessage = driver.findElement(By.name("name")).getAttribute("validationMessage");
            Assert.assertEquals(validationMessage, "Please fill out this field.");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("name"))).sendKeys(name);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("inputEmail4"))).sendKeys(email);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("inputPassword4"))).sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("company"))).sendKeys(company);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("websitename"))).sendKeys(website);

            Select selector = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.name("country"))));
            selector.selectByVisibleText("United States");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("inputCity"))).sendKeys(city);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("inputAddress1"))).sendKeys(address1);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("inputAddress2"))).sendKeys(address2);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("inputState"))).sendKeys(state);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("inputZip"))).sendKeys(String.valueOf(zip));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']"))).click();

            String str = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='success-msg hidden']"))).getText();
            String expected = "Thanks for contacting us, we will get back to you shortly.";

            if (str.equals(expected)) {
                System.out.println("Successfully Contacted");
            } else {
                System.out.println("Unsuccessfully Contacted");
            }

            workbook.close();
            fis.close();
        } catch (Exception e) {
            System.err.println("Test Scenario 3 failed: " + e.getMessage());
        }
    }
}
