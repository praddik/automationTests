import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setConfig() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Hi-Tech\\IdeaProjects\\TestPetProject\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/?hl=en");
        mainPage = new MainPage(driver);
    }

    @Test
    public void redirectToSignInPage() {
        SignInPage signInPage = mainPage.clickSignIn();
        String headingText = signInPage.getHeadingText();
        Assert.assertEquals("Sign in", headingText);
    }

    @After
    public void closeSys() {
        driver.close();
    }
}
