package com.example.PurchasesTRADITIONAL;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import org.openqa.selenium.support.ui.Select;

public class TestPurchaseAllQuantitiesTRADITIONAL {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testPurchaseAllQuantitiesTRADITIONAL() throws Exception {
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
