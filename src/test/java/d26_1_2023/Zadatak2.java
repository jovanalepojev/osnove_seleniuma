package d26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> elementList = driver.findElements(By.xpath("//*[@class='col-md-12']/div"));

        for (int i = 0; i < elementList.size(); i++) {
                driver.findElement(By.xpath("//*[@class='col-md-12']/div/button")).click();

        }

        List<WebElement> elementList2 = driver.findElements(By.xpath("//*[@class='col-md-12']/div"));

        if (elementList2.isEmpty()){
            System.out.println("Is empty");

        } else {
            System.out.println("Is not empty");
        }

        Thread.sleep(5000);
        driver.quit();


    }
}
