package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.linkText("Electronics"));
        //mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //1.2 Mouse Hover on “Cell phones” and "Click"
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals("Incorrect Top Menu", expectedText, actualText);
    }

    private void mouseHoverToElementAndClick(By xpath) {

    }

    private void mouseHoverToElement(By electronics) {

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.linkText("Electronics"));
        // Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.linkText("Cell phones"));
        // Verify the text “Cell phones”
        Assert.assertEquals("Cell phones", getTextFromElement(By.xpath("//h1[text()='Cell phones']")));
        // Click on List View Tab
        clickOnElement(By.xpath("//a[@title='List']"));
        Thread.sleep(1000);
        //Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.linkText("Nokia Lumia 1020"));
        // Verify the text “Nokia Lumia 1020”
        Assert.assertEquals("Nokia Lumia 1020", getTextFromElement(By.xpath("//h1[text()='Nokia Lumia 1020']")));
        // Verify the price “$349.00”
        Assert.assertEquals("$349.00", getTextFromElement(By.id("price-value-20")));
        //Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        // Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        Assert.assertEquals("The product has been added to your shopping cart", getTextFromElement(By.xpath("//p[@class='content']")));
        clickOnElement(By.xpath("//span[@class='close']"));
        // MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        // Verify the message "Shopping cart"
        Assert.assertEquals("Shopping cart", getTextFromElement(By.xpath("//h1[text()='Shopping cart']")));
        // Verify the quantity is 2
        Thread.sleep(2000);
        Assert.assertEquals("2", driver.findElement(By.xpath("//div[@class='product-quantity']//input")).getAttribute("value"));
        // Verify the Total $698.00
        Assert.assertEquals("$698.00", getTextFromElement(By.xpath("//span[@class='product-subtotal']")));
        // click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        // Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals("Welcome, Please Sign In!", getTextFromElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")));
        // Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        // Verify the text “Register”
        Assert.assertEquals("Register", getTextFromElement(By.xpath("//h1[text()='Register']")));
        // Fill the mandatory fields
        String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);            //Create random username
        String emailID = "User" + userName + "@example.com";                        //Create random email Id
        clickOnElement(By.id("gender-male"));                                                                           //Click on gender
        sendTextToElement(By.id("FirstName"), "Mithun");                                                       //Enter first name
        sendTextToElement(By.id("LastName"), "Kaif");                                                     //Enter last name
        sendTextToElement(By.id("Email"), emailID);
        selectByValueFromDropDown(By.name("DateOfBirthDay"), "6");
        selectByValueFromDropDown(By.name("DateOfBirthMonth"), "1");
        selectByValueFromDropDown(By.name("DateOfBirthYear"), "1963");
        sendTextToElement(By.id("Password"), "Jacy@8664");                                                   //Enter password
        sendTextToElement(By.id("ConfirmPassword"), "Jacy@8664");                                            //Confirm password
        // Click on “REGISTER”Button
        clickOnElement(By.id("register-button"));
        // Verify the message “Your registration completed”
        Assert.assertEquals("User not registered successfully.", "Your registration completed", getTextFromElement(By.xpath("//div[text()='Your registration completed']")));
        // Click on “CONTINUE” tab
        clickOnElement(By.xpath("//div[@class='buttons']//a"));
        // Verify the text “Shopping card”
        Assert.assertEquals("Shopping cart", getTextFromElement(By.xpath("//h1[text()='Shopping cart']")));
        // click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);
        // Fill the Mandatory fields
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "133");
        sendTextToElement(By.id("BillingNewAddress_City"), "Edgware");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "34 ");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "395004");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07424314233");
        // Click on “CONTINUE”
        clickOnElement(By.name("save"));
        // Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));
        // Click on “CONTINUE”
        clickOnElement(By.cssSelector(".button-1.shipping-method-next-step-button"));
        // Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //Select “Visa” From Select credit card dropdown
        selectByValueFromDropDown(By.id("CreditCardType"), "visa");
        // Fill all the details
        Thread.sleep(2000);
        sendTextToElement(By.id("CardholderName"), "Jacy dada");
        sendTextToElement(By.id("CardNumber"), "5414250089010640");
        selectByValueFromDropDown(By.id("ExpireYear"), "2029");
        sendTextToElement(By.id("CardCode"), "854");
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        // Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("Credit Card", getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")));
        // Verify “Shipping Method” is “2nd Day Air”
        Assert.assertEquals("2nd Day Air", getTextFromElement(By.xpath("//li[@class='shipping-method']//span[contains(text(),'2nd Day Air')]")));
        // Verify Total is “$698.00”
        Assert.assertEquals("$698.00", getTextFromElement(By.xpath("//span[@class='product-subtotal']")));
        // Click on “CONFIRM”
        clickOnElement(By.xpath("//button[text()='Confirm']"));
        // Verify the Text “Thank You”
        Assert.assertEquals("Thank you", getTextFromElement(By.xpath("//h1[text()='Thank you']")));
        // Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']")));
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        // Verify the text “Welcome to our store!"
        Assert.assertEquals("Welcome to our store", getTextFromElement(By.xpath("//h2[text()='Welcome to our store']")));
        //Click on “Logout” link
        clickOnElement(By.xpath("//a[text()='Log out']"));
        //Verify the URL is “https://demo.nopcommerce.com/
        Assert.assertEquals("https://demo.nopcommerce.com/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {            //Close the browser
        closeBrowser();
    }
}
