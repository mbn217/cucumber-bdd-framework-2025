package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DbUtils;

public class AddItem_And_Verify_DB_StepDef {


    @And("the item is added into the DB")
    public void the_item_is_added_into_the_db() {
        String query = "SELECT * FROM CraterDBS.items i order by i.id desc;";
        String nameValueUiInput = "Test Case 1 - 2025";
        String nameValueInDB = DbUtils.selectRecord(query, "name");
        System.out.println("The new item name is : " + nameValueInDB);

        Assert.assertEquals(nameValueUiInput , nameValueInDB);

    }


}
