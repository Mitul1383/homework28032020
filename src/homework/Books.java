package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Books extends Utility {


        private WebDriver driver;
        private String baseUrl = "https://demo.nopcommerce.com/";
        private JavascriptExecutor js;

        @Before
        public void openBrowser() {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
            js = (JavascriptExecutor) driver;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(baseUrl);
        }


    @Test
    public void verifyUserShouldNavigateToBooksPage() {
        clickOnElement(By.linkText("Books"));
        String expectedText = "Books";
        String actualText = getTextFromElement(By.xpath("//div[@class=\"page-title\"]//h1"));
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Expected Result : " + expectedText);
        System.out.println("Actual Result : " + actualText);
    }

    @Test
    public void booksPage() {
        //Click on the Book link
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        //Sorting by A to Z
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        //Storing the actual list and creating the temp list and comparing the two
       // arrayListForEachLoopForString(By.tagName("h2"));
    }

    @Test
    public void showWishList() {
        //Click on Book link
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        //Sorting the Product by A to Z
        clickOnElement((By.xpath("//option[contains(text(),'Name: A to Z')]")));
        //Selecting the desired product
        clickOnElement(By.xpath("//select[@name='products-orderby']"));
        //Adding to wish list and verifying the actual message displayed matching the expected message
        clickOnElement(By.xpath(" //div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));
        String expectedText = "The product has been added to your wishlist";
        String actualText = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        sleepMethod();
        quitMethod();
    }
}




