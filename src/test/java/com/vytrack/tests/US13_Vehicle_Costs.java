package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US13_Vehicle_Costs {
    @Test
    public void Vehicle_Cost_test(){
        //Users are on the homepage
        VytrackUtils.loginAsDriver();
        //Click the Vehicle Costs under the Fleet

        String fleetTabElementLocator = "//span[normalize-space()='Fleet' and contains(@class,'title title-level-1')]";
        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath(fleetTabElementLocator));
        fleetTabElement.click();

        String vehicleCostModelLocator =  "//span[normalize-space()='Vehicle Costs' and contains(@class,'title title-level-2')]";
        WebElement vehiclesCostsElementLocator = Driver.getDriver().findElement(By.xpath(vehicleCostModelLocator));
        BrowserUtils.sleep(1);
        vehiclesCostsElementLocator.click();
        BrowserUtils.sleep(1);
        //Verify there are 3 columns on the table:
        // Expected Column names: TYPE, TOTAL PRICE, DATE

        List<String> actualColumnsTexts = new ArrayList<>(Arrays.asList("Type","Total Price", "Date"));

        for (String columnsElement : actualColumnsTexts ) {
            String columnsElementText = columnsElement;
            actualColumnsTexts.size();
        }

        List<String> expectedcolumnaWebTable=new ArrayList<>(Arrays.asList(
                "Type",
                "Total Price",
                "Date"
        ));

        Assert.assertTrue(actualColumnsTexts.equals(expectedcolumnaWebTable));

    }


    @Test
    public void Select_All_The_Vehicle_Costs(){
//Users are on the homepage
        VytrackUtils.loginAsSalesManager();
        BrowserUtils.sleep(2);

// click Fleet
        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class,'title title-level-1')]")).click();
        BrowserUtils.sleep(2);

//Click the Vehicle Costs under the Fleet
        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Vehicle Costs' and contains(@class, 'title title-level-2')]")).click();
        BrowserUtils.sleep(2);

//Click the first checkbox
// Verify all the vehicle costs are checked
        Driver.getDriver().findElement(By.cssSelector(".btn.btn-default.btn-small.dropdown-toggle > input[type='checkbox']")).click();

        // Driver.getDriver().findElement(By.xpath("//div[@class='btn-group dropdown']")).click();
        WebElement checkbox = Driver.getDriver().findElement(By.xpath("//div[@class='btn-group dropdown']"));
        checkbox.click();

        Driver.getDriver().findElement(By.cssSelector("body > ul > li:nth-child(1) > a")).click();

        String expectedVehicle =" all the vehicle costs are checked";
        String actualVehicle = Driver.getDriver().getTitle();

        Assert.assertEquals(Driver.getDriver().getTitle(),actualVehicle,expectedVehicle);
    }

}
