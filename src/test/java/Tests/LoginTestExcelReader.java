package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestExcelReader extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void verifyThatUserCanLogIn() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmit();

        Assert.assertTrue(profilePage.getLogoutButton().isDisplayed());
        Assert.assertTrue(profilePage.getMessage().isDisplayed());
    }

    @Test
    public void verifyThatUserCannotLogInWithoutUsername() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        String invalidUsername = excelReader.getStringData("Login", 3, 2);
        loginPage.inputUsername(invalidUsername);
        //loginPage.inputUsername("");
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmit();

        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.pageUrl());
        boolean logOut = false;
        try {
            profilePage.getLogoutButton().isDisplayed();
        } catch (Exception e) {
            Assert.assertFalse(logOut);
        }
    }

    @Test
    public void verifyThatUserCannotLogInWithoutPassword() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        String validUsername = excelReader.getStringData("Login", 1, 0);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword("");
        loginPage.clickOnSubmit();

        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.pageUrl());
        boolean logOut = false;
        try {
            profilePage.getLogoutButton().isDisplayed();
        } catch (Exception e) {
            Assert.assertFalse(logOut);
        }
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
        boolean logOut = false;
        try {
            profilePage.getLogoutButton().isDisplayed();
        } catch (Exception e) {
            Assert.assertFalse(logOut);
        }
    }

    @Test
    public void verifyThatUserCannotLogInWithInvalidUsername() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();

        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            loginPage.inputUsername(invalidUsername);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            loginPage.inputPassword(validPassword);
            loginPage.clickOnSubmit();

            Assert.assertTrue(loginPage.getError().isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), loginPage.pageUrl());
            boolean logOut = false;
            try {
                profilePage.getLogoutButton().isDisplayed();
            } catch (Exception e) {
                Assert.assertFalse(logOut);
            }
        }
    }

    @Test
    public void verifyThatUserCannotLogInWithInvalidPassword() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();

        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", 1, 0);
            loginPage.inputUsername(validUsername);
            String invalidPassword = excelReader.getStringData("Login", i, 3);
            loginPage.inputPassword(invalidPassword);
            loginPage.clickOnSubmit();

            Assert.assertTrue(loginPage.getError().isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), loginPage.pageUrl());
            boolean logOut = false;
            try {
                profilePage.getLogoutButton().isDisplayed();
            } catch (Exception e) {
                Assert.assertFalse(logOut);
            }
        }
    }

    @Test
    public void verifyThatUserCanLogOut() {
        homePage.clikOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();

        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmit();
        profilePage.clickOnLogoutButton();

        Assert.assertEquals(driver.getCurrentUrl(), loginPage.pageUrl());
        Assert.assertEquals(loginPage.getUsernameField().getText(), "");
        Assert.assertEquals(loginPage.getPasswordField().getText(), "");
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
    }

}
