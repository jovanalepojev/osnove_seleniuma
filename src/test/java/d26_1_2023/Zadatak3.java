package d26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://geodata.solutions/");

        WebElement select2 = driver.findElement(By.id("countryId"));
        Select select3 = new Select(select2);
        select3.selectByVisibleText("Australia");

        WebElement select1 = driver.findElement(By.id("stateId"));
        Select select = new Select(select1);
        select.selectByVisibleText("South Australia");
        Thread.sleep(2000);

        WebElement select4 = driver.findElement(By.id("cityId"));
        Select select5 = new Select(select4);
        select5.selectByVisibleText("Agery");
        Thread.sleep(2000);


        Thread.sleep(5000);
        driver.quit();





    }
}
