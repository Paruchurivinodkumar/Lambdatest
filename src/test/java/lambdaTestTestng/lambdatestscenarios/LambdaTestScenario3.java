package lambdaTestTestng.lambdatestscenarios;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import lambdaTestTestng.base.BaseClass;

public class LambdaTestScenario3 extends BaseClass{
	
@Test	
public void ts3() throws IOException {
	  // Load Excel file
  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Testdata\\Book1.xlsx");
  Workbook workbook = new XSSFWorkbook(fis);
  Sheet sheet = workbook.getSheetAt(0);
  Row row = sheet.getRow(1); // Assuming data starts from row 1

  // Extract data
  String name = row.getCell(0).getStringCellValue();
  System.out.println(name);
  String email = row.getCell(1).getStringCellValue();
  System.out.println(email);
  String password = row.getCell(2).getStringCellValue();
  System.out.println(password);
  String company = row.getCell(3).getStringCellValue();
  System.out.println(company);
  String website = row.getCell(4).getStringCellValue();
  System.out.println(website);
  String city = row.getCell(5).getStringCellValue();
  System.out.println(city);
  String address1 = row.getCell(6).getStringCellValue();
  System.out.println(address1);
  String address2 = row.getCell(7).getStringCellValue();
  System.out.println(address2);
  String state = row.getCell(8).getStringCellValue();
  System.out.println(state);
  int zip = (int) row.getCell(9).getNumericCellValue();
  System.out.println(zip);
 

 
  WebElement input =driver.findElement(By.xpath("//a[text()='Input Form Submit']"));

  if(input.isDisplayed() && input.isEnabled()) {

  input.click();

  }

  WebElement submit= driver.findElement(By.xpath("//button[text()='Submit']"));

  if(submit.isDisplayed() && submit.isEnabled()) {

  submit.click();

  }

  String validationMessage = driver.findElement(By.name("name")).getAttribute("validationMessage");

  Assert.assertEquals(validationMessage, "Please fill out this field.");

  WebElement nam= driver.findElement(By.id("name"));

  if(nam.isDisplayed() && nam.isEnabled()) {

  nam.sendKeys(name);

  }

  WebElement emai= driver.findElement(By.id("inputEmail4"));

  if(emai.isDisplayed() && emai.isEnabled()) {

  emai.sendKeys(email);

  }

  WebElement passwor= driver.findElement(By.id("inputPassword4"));

  if(passwor.isDisplayed() && passwor.isEnabled()) {

  passwor.sendKeys(password);

  }

  WebElement compan= driver.findElement(By.id("company"));

  if(compan.isDisplayed() && compan.isEnabled()) {

  compan.sendKeys(company);

  }

  WebElement websit= driver.findElement(By.id("websitename"));

  if(websit.isDisplayed() && websit.isEnabled()) {

  websit.sendKeys(website);

  }

  WebElement country=driver.findElement(By.name("country"));

  if(country.isDisplayed() && country.isEnabled()) {

  Select selector=new Select(country);

  selector.selectByVisibleText("United States");

  }

  WebElement cit= driver.findElement(By.id("inputCity"));

  if(cit.isDisplayed() && cit.isEnabled()) {

  cit.sendKeys(city);

  }

  WebElement address= driver.findElement(By.id("inputAddress1"));

  if(address.isDisplayed() && address.isEnabled()) {

  address.sendKeys(address1);

  }

  WebElement addres= driver.findElement(By.id("inputAddress2"));

  if(addres.isDisplayed() && addres.isEnabled()) {

  addres.sendKeys(address2);

  }

  WebElement stat= driver.findElement(By.id("inputState"));

  if(stat.isDisplayed() && stat.isEnabled()) {

  stat.sendKeys(state);

  }

  WebElement pincode= driver.findElement(By.id("inputZip"));

  if(pincode.isDisplayed() && pincode.isEnabled()) {

  pincode.sendKeys(String.valueOf(zip));

  }

  WebElement submit2= driver.findElement(By.xpath("//button[text()='Submit']"));

  if(submit2.isDisplayed() && submit2.isEnabled()) {

  submit2.click();

  }

  String str= driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();

  String s="Thanks for contacting us, we will get back to you shortly.";

  if(str.equals(s)) {

  System.out.println("Successfully Contacted");

  }

  else {

  System.out.println("unsuccessfully Contacted");

  }

	  
	        
	        workbook.close();
	        fis.close();
	    }

}
