package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Amazon {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.com");
        driver.manage().window().fullscreen();
        List<WebElement> elm = driver.findElements(By.xpath("//select[@id='searchDropdownBox']//option"));
        int size = elm.size();
        for (int i = 0; i <size; i++) {
            System.out.println(elm.get(i).getText());
            if (elm.get(i).isSelected()) {
                System.out.println(elm.get(i).getText());
            }
        }
        System.out.println(size);

        verifyDepartmentDropdown(driver,"Courses");
    }

    public static void verifyDepartmentDropdown(WebDriver driver,String option){
        List<WebElement> elm = driver.findElements(By.xpath("//select[@id='searchDropdownBox']//option"));
        for (int i = 0; i < elm.size(); i++) {
            if (elm.get(i).getText().equals(option)) {
                elm.get(i).click();
                System.out.println(elm.get(i).isSelected());

            }
        }
   }

}


