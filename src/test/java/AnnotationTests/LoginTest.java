package AnnotationTests;

import AnnotationBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void userCanLogIn() {
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();

        Assert.assertTrue(profilePage.logOutButton.isDisplayed());
        Assert.assertTrue(profilePage.message.isDisplayed());
    }
}
