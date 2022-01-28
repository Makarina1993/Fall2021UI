package browserSynchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PracticeWaits {
WebDriver driver;
    // before I create my first test case  I want to provide a driver Set up and after test clean up
    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       // driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
@After
    public void tearDown() {
        driver.close();
}
@Test
public void amazonTest() {
        driver.get("https://www.amazon.com/");
}


@Test
    public void testEtsy() {
        driver.get("https://www.etsy.com/");// thge only case when you don't need to wait to continue
        //click sign in button
    //. get waits for the page to be fully loaded, after it's loaded - it goes to the next line
    // next thing we need to inspect the sign in button , BUT FIRST WE NEED TO INSPECT IT

    driver.findElement(By.xpath("//button[contains(@class,'select-signin')]")).click();
    //HERE WE WILL ADD EXPLICIT WAIT TO WAIT FOR OUR REGISTER BUTTON TO BE PRESENT ON THE PAGE
    //so, here we put the syntax of the explicit wait
    WebDriverWait wait = new WebDriverWait(driver, 3);
    WebElement registerButton = wait.until(ExpectedConditions.presenceOfElementLocated
            (By.xpath("//button[contains(@class,'select-register')]")));


    //locate register button
    //so, now I'm creating a WebElement
    //WebElement registerButton = driver.findElement(By.xpath("//button[contains(@class,'select-register')]"));

    //whenever we work with elements WE NEED TO GIVE IT AN EXACT VARIABLE NAME TO SEE WHAT EXACTLY WE ARE WORKING ON
    //FOR EX. registerButton in the above line 43, but coukld be registerEmail

    //so, after I located this register button I need to see if the message "Registration is easy" is displayed
    // right now we need to click on a register button , after that we inspect it

    registerButton.click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[starts-with(text(), 'Registration')]")));
    //creating another WebElement
    WebElement registrationForm = driver.findElement(By.xpath("//p[starts-with(text(), 'Registration')]"));
    ////p[starts-with(text(), 'Registration')] -> here we are using partial text search after letter p
    //-> p is called p element that starts with . Text is an attribute, it uses parenthesis(), not @

    // NOW I NEED TO MAKE SURE IT'S DISPLAYED ON THE SCREEN

    Assert.assertTrue("The registration form is not displayed", registrationForm.isDisplayed());
}
}
