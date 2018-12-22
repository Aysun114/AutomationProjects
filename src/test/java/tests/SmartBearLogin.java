package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBearLogin {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        negativeLogin(driver,"Tester","test");
//
//        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
//        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("");
//        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
//       String invalid="Invalid Login or Password.";
//       WebElement login=driver.findElement(By.id("ctl00_MainContent_status"));
//
//        if(invalid.equals(login.getText())){
//            System.out.println("passed");
//        }else {
//            System.out.println("failed");
//        }
    }

    public static void negativeLogin(WebDriver driver,String usernameValue,String passwordValue){

     WebElement username=driver.findElement(By.id("ctl00_MainContent_username"));
     WebElement password=driver.findElement(By.id("ctl00_MainContent_password"));
     WebElement loginBtn= driver.findElement(By.name("ctl00$MainContent$login_button"));

     username.clear();
        username.sendKeys(usernameValue);
        password.clear();
        password.sendKeys(passwordValue);
        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));
        if(errorMessage.getText().equals("Invalid Login or Password.")){
            System.out.println("Error message verification PASSED");
        }
        else{
            System.out.println("Error message verification FAILED");
        }

    }
}
