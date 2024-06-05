package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    /**
     * this method will get text from element
     */

    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    /**
     * this method will send text to element
     */
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
//************************* Alert Methods *****************************************************
    // total 5 method need to creat
    //1. switchToAlert
    //2. AcceptAlert
    //3. DismissMethod
    //4.sendTextToAlert
    //5.GetTextFromAlert


    //*************************** Select Class Methods ***************************************//
    //1. selectByValueFromDropDown(By by, string index)
    public void selectByValueFromDropDown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select class
        Select select = new Select(dropDown);
        // Select by visible Text
        select.selectByValue(value);
    }
    //2. SelectByIndexFromDropDown(By by, int index)
    //3. SelectByVisibleTextFromDropDown(By by, String text)

}