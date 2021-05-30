import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By signInButton = By.xpath("//a[text()='Sign in']");

    public SignInPage clickSignIn(){
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }
}
