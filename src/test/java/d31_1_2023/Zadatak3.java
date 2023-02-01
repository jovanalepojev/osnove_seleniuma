package d31_1_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("https://itbootcamp.rs/");
        driver.manage().window().maximize();

        WebElement scroll = driver.findElement(By.xpath("//div[@class='vc_row wpb_row vc_row-fluid slider_bkgd']"));
        new Actions(driver).scrollToElement(scroll)
                .perform();

        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='carousel-item']/img"));

        for (int i = 0; i < elementList.size(); i++) {
            String url = elementList.get(i).getAttribute("src");

           try {
               int statusCode = new Helper().getHTTPResponseStatusCode(url);
                if (statusCode >= 200 && statusCode < 300) {
                    System.out.println("Link: " + url + " is available.");
                } else {
                   System.out.println("Link: " + url + " is not available.");
               }
           } catch (IOException e) {
                throw new RuntimeException(e);
           }


        }

        Thread.sleep(5000);
        driver.quit();

    }
}
