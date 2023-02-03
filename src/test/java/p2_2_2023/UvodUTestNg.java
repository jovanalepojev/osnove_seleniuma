package p2_2_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

public class UvodUTestNg {
  private WebDriver driver;
  private WebDriverWait wait;
  @BeforeClass
  public void beforeClss(){

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    this.driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    System.out.println("Before CLASS");

  }

  @BeforeMethod
  public void beforeMethod(){
    driver.navigate().to("https://google.com");
    System.out.println("Before TEST");
  }
  @Test
    public void googleTitleTest() throws InterruptedException {
    int numberOfLinks = driver.findElements(By.tagName("a")).size();
            Assert.assertEquals(numberOfLinks, 40, "Number of inks on home page.");

  }
  @Test
  public void googleUrlTest(){
  Assert.assertEquals(driver.getCurrentUrl(), "https://google.com/");
  }
  @AfterMethod
  public void afterMethod(){
    System.out.println("After TEST");

  }
  @AfterClass
  public void afterClass() throws InterruptedException {
    Thread.sleep(5000);
    driver.quit();
    System.out.println("After CLASS");
  }
}
