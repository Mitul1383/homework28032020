package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import utility.Utility;
public class Computer extends Utility {
    private String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void openBrowser() {
        chromeDriver();
        maximizeWindow();
        implicitWaitSeconds(10);
        openUrl(baseUrl);    }
     //User should navigate to Computers page & Assert text "Computers"
    @Test
    public void UserShouldNavigateToComputerPage() {
        clickOnElement(By.linkText("Computers"));    }
    //TEST - User should navigate to Computers page, select Build your own computer,
    @Test
    public void addProductToShoppingCart() throws InterruptedException {

        clickOnElement(By.linkText("Computers"));
        //element for desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[@href='/desktops']"));
        sleepMethod();
        clickOnElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-2 div.page.category-page div.page-body div.product-grid div.item-grid div.item-box:nth-child(1) div.product-item div.details h2.product-title > a:nth-child(1)"));
        sleepMethod();
        //element for add to cart button
        clickOnElement(By.id("add-to-cart-button-1"));
    }
    @After
    public void closeBrowser() throws InterruptedException {
        sleepMethod();
        //quitMethod();
    }
}


