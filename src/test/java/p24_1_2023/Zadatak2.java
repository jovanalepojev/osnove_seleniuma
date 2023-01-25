package p24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login");
        driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("itbootcamp");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("ITBootcamp2021!");
        driver.findElement(By.xpath("//form/div[4]/div[1]/button[@id='login']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(), 'Log out')]")).click();
        driver.quit();







    }
}
