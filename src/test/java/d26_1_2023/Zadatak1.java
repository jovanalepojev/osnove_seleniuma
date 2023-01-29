package d26_1_2023;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.navigate().to("https://example.cypress.io/todo");

        ArrayList<String> todos = new ArrayList<>();
        todos.add("Visit Paris");
        todos.add("Visit Prague");
        todos.add("Visit London");
        todos.add("Visit New York");
        todos.add("Visit Belgrade");

        for (int i = 0; i < todos.size(); i++) {
            driver.findElement(By.xpath("//*[@class='new-todo']")).sendKeys(todos.get(i) + '\n');
        }

        List<WebElement> todosElements =
                driver.findElements(By.xpath("//ul[@class='todo-list']/li/div"));

        for (int i = 0; i < todosElements.size(); i++) {
            if (todosElements.get(i).getText().isEmpty()) {
                System.out.println("not found");
            } else {
                System.out.println("found");
            }
        }

        for (int i = 0; i < todosElements.size(); i++) {

            Actions action = new Actions(driver);
            action.moveToElement(todosElements.get(i));

            todosElements.get(i).findElement(By.xpath("//ul[@class='todo-list']/li/div/button[1]"))
                    .click();
        }



    }
}


