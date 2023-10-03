package AnnotationPages;

import AnnotationBase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseTest {

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "has-text-align-center")
    public WebElement message;

    @FindBy(linkText = "Log out")
    public WebElement logOutButton;

    //---------------------------

    public void clickOnLogOutButton() {
        logOutButton.click();
    }
}
