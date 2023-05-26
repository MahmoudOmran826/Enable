package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    //    Elements
    @FindBy(id = "user-name")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginBtn;
    @FindBy(id = "login_credentials")
    WebElement loginUserName;
    @FindBy(className = "login_password")
    WebElement loginPassword;
    //    Variables
    private WebDriver driver;
    private WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //    Methods
    public HomePage enterUserName(String userNameString) {
        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.clear();
        userName.sendKeys(userNameString);
        return new HomePage(driver);
    }

    public HomePage enterPassword(String passwordString) {
        wait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(passwordString);
        return new HomePage(driver);
    }

    public InventoryPage clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        return new InventoryPage(driver);
    }

    public String getUserNameFromCredentials() {
        wait.until(ExpectedConditions.visibilityOf(loginUserName));
        String credentials = loginUserName.getText();
        String[] lines = credentials.split("\\n");
        return lines[1];
    }

    public String getPassword() {
        String credentials = loginPassword.getText();
        String[] lines = credentials.split(":");
        return lines[1];
    }

}
