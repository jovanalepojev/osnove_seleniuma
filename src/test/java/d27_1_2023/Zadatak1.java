package d27_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.navigate().to("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.manage().window().maximize();
        List<WebElement> elementList= driver.findElements(By.xpath("//div[@class='container text-center']/button"));

        for (int i=0; i< elementList.size();i++){
            elementList.get(i).click();
        }
        Thread.sleep(1000);
        driver.quit();


    }
}
