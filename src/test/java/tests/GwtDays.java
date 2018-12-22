package tests;

import Udemy.Webelements;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class GwtDays {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.manage().window().fullscreen();

        Thread.sleep(2000);
        List<WebElement> elmList=driver.findElements(By.xpath("//span[@class='gwt-CheckBox']"));
        Thread.sleep(2000);
        System.out.println(elmList.size());
        int size=elmList.size();
        Random rd=new Random();
        int rdValue=rd.nextInt(elmList.size());

            if (elmList.get(rdValue).isDisplayed()) {
                elmList.get(rdValue).click();
                Thread.sleep(2000);
                System.out.println(elmList.get(rdValue).getText());
                Thread.sleep(2000);



        }

    }
}
