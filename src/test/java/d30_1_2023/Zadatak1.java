package d30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.navigate().to("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//select[@id='delay-select']/option[@value='2000']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("infinite-scroll-button")));


        WebElement scrollElement = driver.findElement(By.xpath("//button[@id='infinite-scroll-button']"));
        scrollElement.click();

        new Actions(driver).scrollToElement(scrollElement).perform();

        wait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath("//div[@class='item']"), 5));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.id("infinite-scroll-button"))));

        Thread.sleep(5000);
        driver.quit();


    }
}
