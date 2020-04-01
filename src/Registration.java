import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.Random;

public class Registration extends Utility {
    @Before
    public void openDriver() {
        chromeBrowserDriver();
        maximiseTheScreen();
        implicitlyWait(10);
        driver.get(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPAgeSuccessfully() {
        /*WebElement registrationLink = driver.findElement(By.xpath("//div[@class='header-links-wrapper']//a[contains(text(),'Register')]"));
        registrationLink.click();*/
        clickOnElement(By.xpath("//div[@class='header-links-wrapper']//a[contains(text(),'Register')]"));
        //WebElement welcomemsg = driver.findElement(By.xpath("//div[@class='title']//strong[contains(text(),'Your Personal Details')]"));
        String expectedText = "Your Personal Details";
        String actualText = getTextFromElement(By.xpath("//div[@class='title']//strong[contains(text(),'Your Personal Details')]"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyUsershouldRegisterSuccessfully() throws InterruptedException {
        /*WebElement registrationLink = driver.findElement(By.xpath("//div[@class='header-links-wrapper']//a[contains(text(),'Register')]"));
        registrationLink.click();*/
        clickOnElement(By.xpath("//div[@class='header-links-wrapper']//a[contains(text(),'Register')]"));
        Thread.sleep(3000);
        /*WebElement genderMale = driver.findElement(By.xpath("//div[@class='gender']//input[@id='gender-male']"));
        //WebElement genderMale=driver.findElement(By.)
        genderMale.click();*/
        clickOnElement(By.xpath("//div[@class='gender']//input[@id='gender-male']"));

        /*WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Mitul");*/
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Mitul");
        /*WebElement lastNAme = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastNAme.sendKeys("Patel");*/
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Patel");
        /*WebElement day = driver.findElement(By.name("DateOfBirthDay"));
        day.sendKeys("13");*/
        sendTextToElement(By.name("DateOfBirthDay"),"13");
       /* WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
        month.sendKeys("July");*/
        sendTextToElement(By.name("DateOfBirthMonth"),"July");
        /*WebElement year = driver.findElement(By.name("DateOfBirthYear"));
        year.sendKeys("1983");*/
        sendTextToElement(By.name("DateOfBirthYear"),"1983");
        //WebElement email = driver.findElement(By.id("Email"));
        Random random=new Random();
        int randomInt=random.nextInt(1000);
        //email.sendKeys("abc"+randomInt+"@gmail.com");
        sendTextToElement(By.id("Email"),"abc"+randomInt+"@gmail.com");
        /*WebElement companyName = driver.findElement(By.id("Company"));
        companyName.sendKeys("Jignesh Engineering Ltd");*/
        sendTextToElement(By.id("Company"),"jignesh Engineering Ltd");
        WebElement newsletter = driver.findElement(By.id("Newsletter"));
        //newsletter.click(By.id("Newsletter");
        clickOnElement(By.id("Newsletter"));
        /*WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("abc13783");*/
        sendTextToElement(By.id("Password"),"abc13783");
        /*WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("abc13783");*/
        sendTextToElement(By.id("ConfirmPassword"),"abc13783");
        /*WebElement registerButton = driver.findElement(By.name("register-button"));
        registerButton.click();*/
        clickOnElement(By.name("register-button"));
        // WebElement registrationSuccessful = driver.findElement(By.xpath("//div[@class='result']"));
        String expectedResult = "Your registration completed";
        String actualResult = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(expectedResult, actualResult);

    }

    @After
    public void closeBrowser() {
        quitMethod();
    }
}


