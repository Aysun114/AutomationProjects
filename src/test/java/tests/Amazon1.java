package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/*

1. open browser
2.go to https://amazon.com
3.verify that default dropdown option is all
4.verify that all options are sorted alphabetically
5.Click on the menu icon on the left
6.click on Full Store directory
7.capture all of the main department names in the page.
8.verify that departments names are sorted alphabetically
9.verify that all departments names are listed in the dropdown from step 4

*/

public class Amazon1 {
    WebDriver driver;
    Select allDepartments;

    @BeforeClass
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://amazon.com");


    }

    @Test(priority = 0)
    public void testDefaultValue() {

        //finding the element with a select tag
        WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
        //create a Select class object
        allDepartments = new Select(selectElement);
        //get the current selected option
        String selectednOption = allDepartments.getFirstSelectedOption().getText();
        // verify that default dropdown option is all
        //TODO skipping because failing
        Assert.assertEquals(selectednOption, "All");

    }

    @Test(priority = 1)
    public void testAlphabetical() {
        for (int i = 0; i < allDepartments.getOptions().size() - 1; i++) {
            String current = allDepartments.getOptions().get(i).getText();
            String next = allDepartments.getOptions().get(i + 1).getText();
            System.out.println("comparing: " + current + " with " + next);
            Assert.assertTrue(current.compareTo(next) <= 0);
        }
    }

    @Test(priority = 2)
    public void mainDepartmentsTest() throws InterruptedException {
        driver.findElement(By.cssSelector("i.hm-icon.nav-sprite")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href='/gp/site-directory?ref_=nav_em_T1_0_2_2_32__fullstore']")).click();

        List<WebElement> mainDepts = driver.findElements(By.cssSelector("h2.fsdDeptTitle"));

        for (WebElement option : mainDepts) {
            System.out.println(option.getText());
        }
    }
}