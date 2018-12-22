package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Etsy {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://etsy.com");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("search-query")).sendKeys("mitten"+ Keys.ENTER);

        WebElement anywhere=driver.findElement(By.xpath("//input[@aria-label='Anywhere']"));
        if(anywhere.isSelected()){
            System.out.println("Anywhere checked is Passed");
        }else{
            System.out.println("Anywhere checked is Failed");
        }

        WebElement usa=driver.findElement(By.xpath("//input[@aria-label='United States']"));
        if(!usa.isSelected()){
            System.out.println("Usa unchecked is Passed");
        }else{
            System.out.println("Usa unchecked is Failed");
        }

        usa.sendKeys(Keys.ENTER);
        WebElement anywhere2=driver.findElement(By.xpath("//input[@aria-label='Anywhere']"));
        if(!anywhere2.isSelected()){
            System.out.println("Anywhere checked is Passed");
        }else{
            System.out.println("Anywhere checked is Failed");
        }

        WebElement usa2=driver.findElement(By.xpath("//input[@aria-label='United States']"));
        if(usa2.isSelected()){
            System.out.println("Usa unchecked is Passed");
        }else{
            System.out.println("Usa unchecked is Failed");
        }

    }
}
