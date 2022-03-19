package com.vytrack.tests;

import com.vytrack.VytrackCheckFilters;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US12_Filter_8_Options {
    VytrackCheckFilters vytrackCheckFilters=new VytrackCheckFilters();
@BeforeMethod
    public void setUp(){
    Driver.getDriver().get("https://qa2.vytrack.com/user/login");
    vytrackCheckFilters.userName.sendKeys(ConfigurationReader.getProperty("driver_username"));
    vytrackCheckFilters.password.sendKeys(ConfigurationReader.getProperty("driver_password"));
    vytrackCheckFilters.submitButton.click();
    }

    @Test
    public void driverFilterOptions(){
    vytrackCheckFilters.customersTabForDriver.click();
        BrowserUtils.sleep(3);
    vytrackCheckFilters.accountsTabForDriver.click();
    vytrackCheckFilters.settingGear.click();
        BrowserUtils.sleep(3);
       vytrackCheckFilters.idCheck.click();
        BrowserUtils.sleep(3);
        System.out.print(vytrackCheckFilters.selectedList.getText());
        String expectedFiltersChecks="Account Name, Contact Name, Contact Email, Contact Phone, Owner, Business Unit, Created At, Updated At.";

        Assert.assertEquals(vytrackCheckFilters.selectedList.getText(),expectedFiltersChecks);


        Driver.closeDriver();
    }


}
