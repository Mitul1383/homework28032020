package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.concurrent.TimeUnit;

public class Electronics extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {


    public void mouseOverElectronics() throws InterruptedException {
        mouseOverElectronics (By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));
       // Thread.sleep(3000);
        //mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));
        moveToElement(By.linkText("Camera & photo"));
        String expectedResult = "Camera & photo";
        String actualResult = getTextFromElement(By.linkText("Camera & photo"));
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("Expected Result : " + expectedResult);
        System.out.println("Actual Result : " + actualResult);
    }

    @Test
    public void assertPositionLowToHigh() {
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));
        //mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));
        mouseHover(By.linkText("Camera & photo"));
        selectByVisibleText(By.id("products-orderby"), "Price: Low to High");
        arrayListforEachLoopForInt(By.className("prices"));
    }

    @After
    public void closeBrowser() throws InterruptedException {
        sleepMethod();
        quitMethod();
    }
}


























