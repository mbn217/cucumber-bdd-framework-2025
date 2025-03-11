package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {


    private static WebDriver driver;
    private Driver(){

    }

    /**
     * Static method to get the single instance of WebDriver
     * @return
     */
    public static WebDriver getDriver(){
        //Check if there is a driver is open or not ( same thing as checking is driver is null)
        System.out.println("Getting an instance of the driver");
        if (driver == null){
            System.out.println("Creating new Chrome driver");
            driver = new ChromeDriver(); // Instantiating the driver only once
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
