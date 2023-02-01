package d30_1_2023;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.security.Key;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.navigate().to("https://docs.katalon.com/");
        driver.manage().window().maximize();

      WebElement element = driver.findElement(By.tagName("html"));
      element.getAttribute("data-theme");

      if(element.getAttribute("data-theme").contains("light")) {
          System.out.println("Theme is Light");
      } else {
          System.out.println("Theme is not Light");
      }

      driver.findElement(By.xpath("//*[@class='clean-btn toggleButton_rCf9']")).click();

      element.getAttribute("data-theme");
        if(element.getAttribute("data-theme").contains("dark")) {
            System.out.println("The theme is dark");
        } else {
            System.out.println("The theme is not dark");
        }

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("k").keyUp(Keys.CONTROL).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']")));

        WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
        String type = searchInput.getAttribute("type");
        System.out.println(type);

        Thread.sleep(5000);
        driver.quit();
    }
}
