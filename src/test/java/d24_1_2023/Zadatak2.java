package d24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Zadatak2 {
//    Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//    Visit Paris
//    Visit Prague
//    Visit London
//    Visit New York
//    Visit Belgrade
//    Maksimizirati prozor
//    Ucitati stranicu https://example.cypress.io/todo
//    Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//    Nakon svakog unosa todo-a, unosi se enter
//    Cekanje od 5s
//    Zatvorite pretrazivac

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        ArrayList<String>todoList=new ArrayList<>();
        todoList.add("Visit Paris");
        todoList.add("Visit Prague");
        todoList.add("Visit London");
        todoList.add("Visit New York");
        todoList.add("Visit Belgrade");

        driver.manage().window().maximize();
        driver.navigate().to("https://example.cypress.io/todo");

        for (String todo : todoList  ){
            driver.findElement(By.xpath("//input[@class='new-todo']")).sendKeys(todo + '\n');

        }
        Thread.sleep(5000);
        driver.quit();


    }
}
