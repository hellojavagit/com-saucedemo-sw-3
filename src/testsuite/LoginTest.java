package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        //sending username fields
        sendTextToElement(By.id("user-name"), "standard_user");
        //sending password fields
        sendTextToElement(By.name("password"), "secret_sauce");
        //clicking the login button
        clickOnElement(By.name("login-button"));
        // verifyTextMessages("Product texts not displayed","PRODUCTS",);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //sending the email fields  by using locator id
        sendTextToElement(By.id("user-name"), "standard_user");

        // sending the password fields by using name as locator
        sendTextToElement(By.name("password"), "secret_sauce");

        //clicking the login button
        clickOnElement(By.name("login-button"));

        //verifying the number of elements on the page
        List<WebElement> productNo = driver.findElements(By.className("inventory_item"));
        int totalProducts = productNo.size();
        int expectedNumber = 6;
        Assert.assertEquals("Products numbers not matching", expectedNumber, totalProducts);
    }

    //closing the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
