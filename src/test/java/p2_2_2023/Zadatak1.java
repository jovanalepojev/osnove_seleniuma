package p2_2_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Zadatak1 {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://cms.demo.katalon.com/";

    @BeforeClass
    public void BeforeClass (){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://cms.demo.katalon.com/");
    }

    @Test
    public void clickOnMyAccountLink(){
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        Assert.
                assertEquals(driver.
                        getTitle(), "My account – Katalon Shop","My Account - Katalon Shop verification");
        Assert.
                assertEquals(driver
                        .getCurrentUrl(), baseUrl + "/my-account", "URL verification");
    }
    @Test
    public void checkInputTypes(){

        Assert.
                assertEquals(driver.
                        findElement(By.id("username")).
                        getAttribute("type"),
                        "text",
                        "E-mail verification");

        Assert.assertEquals(driver.
                findElement(By.id("password")).
                getAttribute("type"), "password", "Password verification");
        Assert.
                assertEquals(driver.findElement(By.
                        id("rememberme")).
                        getAttribute("type"),"checkbox", "Checkbox verification");

        Assert.assertFalse(driver.findElement(By.id("rememberme")).isSelected(), "Checkbox is checked");

    }
    @Test
    public void displayErrorWhenCredentialsAreWrong(){
        driver.get("https://cms.demo.katalon.com/my-account/");
        driver.findElement(By.id("username")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.id("password")).sendKeys("invalid123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        Assert.assertTrue(new Helper().elementExist(driver,By.className("woocommerce-error")),
                "Login error is not displayed");

        Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
                "ERROR: Invalis email address. Lost your password?",
                "Error is not displayed when credentials are invalid");
        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"),
                "Not on my account page");

    }

    @AfterMethod
    public void afterMethod(){

    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        System.out.println("After CLASS");
    }

}
