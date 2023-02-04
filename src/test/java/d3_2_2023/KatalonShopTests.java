package d3_2_2023;

import helper.Helper;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KatalonShopTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://cms.demo.katalon.com";

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void setup() {
        driver.get(baseUrl);
        System.out.println("Before Method");
    }
    @Test(priority = 10)
    @Description("Adding product with quantity to the cart")
    public void addingProductWithQuantityToTheCart() {

        driver.get(baseUrl + "/product/flying-ninja/");

        WebElement elementLastName = driver.findElement(By.xpath("//input[@type='number']"));
        elementLastName.getText();
        elementLastName.clear();

        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("3");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        WebElement message = driver.findElement(By.className("woocommerce-message"));

        Assert.assertTrue(message.getText().contains("Flying Ninja"),
                "Message doesn't contain right message");


        driver.findElement(By.className("woocommerce-message"))
                .findElement(By.tagName("a")).click();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/cart/",
                "URL verification");

        int cartElements = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
        Assert.assertEquals(cartElements,1,"There are no products in the cart");
    }
    @Test(priority = 20)
    @Description("Removing product from cart")
    public void removingProductFromCart() {
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/cart/']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/cart/",
                "URL verification");
        wait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath("//td[@class='product-quantity']"), 1));
        driver.findElement(By.xpath("//*[@class='remove']")).click();

        wait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath("//td[@class='product-quantity']"), 0));
    }
    @Test (priority = 30)
    @Description("Verify error is displayed when username is missing")
    public void verifyErrorIsDisplayedWhenUsernameIsMissing(){
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.name("login")).click();

		Assert.assertTrue(
				new Helper().elementExist(driver, By.className("woocommerce-error")),
				"Login error is not displayed.");
    }
    @Test(priority = 40)
    @Description("Verify error is displayed when password is missing")
    public void verifyErrorIsDisplayedWhenPasswordIsMissing(){
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.name("login")).click();

        Assert.assertTrue(
                new Helper().elementExist(driver, By.className("woocommerce-error")),
                "The username error is not displayed.");
    }
    @Test(priority = 50)
    @Description("Verify error is displayed when password is wrong")
    public void verifyErrorIsDisplayedWhenPasswordIsWrong(){
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("invalidpassword");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
                "ERROR: The password you entered for the username customer is incorrect. Lost your password?",
                "The password verification");
    }
    @Test(priority = 60)
    @Description("Verify error is displayed when user does not exist")
    public void verifyErrorIsDisplayedWhenUserDoesNotExist() {
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("ex: pass1234");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
                "ERROR: The password you entered for the username customer is incorrect. Lost your password?",
                "The password verification");
    }

        @Test(priority = 70)
        @Description("Verify successful login")
        public void verifySuccessfulLogin(){
            driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
            driver.findElement(By.id("username")).sendKeys("customer");
            driver.findElement(By.id("password")).sendKeys("crz7mrb.KNG3yxv1fbn");
            driver.findElement(By.name("login")).click();
            WebElement message2 = driver.findElement(By.className("woocommerce-MyAccount-content"));
            Assert.assertTrue(message2.getText().contains("Hello Katalon Parlitul_Changed"),
                    "Message doesn't contain right message");
        }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
