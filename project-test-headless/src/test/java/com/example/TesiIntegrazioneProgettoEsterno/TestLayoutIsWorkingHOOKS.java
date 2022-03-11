package com.example.SignupHOOKS;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class TestLayoutIsWorkingHOOKS {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver(options);
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testLayoutIsWorking_loc_Hooks_release_0_0_1() throws Exception {
    driver.get("http://localhost:4200/auth");
    try {
      assertEquals("E-Mail", driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x132863171833-x-test-tpl-1]//*[@x132863171833-x-test-hook-14]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Password", driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x132863171833-x-test-tpl-1]//*[@x132863171833-x-test-hook-17]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("", driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x132863171833-x-test-tpl-1]//*[@x132863171833-x-test-hook-15]")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("", driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x132863171833-x-test-tpl-1]//*[@x132863171833-x-test-hook-18]")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
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
