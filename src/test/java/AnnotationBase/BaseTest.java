package AnnotationBase;

import AnnotationPages.HomePage;
import AnnotationPages.LoginPage;
import AnnotationPages.PracticePage;
import AnnotationPages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        homePage = new HomePage();
        practicePage = new PracticePage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
