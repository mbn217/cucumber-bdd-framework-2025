package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtils {

    /**
     * This method will select from a Drop down using selectByValue from Selenium
     * @param elementToBeSelected the element for the Select Tag
     * @param valueFromDropdown the option value that we want to select
     */
    public static void selectFromDropDownByValue(WebElement elementToBeSelected , String valueFromDropdown){
        Select select = new Select(elementToBeSelected);
        select.selectByValue(valueFromDropdown);
    }

    /**
     * This method will drag and drop an element from a source to a target element using Action class
     * @param driver the driver object that was instantiated
     * @param sourceElement the source element that we want to drag
     * @param targetElement the target element that we want to drag the source element to
     */
    public static void dragAndDrop(WebDriver driver , WebElement sourceElement, WebElement targetElement ){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
    }

    /**
     * This method will send keys to an element using the Actions class
     * @param element the element that we want to send keys to
     * @param input the value that we want to send to the element
     */
    public static void sendKeysWithActionClass(WebElement element, String input){
        //Create an instance of the Action class
        Actions actions = new Actions(Driver.getDriver());
        //send the keys to the element
        actions.sendKeys(element , input).build().perform();
    }

}
