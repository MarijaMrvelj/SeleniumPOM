package AnnotationPages;

import AnnotationBase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePage extends BaseTest {

    public PracticePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Test Login Page")
    public WebElement testLoginPageButton;

    //------------------------

    public void clickOnTestLoginPageButton() {
        testLoginPageButton.click();
    }
}
