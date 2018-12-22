package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SmartBearVerify {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        driver.findElement(By.xpath("//a[@href='Default.aspx']")).click();

        verifyOrder(driver,"Susan McLaren");
        printAllNames(driver);

    }

        public static void verifyOrder(WebDriver driver, String name) {
            WebElement element = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody//tr[6]//td[2]"));
            if (name.equals(element.getText())) {
                System.out.println("Name verification Passed");
            } else {
                System.out.println("Name verification Failed");
            }
        }

        public static void printAllNames(WebDriver driver){
             List<WebElement> names =driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody/tr/td[2]"));
             int size=names.size();
             for(int i=0;i<size;i++){
                 System.out.println(names.get(i).getText());
             }

            }

        }

