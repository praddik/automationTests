import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage {
    private WebDriver driver;

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private By passwordField = By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input");
    private By nextButton = By.cssSelector("#passwordNext > div > button");
    private By errorEmptyFormPassword = By.xpath("//div[@jsname='B34EJ']");
    private  By errorInvalidPassword = By.xpath("//span[text()='Wrong password. Try again or click Forgot password to reset it.']") ;

    public PasswordPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public MainPage inputValidPassword(String truePassword){
        typePassword(truePassword);
        driver.findElement(nextButton).click();
        return new MainPage(driver);
    }

    public PasswordPage inputInvalidPassword(String truePassword){
        typePassword(truePassword);
        driver.findElement(nextButton).click();
        return this;
    }

    public PasswordPage inputFreeFormPassword(){
        driver.findElement(nextButton).click();
        return this;
    }

    public String getErrorEmpty(){
        return driver.findElement(errorEmptyFormPassword).getText();
    }

    public String getErrorInvalid(){
        return driver.findElement(errorInvalidPassword).getText();
    }
}
