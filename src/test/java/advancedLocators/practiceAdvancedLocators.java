package advancedLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class practiceAdvancedLocators {
WebDriver driver;

@Before
    public void setUp() {
    //this is a set up method for every single test annotation
    //we initialize the driver
    //maximize the window
    //set timeout

    WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
}

@After
    public void tearDown() {
    driver.close();
    }
@Test

    public void test1() {
    //try out findElements()
    //but first we need to navigate to devX page
    driver.get("https://devxschool.com/");
    //after driver.get we don't need Thread.sleep()
    //BECAUSE .get METHOS AUTOMATICALLY WAITS FOR THE WEBPAGE TO FULLY LOAD ALL THE WEBELEMENTS

    //NOW I WANT TO PRINT THE TEXT OF THE FIRST LINK ON THE PAGE
    WebElement firstLink = driver.findElement(By.tagName("a"));
    System.out.println("First link is: "+firstLink.getAttribute("href"));


    //we want to print out text of every single link on the page

    List<WebElement> links = driver.findElements(By.tagName("a"));

            for(WebElement link: links) {
                System.out.println(link.getAttribute("href"));
            }

            //button[type='submit'][id='submit'][class='btn btn-primary']
}

@Test
    public void printPhoneBrands() throws InterruptedException{
    //navigate to the web site
    driver.get("https://www.amazon.com/");

    //locate input field and type iphone
    driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);
    Thread.sleep(3000);

    //we will see multiple elements, how can we store it
    List<WebElement> brands = driver.findElements(By.cssSelector("li[id^='p_89/'"));

    //now we will print out every single brand name

    for(WebElement brand: brands) {
        System.out.println(brand.getText());
    }
    //here we practiced a CSS SELECTOR
}
}
