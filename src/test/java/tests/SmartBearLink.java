package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.List;

public class SmartBearLink {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        List<WebElement> links=driver.findElements(By.xpath("//ul[@id='ctl00_menu']//li"));
        int size=links.size();
        System.out.println(size);

        for(int i=0;i<size;i++){
            String linkText=links.get(i).getText();
            System.out.println(linkText);
        }


    }
}
