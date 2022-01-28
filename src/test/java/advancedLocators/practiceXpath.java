package advancedLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practiceXpath {
    WebDriver driver;

    @Test
    public void testXpath() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/radio-button");

       String question = driver.findElement(By.xpath("//div[@class='mb-3']")).getText();


        System.out.println("The question on the page is: " +question);

        //next step is to select a yes button, but I NEED TO CLICK ON IT FIRST

        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();

        //after I clicked on it I need to make sure that my text contains my selection
        String resultText = driver.findElement(By.xpath("//span[@class='text-success']")).getText();//this will
        //store the "yes" text
        Assert.assertEquals("Yes", resultText.trim());
        //WE ALWAYS NEED TO TRIM OUR STRING BEFORE COMPARING
    }

    // navigate to https://opensource-demo.orangehrmlive.com/
    //login
    //verify Paul is in the welcome text


//    @Test
//    public void test3() throws InterruptedException{
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//
//        driver.get("https://opensource-demo.orangehrmlive.com/");
//
//        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
//        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
//        driver.findElement(By.xpath("//div[@id='divLoginButton']/input")).click();
//
//        //in order to find a needed text we need to wait until page is fully loaded
//        //this is what we do with thread.slepp
//        Thread.sleep(4000);
//
//        String welcomeText = driver.findElement(By.xpath("//a[starts-with(text(), 'Welcome')]")).getText();
//
//        //after I found my text I can add my assertion
//        Assert.assertEquals("Welcome text contains wrong name", welcomeText.contains("Mrudula"));
//    }
}
