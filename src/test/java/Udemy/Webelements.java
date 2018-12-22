package Udemy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Webelements {

    public static void main(String[] args) throws Exception {
        boolean isChecked=false;
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().fullscreen();
        driver.findElement(By.partialLinkText("Practice")).click();
        Thread.sleep(2000);
        List<WebElement> radioButtons=driver.findElements(By.xpath("//input[contains(@type,'radio')]"));

        int size=radioButtons.size();
        System.out.println("size of the list: "+size);

        for(int i=0;i<size;i++){
            isChecked=radioButtons.get(i).isSelected();
            if(!isChecked){
                radioButtons.get(i).click();
                Thread.sleep(2000);

            }
        }
    }
}
