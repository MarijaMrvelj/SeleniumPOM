package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage {

    public WebDriver driver;
    public WebDriverWait wait;
    WebElement testLoginPageButton;

    public PracticePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getTestLoginPageButton() {
        return driver.findElement(By.linkText("Test Login Page"));
    }

    //-------------

    public void clickOnTestLoginPageButton() {
        getTestLoginPageButton().click();
    }
}
