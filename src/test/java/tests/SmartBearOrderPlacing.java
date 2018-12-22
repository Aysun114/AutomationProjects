package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SmartBearOrderPlacing {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();

        WebElement element=driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select sel=new Select(element);

        Thread.sleep(2000);
        sel.selectByVisibleText("FamilyAlbum");

        Thread.sleep(2000);
        WebElement num=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        num.sendKeys(Keys.DELETE+"2");

        Faker faker=new Faker();
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(faker.name().name());
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().streetAddress());
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().city());
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().state());
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("50291");
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("1234567890981274");
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("10/20");
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        String expected="New order has been successfully added.";
        String actual=driver.findElement(By.xpath("//div[@class='buttons_process']//strong")).getText();
        Thread.sleep(2000);
        if(expected.equals(actual)){
            System.out.println("Verification Passed");
        }else{
            System.out.println("Verification Failed");
        }

    }
}
