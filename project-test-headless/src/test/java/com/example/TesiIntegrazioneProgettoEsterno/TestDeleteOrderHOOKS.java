package com.example.OrdersHOOKS;

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

public class TestDeleteOrderHOOKS {
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
  public void testDeleteOrder_loc_Hooks_release_0_0_1() throws Exception {
    driver.get("http://localhost:4200/auth");
    driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x132863171833-x-test-tpl-1]//*[@x132863171833-x-test-hook-15]")).click();
    driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x132863171833-x-test-tpl-1]//*[@x132863171833-x-test-hook-15]")).clear();
    driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x132863171833-x-test-tpl-1]//*[@x132863171833-x-test-hook-15]")).sendKeys("test@test.com");
    driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x132863171833-x-test-tpl-1]//*[@x132863171833-x-test-hook-18]")).click();
    driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x132863171833-x-test-tpl-1]//*[@x132863171833-x-test-hook-18]")).clear();
    driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x132863171833-x-test-tpl-1]//*[@x132863171833-x-test-hook-18]")).sendKeys("test123");
    driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x132863171833-x-test-tpl-1]//*[@x132863171833-x-test-hook-20]")).click();
    driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-1]//*[@x132885434011-x-test-tpl-1]//*[@x132885434011-x-test-hook-14]")).click();
    driver.findElement(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x184760422874-x-test-tpl-1]//*[@x132880204046-x-test-tpl-1]//*[@x132880204046-x-test-hook-4][2]//*[@x132880204046-x-test-hook-15]")).click();
    isElementPresent(By.xpath("//*[@x132889409660-x-test-tpl-1]//*[@x132889409660-x-test-hook-9]//*[@x132846648928-x-test-tpl-2]//*[@x132846648928-x-test-hook-4]//*[@x184760422874-x-test-tpl-1]//*[@x132880204046-x-test-tpl-1]//*[@x132880204046-x-test-hook-3]"));
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
