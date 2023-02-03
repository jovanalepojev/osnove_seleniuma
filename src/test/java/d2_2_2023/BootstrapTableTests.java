package d2_2_2023;

import helper.Helper;
import jdk.jfr.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.management.DescriptorKey;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BootstrapTableTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://s.bootsnipp.com";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @BeforeMethod
    public void setup(){
        driver.get(baseUrl);

    }
    @Test (priority = 1)
    @DescriptorKey("Edit Row")
    public void editRow() {
        driver.get(baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title verification.");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Assert.assertFalse(new Helper()
                        .elementExist(driver, By.xpath("")),
                "The Editing dialog is visible");

        WebElement elementName = driver.findElement(By.id("fn"));
        elementName.getText();
        elementName.clear();

        WebElement elementLastName = driver.findElement(By.id("ln"));
        elementLastName.getText();
        elementLastName.clear();

        WebElement elementMiddleName = driver.findElement(By.id("mn"));
        elementMiddleName.getText();
        elementMiddleName.clear();

        driver.findElement(By.id("fn")).sendKeys("Michael");
        driver.findElement(By.id("ln")).sendKeys("Scott");
        driver.findElement(By.id("mn")).sendKeys("John");

        driver.findElement(By.id("up")).click();

        Assert.assertFalse(new Helper()
                        .elementExist(driver, By.xpath("")),
                "The Editing dialog is visible");

        Assert.assertEquals(driver.findElement(By.id("f1")).getText(),
                "Michael",
                "First name verification");
        Assert.assertEquals(driver.findElement(By.id("l1")).getText(),
                "Scott",
                "Last name verification");
        Assert.assertEquals(driver.findElement(By.id("m1")).getText(),
                "John",
                "Middle name verification");
    }

    @Test(priority = 2)
    @Description("Delete Row")
    public void deleteRow(){
        driver.get(baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title verification.");
        driver.findElement(By.
                        xpath("//button[@data-target='#delete']")).click();
        Assert.assertFalse(new Helper().elementExist(driver, By.xpath("modal-content")),
                "The Deleting dialog is invisible");

        driver.findElement(By.id("del")).click();
        Assert.assertFalse(new Helper().elementExist(driver, By.xpath("modal-content")),
                "The Deleting dialog is visible");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("deleteModal")));
        int expectedRowCount = 2;
        int actualRowCount = driver.findElements(By.xpath("//table/tbody/tr")).size();
        Assert.assertEquals(actualRowCount, expectedRowCount, "" +
                "Number of rows in table verification");
    }
    @Test(priority = 3)
    @Description("Take a Screenshot")
    public void takeAScreenshot() throws IOException {
        driver.get(baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title verification.");

        TakesScreenshot ts=(TakesScreenshot)driver;
        FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),
                new File("screenshots/slike.png"));
    }
    @AfterMethod
     public void afterMethod() {
            System.out.println("After Method");
        }
     @AfterClass
        public void afterClass() throws InterruptedException {
            Thread.sleep(2000);
            driver.quit();
        }








}
