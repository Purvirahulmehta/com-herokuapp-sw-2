package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @After
    public void teardown(){
        closeBrowser();
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //finding username element
        WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
        //sending username to username field
        userName.sendKeys("tomsmith");
        //finding password elemrnt
        WebElement password=driver.findElement(By.name("password"));
        //sending password to password field
        password.sendKeys("“SuperSecretPassword!”");
        //finding login button element
        WebElement loginButton=driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        //sending click to login button
        loginButton.click();
        //finding actual message element
        WebElement actualMessage=driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/h4[1]"));
       String  actualResult=actualMessage.getText();
       String expectedMessage="Secure Area";
       // //validate actual and expected message
        Assert.assertEquals("Secure Area","Secure Area");
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //finding username element
        WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
        //sending username to username field
        userName.sendKeys("tomsmith1");
        //finding password element
        WebElement password=driver.findElement(By.name("password"));
        //sending password to password field
        password.sendKeys("SuperSecretPassword");
        //finding login button element
        WebElement loginButton=driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        //sending click to login button
        loginButton.click();
        //finding actualmessage element
        WebElement actualMessage=driver.findElement(By.xpath("//div[@id='flash']"));
        String actualResult=actualMessage.getText();
        String expectedMessage="Your username is invalid!\n" +
                "×";
        //validate actual and expected message
        Assert.assertEquals("unable to navigate", expectedMessage,actualResult);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //finding the username element
        WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
        //sending the username to username field
        userName.sendKeys("tomsmith");
        //finding the password element
        WebElement password=driver.findElement(By.name("password"));
        //sending the password to password field
        password.sendKeys("SuperSecretPassword");
        //finding login button element
        WebElement loginButton=driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        //sending click to log in button
        loginButton.click();
        //finding the actual message element
        WebElement actualMessage=driver.findElement(By.id("flash"));
        String actualResult=actualMessage.getText();
        String expectedMessage="Your password is invalid!\n" +
                "×";
        //Validate actual and expected message
        Assert.assertEquals("Unable to login",expectedMessage,actualResult);


    }

}

