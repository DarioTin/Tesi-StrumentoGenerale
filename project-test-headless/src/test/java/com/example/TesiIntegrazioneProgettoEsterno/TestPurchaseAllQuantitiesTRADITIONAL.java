
//File risulta attualmente aggiornato per webdriver chrome headless!
package com.example.TesiIntegrazioneProgettoEsterno;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestPurchaseAllQuantitiesTRADITIONAL {
private static WebDriver driver;
private boolean acceptNextAlert = true;
private static StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		
		  // Init chromedriver
		  String chromeDriverPath = "/home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/chromedriver_v94_linux64/chromedriver";
		  System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		  System.setProperty("webdriver.chrome.whitelistedIps", "");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--no-sandbox","--ignore-certificate-errors");
		  driver = new ChromeDriver(options);  
		  
		  
		  
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test
  public void testPurchaseAllQuantities_release_0_0_1() throws Exception {
    driver.get("http://localhost:4200/auth");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("test@test.com");
    driver.findElement(By.id("passwordInput")).click();
    driver.findElement(By.id("passwordInput")).clear();
    driver.findElement(By.id("passwordInput")).sendKeys("test123");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Books")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Buy'])[2]/following::select[1]")).click();
    acceptNextAlert = true;
    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Buy'])[2]/following::select[1]"))).selectByVisibleText("4");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Buy'])[2]/following::button[1]")).click();
    assertEquals("Are you sure to buy 1984", closeAlertAndGetItsText());
    isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Logout'])[1]/following::div[4]"));
  }


 @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
