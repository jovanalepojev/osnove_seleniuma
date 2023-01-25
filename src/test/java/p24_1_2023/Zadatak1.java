package p24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://cms.demo.katalon.com/");
        driver.findElement(By.xpath("//input[@name='s']")).sendKeys("Flying Ninja");
        driver.findElement(By.xpath("//*[contains(@class, 'search-submit')]")).click();
        Thread.sleep(5000);
        driver.quit();

    }
}
