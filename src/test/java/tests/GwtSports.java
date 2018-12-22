package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class GwtSports {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
        driver.manage().window().fullscreen();
        Thread.sleep(5000);

        WebElement elm=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input"));
        System.out.println(elm.isSelected());

        List<WebElement> elements=driver.findElements(By.xpath("//span[@class='gwt-RadioButton']/input[@name='sport']"));

        Random rd=new Random();
        int randomValue=rd.nextInt(elements.size());
        elements.get(randomValue).click();
        if(elements.get(randomValue).isSelected()){
            System.out.println("Random option is selected");
        }else{
            System.out.println("Random option is not selected");
        }



       }


    }

