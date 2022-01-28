package basicLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassLocator {
    WebDriver driver;
    @Test
    public void testLinkLocator() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        //make sure you are passing a full text of link
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();

        Thread.sleep(3000);

        Assert.assertTrue(driver.getCurrentUrl().contains("mail"));


    }

@Test
public void testPartialLink() throws InterruptedException {
    WebDriverManager.chromedriver().setup();

    driver = new ChromeDriver();
    driver.get("https://www.google.com/");
// using partial link we will click on how search works

    WebElement link = driver.findElement(By.partialLinkText("How Google"));
    link.click();
    Thread.sleep(2000);

    //discover how google search works

    String expected = "Discover How Google Search Works ";

    Assert.assertTrue("Title verification failed. Expected: "+ expected + "Actual"
            +driver.getTitle(), driver.getTitle().contains(expected));

}
    //this is a method to clean up after your test
    @After
    public void tearDown() {
        driver.close();
    }
}
