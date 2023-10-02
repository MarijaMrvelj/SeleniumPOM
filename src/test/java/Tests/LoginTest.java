package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void verifyThatUserCanLogIn() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmit();
        Assert.assertTrue(profilePage.getLogoutButton().isDisplayed());
        Assert.assertTrue(profilePage.getMessage().isDisplayed());
    }

    @Test
    public void verifyThatUserCannotLogInWithoutUsername() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.getError().isDisplayed());
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test
    public void verifyThatUserCannotLogInWithoutPassword() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.pageUrl());
    }

    @Test
    public void verifyThatUserCannotLogInWithoutUsernameAndPassword() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.pageUrl());
    }

    @Test
    public void verifyThatUserCannotLogInWithInvalidUsername() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("studnt");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.pageUrl());
    }

    @Test
    public void verifyThatUserCannotLogInWithInvalidPassword() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("password234");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.pageUrl());
    }

    @Test
    public void verifyThatUserCanLogOut() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmit();
        profilePage.clickOnLogoutButton();

        //Jos asertacije
    }

}
