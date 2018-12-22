package Udemy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultipleSelect {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().fullscreen();
        driver.findElement(By.partialLinkText("Practice")).click();
        Thread.sleep(2000);

        WebElement element=driver.findElement(By.id("multiple-select-example"));
        Select sel=new Select(element);

        Thread.sleep(2000);
        System.out.println("Select orange by value");
        sel.selectByValue("orange");

        Thread.sleep(2000);
        System.out.println("De-select orange by value");
        sel.deselectByValue("orange");

        Thread.sleep(2000);
        System.out.println("Select peach by index");
        sel.selectByIndex(2);

        Thread.sleep(2000);
        System.out.println("Select apple by visible text");
        sel.selectByVisibleText("Apple");

        Thread.sleep(2000);
        System.out.println("Print all selected options");
        List<WebElement> list=sel.getAllSelectedOptions();
        int size=list.size();
        for(int i=0;i<size;i++){
            String selectedNames=list.get(i).getText();
            System.out.println(selectedNames);
        }

        Thread.sleep(2000);
        System.out.println("De-select all selected options");
        sel.deselectAll();


    }
}
