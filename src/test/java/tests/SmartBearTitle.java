package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBearTitle {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");

        String expectedTitle="Web Orders Login";
        String actualTitle=driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        expectedTitle="Web Orders";
        actualTitle=driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        String expectedURL="http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";
        String actualURL=driver.getCurrentUrl();

        if(expectedURL.equals(actualURL)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


    }
}
