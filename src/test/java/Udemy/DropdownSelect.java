package Udemy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownSelect {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().fullscreen();
        driver.findElement(By.partialLinkText("Practice")).click();
        Thread.sleep(2000);
        WebElement element=driver.findElement(By.id("carselect"));
        Select sel=new Select(element);

        Thread.sleep(2000);
        System.out.println("Select Benz by value");
        sel.selectByValue("benz");

        Thread.sleep(2000);
        System.out.println("Select Honda by index");
        sel.selectByIndex(2);

        Thread.sleep(2000);
        System.out.println("Select Bmw by visible text");
        sel.selectByVisibleText("BMW");

        Thread.sleep(2000);
        System.out.println("Print the list of all elements");
        List<WebElement> list=sel.getOptions();
        int size=list.size();

        for (int i=0;i<size;i++){
            String optionName=list.get(i).getText();
            System.out.println(optionName);
        }




    }
}
