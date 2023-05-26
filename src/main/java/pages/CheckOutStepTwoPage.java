package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutStepTwoPage {
    //    Elements
    @FindBy(className = "summary_subtotal_label")
    WebElement itemTotalPrice;
    @FindBy(id = "finish")
    WebElement finishBtn;
    //Variables
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    public CheckOutStepTwoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }

    //    Methods
    public float getTotalItemPrice() {

        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("summary_subtotal_label")));

        float itemTotalPriceNumber = Float.parseFloat(itemTotalPrice.getText().split("\\$")[1]);
        return itemTotalPriceNumber;
    }

    public CheckoutCompletionPage clickFinishBtn() {
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        finishBtn.click();
        return new CheckoutCompletionPage(driver);
    }

}
