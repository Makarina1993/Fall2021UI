package basicLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeBasicLocators {
    WebDriver driver;
    @Test
    public void testClassLocators() {
// navigate to Google, find link "celebrating women.." and print out the text of the link and verify link text
        //contains words "future leaders"

        //the new way we set up a driver - independent from jar file
        //this is new way you set up your driver - same as System.setProperty did
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        WebElement link = driver.findElement(By.className("NKcBbd"));

        String text = link.getText();
        System.out.println(text);

        //I need to add an assertion
        Assert.assertTrue("link text verification did not contain on Spanish", text.contains("in Spanish"));
        driver.close();

    }

    // create a new test where you will navigate to
    //use tag name locator and find the main heading on the page
    //verify it contains word "
}
