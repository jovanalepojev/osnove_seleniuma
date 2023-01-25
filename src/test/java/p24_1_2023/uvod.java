package p24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class uvod {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

//        driver.get("https://cms.demo.katalon.com/");
//        driver.get("https://youtube.com/");
//        driver.navigate().to("https://cms.demo.katalon.com/");
        driver.navigate().to("https://google.com/");
        driver.manage().window().maximize();
//        driver.navigate().back();
//        driver.navigate().forward();
//        Thread.sleep(5000);

        String imgAtrb = driver.findElement(By.xpath("//img[@class='lnXdpd']")).getAttribute("src");
        System.out.println(imgAtrb);
//        driver.navigate().refresh();

//       WebElement searchInput =  driver.findElement(By.xpath("//input[@name='q']"));
//       searchInput.sendKeys("IT Bootcamp");
//       searchInput.sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
//        WebElement firstLink = driver.findElement(By.xpath("//a[@href='https://itbootcamp.rs/']"));
//        firstLink.click();
//        Thread.sleep(5000);


        driver.quit();

    }
}
