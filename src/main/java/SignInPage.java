import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailOrPhoneField = By.xpath("//input[@type='email']");
    private By nextButton = By.xpath("//button[@type='button' and @jsname='LgbsSe']");
    private By heading = By.xpath("//span[text()='Sign in']");
    private By errorInputInfo = By.xpath("//div[@class='o6cuMc']");
    private By errorEmptyForm= By.xpath("//div[@class='o6cuMc']");

    public SignInPage typePhoneOrEmail(String phoneOrEmail){
        driver.findElement(emailOrPhoneField).sendKeys(phoneOrEmail);
        return this;
    }

    public SignInPage SignInWithInvalidInfo(String phoneOrEmail){
        typePhoneOrEmail(phoneOrEmail);
        driver.findElement(nextButton).click();
        return this;
    }

    public SignInPage SignInWithoutInfo(){
        driver.findElement(nextButton).click();
        return this;
    }

    public PasswordPage SignInWithValidInfo(String phoneOrEmail){
        typePhoneOrEmail(phoneOrEmail);
        driver.findElement(nextButton).click();
        return new PasswordPage(driver);
    }

    public String getErrorInputText(){
        return driver.findElement(errorInputInfo).getText();
    }

    public String getErrorEmptyForm(){
        return driver.findElement(errorEmptyForm).getText();
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
}
