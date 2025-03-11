package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.log.Log;
import pages.LoginPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;

public class UserAccess_StepDef {
        WebDriver driver = Driver.getDriver();
        LoginPage loginPage = new LoginPage();


    @Given("User is navigated to Crater login page")
    public void user_is_navigated_to_crater_login_page() {
        //navigate to crater login page
        driver.get("http://crater.primetech-apps.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @When("User enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        //loginPage.emailInput.sendKeys("entityadmin@primetechschool.com");
        //loginPage.passwordInput.sendKeys("primetech@school");
        SeleniumUtils.sendKeysWithActionClass(loginPage.emailInput , "entityadmin@primetechschool.com");
        SeleniumUtils.sendKeysWithActionClass(loginPage.passwordInput, "primetech@school");

    }
    @And("User clicks on crater application Login button")
    public void user_clicks_on_crater_application_login_button() {
        loginPage.loginButton.click();
    }
    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String loginUrl = "http://crater.primetech-apps.com/login";
        String currentNewUrl = driver.getCurrentUrl(); //http://crater.primetech-apps.com/admin/settings/account-settings

        //Verify that login url is not same as current url --> you are logged in successfully
        Assert.assertNotEquals(loginUrl , currentNewUrl);
        driver.close();
    }

}
