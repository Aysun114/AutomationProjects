package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Openxcell {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://openxcell.com");
        driver.manage().window().fullscreen();

        System.out.println(driver.getTitle());

       WebElement cs=driver.findElement(By.linkText("Case Studies"));
       System.out.println(cs.getAttribute("class"));
        System.out.println(cs.getAttribute("href"));
        System.out.println(cs.getText());
        List<WebElement> prg= driver.findElements(By.xpath("//body//a"));
        System.out.println(prg.size());

        for(WebElement p:prg){
            System.out.println(p.getText());
        }

    }

}
