package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;
    public WebDriverWait wait;
    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;
    WebElement error;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getError() {
        return driver.findElement(By.id("error"));
    }

    //-----------

    public void inputUsername(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void inputPassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnSubmit() {
        getSubmitButton().click();
    }

    public String pageUrl() {
        return "https://practicetestautomation.com/practice-test-login/";
    }
}
