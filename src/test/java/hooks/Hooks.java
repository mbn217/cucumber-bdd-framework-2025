package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.time.Duration;

public class Hooks {



    @Before("@not calculator")
    public void beforeScenario(){
        System.out.println("We are running before each scenario");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

//    @Before(order=1)
//    public void beforeScenario2(){
//        System.out.println("We are running before each scenario");
//        System.out.println("We are running before each scenario order 1");
//        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    }

    @After("@not calculator")
    public void afterScenario(Scenario scenario){
        System.out.println("We are running after each scenario");
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot , "image/png" , scenario.getName());
        }
        Driver.closeDriver();
    }

//    @BeforeStep
//    public void beforeStep(){
//        System.out.println("We are running before each step");
//    }

//    @AfterStep
//    public void afterStep() throws InterruptedException {
//        Thread.sleep(3000);
//    }




}
