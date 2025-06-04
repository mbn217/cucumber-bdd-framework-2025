package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.ItemsPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class AddItem_StepDef {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ItemsPage itemsPage = new ItemsPage();

    @Given("User is logged in successfully")
    public void user_is_logged_in_successfully() {
        //navigate to crater, login, enter user/pass/click on login
        driver.get(ConfigurationReader.getPropertyValue("crater-url"));
        SeleniumUtils.sendKeysWithActionClass(loginPage.emailInput , ConfigurationReader.getPropertyValue("username"));
        SeleniumUtils.sendKeysWithActionClass(loginPage.passwordInput, ConfigurationReader.getPropertyValue("password"));
        loginPage.loginButton.click();


    }
    @When("User clicks on the Add Item button")
    public void user_clicks_on_the_add_item_button() {
        dashboardPage.itemsTab.click();
        itemsPage.addItemButton.click();
    }
    @And("User enters the item name")
    public void user_enters_the_item_name() {
        itemsPage.nameInput.sendKeys("Test Case 1 - 2025");
    }
    @And("User enters the item description")
    public void user_enters_the_item_description() {
        itemsPage.descriptionInput.sendKeys("This is just description 2025");
    }
    @And("User enters the item price {string}")
    public void user_enters_the_item_price(String price) {
        itemsPage.priceInput.sendKeys(price);
    }
    @And("User enters the item unit {string}")
    public void user_enters_the_item_unit(String unit) {
        itemsPage.unitSelect.sendKeys(unit);
        //We need to hit ENTER using Keys class
        itemsPage.unitSelect.sendKeys(Keys.ENTER);
    }
    @And("User clicks on the Save Item button")
    public void user_clicks_on_the_save_item_button() {
        itemsPage.saveItemButton.click();
    }
    @Then("Item should be listed in the items table")
    public void item_should_be_listed_in_the_items_table() {
        //Verify the item is listed in the table
        String itemName = "Test Case 1 - 2025";
        Assert.assertTrue(SeleniumUtils.isItemPartOfListOfItems(itemName, itemsPage.itemsList));

    }

}
