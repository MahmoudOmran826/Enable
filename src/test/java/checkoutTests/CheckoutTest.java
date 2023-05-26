package checkoutTests;

import baseTest.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutStepTwoPage;

public class CheckoutTest extends BaseTests {

    @Test
    public void testCheckoutForOneItem() {
        float expectedPriceOfBackSpace = inventoryPage.clickAddToCartBackSpaceBtn()
                .getBackSpacePrice();
        CheckOutStepTwoPage checkOutStepTwoPage = inventoryPage.clickOnCartLink()
                .clickCheckoutBtn()
                .enterFirstName("Mahmoud")
                .enterLastName("Omran")
                .enterPostalCode("31652")
                .clickContinueBtn();
        float actualPriceOfBackSpace = checkOutStepTwoPage.getTotalItemPrice();
        checkOutStepTwoPage.clickFinishBtn();
        Assert.assertEquals(actualPriceOfBackSpace,
                expectedPriceOfBackSpace,
                String.format("Expected price to be %f, but found %f",
                        expectedPriceOfBackSpace, actualPriceOfBackSpace));

        String actualSuccessMessage = checkoutCompletionPage.getSuccessMessage();
        String expectedSuccessMessage = "Thank you for your order!";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
        System.out.println("Test1");
    }

    @Test
    public void testCheckoutForTwoItems() {
        float expectedPriceOfBackSpace = inventoryPage.clickAddToCartBackSpaceBtn()
                .getBackSpacePrice();
        float expectedPriceOfBikeLight= inventoryPage
                .clickAddToCartBikeLight()
                .getBikeLightPrice();
        CheckOutStepTwoPage checkOutStepTwoPage = inventoryPage.clickOnCartLink()
                .clickCheckoutBtn()
                .enterFirstName("Mahmoud")
                .enterLastName("Omran")
                .enterPostalCode("31652")
                .clickContinueBtn();
        float actualTotalPrice= checkOutStepTwoPage.getTotalItemPrice();
        Assert.assertEquals( actualTotalPrice ,
                (expectedPriceOfBackSpace + expectedPriceOfBikeLight),
                String.format("Expected total price to be %f, but found %f",
                        expectedPriceOfBackSpace+expectedPriceOfBikeLight, actualTotalPrice));
        checkOutStepTwoPage.clickFinishBtn();

        String actualSuccessMessage = checkoutCompletionPage.getSuccessMessage();
        String expectedSuccessMessage = "Thank you for your order!";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
        System.out.println("Test2");
    }

}
