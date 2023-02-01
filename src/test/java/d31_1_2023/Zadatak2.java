package d31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("https://itbootcamp.rs/");
        driver.manage().window().maximize();


        WebElement hoverableVesti = driver.findElement(By.xpath("//ul/li[@id='menu-item-6408']"));
        hoverableVesti.getAttribute("Kursevi");
        new Actions(driver)
                .moveToElement(hoverableVesti)
                .perform();
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@href='https://itbootcamp.rs/category/mediji-o-nama/']")));

        WebElement hoverableKursevi = driver.findElement(By.xpath("//ul/li[@id='menu-item-5362']"));
        new Actions(driver)
                .moveToElement(hoverableKursevi)
                .perform();
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@href='https://itbootcamp.rs/pregled-kurseva/']")));

        WebElement hoverablePrijava = driver.findElement(By.xpath("//ul/li[@id='menu-item-5453']"));
        new Actions(driver)
                .moveToElement(hoverablePrijava)
                .perform();
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@href='https://itbootcamp.rs/prijava-testiranje-softvera-qa/']")));

        Thread.sleep(5000);
        driver.quit();

    }
}
