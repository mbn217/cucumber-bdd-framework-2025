package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {


    private static WebDriver driver;
    private Driver(){

    }

    /**
     * Static method to get the single instance of WebDriver
     * @return
     */
    public static WebDriver getDriver(){
        //Read the browser type you want to launch from properties file
        String browserType  = ConfigurationReader.getPropertyValue("browserType");


        //Check if there is a driver is open or not ( same thing as checking is driver is null)
        System.out.println("Getting an instance of the driver");
        if (driver == null){
            //Create the driver based on the browser type
            switch (browserType.toLowerCase()){
                case "chrome"://if browser type is chrome
                    driver = new ChromeDriver(); //Instantiate only once
                    break;
                case "firefox"://if browser type is ff
                    driver = new FirefoxDriver();
                    break;
                case "edge"://if browser type is edge
                    driver = new EdgeDriver();
                    break;
                case "safari"://if browser type is safari
                    driver = new SafariDriver();
                    break;
                case "chrome-headless":
                    System.out.println("Running in headless mode in chrome");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox-headless":
                    System.out.println("Running in headless mode in Firefox");
                    FirefoxOptions ffOptions = new FirefoxOptions();
                    ffOptions.addArguments("--headless");
                    driver = new FirefoxDriver(ffOptions);
                    break;

                default:
                    driver = new ChromeDriver();
                    break;
            }

        }
        return driver;// return the driver if its not null or the one that is just created
    }


    /**
     * This method will quit the driver and set it to null
     */
    public static void closeDriver(){
        System.out.println("Closing the driver");
        if(driver!=null){ // check if the browser is open
            driver.quit();
            driver = null; // making sure that driver is cleaned from the memory
        }
    }



}
