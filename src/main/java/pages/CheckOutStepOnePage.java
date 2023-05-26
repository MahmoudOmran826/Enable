package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutStepOnePage {
    //Elements
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(id = "continue")
    WebElement continueBtn;
    //    Variables
    private WebDriver driver;
    private WebDriverWait wait;
    public CheckOutStepOnePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Methods
    public CheckOutStepOnePage enterFirstName(String firstNameString) {
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(firstNameString);
        return new CheckOutStepOnePage(driver);
    }

    public CheckOutStepOnePage enterLastName(String lastNameString) {
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys(lastNameString);
        return new CheckOutStepOnePage(driver);
    }

    public CheckOutStepOnePage enterPostalCode(String postalCodeString) {
        wait.until(ExpectedConditions.visibilityOf(postalCode));
        postalCode.sendKeys(postalCodeString);
        return new CheckOutStepOnePage(driver);
    }

    public CheckOutStepTwoPage clickContinueBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueBtn.click();
        return new CheckOutStepTwoPage(driver);
    }

}
