import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class PasswordPageTest {
    private WebDriver driver;
    private PasswordPage passwordPage;
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
        passwordPage = new PasswordPage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void validPasswordTest(){
       MainPage mainPage= signInPage.SignInWithValidInfo("Test29052021@gmail.com")
               .inputValidPassword("Qwerty2905");
        Assert.assertNotNull(mainPage);
    }

    @Test
    public void invalidPasswordTest(){
       String error= signInPage.SignInWithValidInfo("Test29052021@gmail.com")
                .inputInvalidPassword("111111111")
               .getErrorInvalid();
       Assert.assertEquals("Wrong password. Try again or click Forgot password to reset it.",error);
    }

    @Test
    public void emptyFieldPasswordTest(){
        String error = signInPage.SignInWithValidInfo("Test29052021@gmail.com")
                .inputFreeFormPassword().getErrorEmpty();
        Assert.assertEquals("Enter a password",error);

    }

    @After
    public void closeSys() {
        driver.close();
    }
}
