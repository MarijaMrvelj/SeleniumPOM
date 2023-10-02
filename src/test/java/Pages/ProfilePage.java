package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    public WebDriver driver;
    public WebDriverWait wait;
    WebElement logoutButton;
    WebElement message;

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.linkText("Log out"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.className("has-text-align-center"));
    }

    //---------------

    public String messageText() {
        return getMessage().getText();
    }
    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }
}
