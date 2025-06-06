package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class Datatable_Example_StepDef {

    @Given("I have the following list of fruit")
    public void i_have_the_following_list_of_fruit(io.cucumber.datatable.DataTable dataTable) {
     List<String> fruitNameList =   dataTable.asList();//this will take the values of list in feature file and make them as a list

        for (String fruit : fruitNameList){
            System.out.println("******** "+fruit);
        }

    }
    @When("I go to the market")
    public void i_go_to_the_market() {
        System.out.println("I go to the market");

    }
    @Then("I should have {int} fruits in my basket")
    public void i_should_have_fruits_in_my_basket(Integer int1) {
        System.out.println("I should have " +int1 + " fruits in my basket");
    }


}
