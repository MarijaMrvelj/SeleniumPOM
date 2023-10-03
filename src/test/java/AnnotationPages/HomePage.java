package AnnotationPages;

import AnnotationBase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menu-item-20")
    public WebElement practiceButton;

    //---------------------

    public void clickOnPracticeButton() {
        practiceButton.click();
    }
}
