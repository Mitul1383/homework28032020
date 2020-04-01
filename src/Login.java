import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class Login extends Utility {
    String baseUrl = "https://demo.nopcommerce.com//";
    @Before
    public void openBrowser() {

        chromeBrowserDriver();
        driver.manage().window().maximize();
        implicitlyWait(10);
        getBaseUrl(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPage() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(By.linkText("Log in"));
        // Finding the Welcome text element
        WebElement welcomeText = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome, Please Sign In!')]"));
        // This is expected text from Requirement
        String expectedText = "Welcome, Please Sign In!";
        // Get text from Welcome text element from web site
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(), 'Welcome, Please Sign In!')]"));
        // verifying actualText and expectedText
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyErrorMessageWhenWrongUserNameIsEntered() throws InterruptedException {
        // Finding the login link element and click on login link element
        clickOnElement(By.linkText("Log in"));
        // Thread.sleep method used for hold execution
        Thread.sleep(1000);
        // Finding the emailField element and sending text
        // clickOnElement(By.id("Email"));
        sendTextToElement(By.id("Email"),"abc@gmail.com");
        // Finding the passwordField element and entering password
        sendTextToElement(By.name("Password"),"Abc123");
        //Finding the login button element and click on it
        clickOnElement(By.xpath("//input[@value='Log in']"));
        // This is expected message from Requirement
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";
        // This is actual error message from web site
        String actualErrorMessage = getTextFromElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        // Asserting expectedMessage and actualMessage
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
    @After
    public void closeBrowser() throws InterruptedException {
        quitMethod();
    }
}



