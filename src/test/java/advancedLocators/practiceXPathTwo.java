package advancedLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practiceXPathTwo {
    WebDriver driver;

    @Test
    public void test3() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//div[@id='divLoginButton']/input")).click();

        //in order to find a needed text we need to wait until page is fully loaded
        //this is what we do with thread.slepp
        Thread.sleep(3000);

        String welcomeText = driver.findElement(By.xpath("//a[starts-with(text(), 'Welcome')]")).getText();

        //after I found my text I can add my assertion
        Assert.assertTrue("Welcome text contains", welcomeText.contains("Welcome"));

    }
    @After
    public void tearDown() {
        driver.close();
    }
}
