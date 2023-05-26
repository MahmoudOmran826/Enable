package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    //    Elements
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBackSpaceBtn;
    //    //div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]
//    (//div[@class= 'inventory_item_price'])[1]
//    //button[@id= 'add-to-cart-sauce-labs-backpack']/preceding-sibling::div[@class= 'inventory_item_price']
    @FindBy(xpath = "(//div[@class= 'inventory_item_price'])[1]")
    WebElement backSpacePrice;
    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLink;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLightBtn;
//    (//div[@class= 'inventory_item_price'])[2]
//    //button[@id= 'add-to-cart-sauce-labs-bike-light']/preceding-sibling::div[@class= 'inventory_item_price']
    @FindBy(xpath = "(//div[@class= 'inventory_item_price'])[2]")
    WebElement bikeLightPrice;
    //    Variables
    private WebDriver driver;
    private WebDriverWait wait;
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //    Methods
    public InventoryPage clickAddToCartBackSpaceBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBackSpaceBtn));
        addToCartBackSpaceBtn.click();
        return new InventoryPage(driver);
    }

    public InventoryPage clickAddToCartBikeLight() {
        wait.until(ExpectedConditions.elementToBeClickable(bikeLightBtn));
        bikeLightBtn.click();
        return new InventoryPage(driver);
    }

    public float getBackSpacePrice() {
        wait.until(ExpectedConditions.visibilityOf(backSpacePrice));
        String stringNumber = backSpacePrice.getText().substring(1);
        float floatNumber = Float.parseFloat(stringNumber);
        return floatNumber;
    }

    public float getBikeLightPrice() {
        wait.until(ExpectedConditions.visibilityOf(bikeLightPrice));
        String stringNumber = bikeLightPrice.getText().substring(1);
        float floatNumber = Float.parseFloat(stringNumber);
        return floatNumber;
    }

    public CartPage clickOnCartLink() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink));
        shoppingCartLink.click();
        return new CartPage(driver);
    }

}

