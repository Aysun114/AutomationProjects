package Udemy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioCheckButton {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().fullscreen();
        driver.findElement(By.partialLinkText("Practice")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("bmwradio")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("hondaradio")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("bmwcheck")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("benzcheck")).click();

    }

}
