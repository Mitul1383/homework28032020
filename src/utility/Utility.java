package utility;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Utility {

        public WebDriver driver;
        public JavascriptExecutor jse;
        //click method

        public void chromeBrowserDriver() {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        public void scriptExecutor() {
            jse.executeScript("window.scrollBy(0,-1800);");
        }

        public void maximiseTheScreen() {
            driver.manage().window().maximize();
        }

        public void clickOnElement(By by) {
            driver.findElement(by).click();
        }

        public void getBaseUrl(String str) {
            driver.get(str);
        }

        //SendKeys MEthod for writing text
        public void sendTextToElement(By by, String text) {
            driver.findElement(by).sendKeys(text);
        }

        //method to get text
        public String getTextFromElement(By by) {
            return driver.findElement(by).getText();
        }
        //select Methods for visible Text,ByValue and ByIndex

        public void selectByVisibleText(By by, String text){
            Select select=new Select(driver.findElement(by));
            select.selectByVisibleText(text);
        }

        public void selectByValue(By by, String str) {
            Select select = new Select(driver.findElement(by));
            select.selectByValue(str);
        }

        public void selectByIndex(By by, int Index) {
            Select select = new Select(driver.findElement(by));
            select.selectByIndex(Index);
        }

        //Methods for Action class
        public void mouseHover(By by) {
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(by)).perform();
        }

        public void implicitlyWait(int sec) {
            driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        }

        public void sleepMethod() throws InterruptedException {
            Thread.sleep(2000);
        }

        //AlertMethods
        public void alertDismiss() {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }

        public void alertGetText() {
            Alert alert = driver.switchTo().alert();
            alert.getText();
        }

        public void alertAccept() {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }

        public void quitMethod() {
            driver.quit();
        }
        //method to return list of webelement

        public void arrayListForEachLoopForString(By by) {
            List<String> actualList = new ArrayList<>();
            List<WebElement> stroredList = driver.findElements(by);
            for (WebElement element : stroredList) {
                actualList.add(element.getText());
            }
            List<String> tempList = new ArrayList<>();
            tempList.addAll(actualList);
            System.out.println("Expected Result" + actualList);
            Collections.sort(tempList);
            System.out.println("Actual List" + tempList);
            Assert.assertEquals(actualList, tempList);
        }

        public void arrayListforEachLoopForInt(By by) {
            List<WebElement> elements = driver.findElements(by);
            List<String> webSortedPrices = elements.stream().map(WebElement::getText).collect(Collectors.toList());
            System.out.println("Expected Results" + webSortedPrices);
            List<String> mySortedPrices = new ArrayList<>();
            for (WebElement element : elements) {
                String text = element.getText();
                mySortedPrices.add(text);
            }
            System.out.println("Actual Result" + mySortedPrices);
            Assert.assertEquals(webSortedPrices, mySortedPrices);
        }

        //This method is to check if a particular element is displayed
        public boolean elementIsDisplayed(WebElement element, String str) {
            if (str.equals(element.getText())) {
                return true;
            } else {
                return false;
            }
        }
        public boolean elementIsEnabled(WebElement element, String str) {
            if (str.equals(element.getText())) {
                return true;
            } else {
                return false;
            }
        }

    }
}






