import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SignInPageTest {
    private WebDriver driver;
    private SignInPage signInPage;

    @Before
    public void setConfig() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Hi-Tech\\IdeaProjects\\TestPetProject\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin/" +
                "v2/identifier?hl=en&passive=true&continue=https%3A%2F%2Fwww.google.com.ua%2F%3Fhl%3Den&ec=GAZAmgQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        signInPage = new SignInPage(driver);
    }

    @Test
    public void EmptyFieldTest() {
        signInPage.SignInWithoutInfo();
        String error = signInPage.getErrorEmptyForm();
        Assert.assertEquals("Enter an email or phone number", error);

    }

    @Test
    public void InvalidInfoTest() {
        String error = signInPage.SignInWithInvalidInfo("test@gmail.com").getErrorInputText();
        Assert.assertEquals("Couldn’t find your Google Account", error);
    }

    @Test
    public void ValidInfoTest() {
        Assert.assertNotNull(signInPage.SignInWithValidInfo("Test29052021@gmail.com"));
    }

    @After
    public void closeSys() {
        driver.close();
    }
}
