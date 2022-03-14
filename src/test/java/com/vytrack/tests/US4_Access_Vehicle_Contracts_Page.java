package com.vytrack.tests;


import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US4_Access_Vehicle_Contracts_Page{

    /*
  Description: manager access the Vehicle models
   Environment: https://qa2.vytrack.com/user/login
     */

        @Test
        public void SalesManager_Vehicle_Contract(){

            //1-Login Home page as Sales manager
            VytrackUtils.loginAsSalesManager();
            BrowserUtils.sleep(2);

            // 2-Click the Vehicle Model under the Fleet
            Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class,'title title-level-1')]")).click();
            BrowserUtils.sleep(2);

            //WebElement fleetSlaseManager = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
            // fleetSlaseManager.click();

            //click Vehicle contract
            Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Vehicle Contracts' and contains(@class, 'title title-level-2')]")).click();
            BrowserUtils.sleep(2);

            //3-Verify managers see 10 columns in the web-table

            //Expected URL: https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract
            //Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System

            String Expectedtitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
            String ActualTitle = Driver.getDriver().getTitle();

            Assert.assertEquals(Driver.getDriver().getTitle(), ActualTitle, Expectedtitle);
            BrowserUtils.sleep(2);
        }

        @Test
        public void StoreManager_Click_Vehicle_Contract() {

            //1-Login Home page as StoreManager
            VytrackUtils.loginAsStoreManger();
            BrowserUtils.sleep(2);

            // 2-Click the Vehicle Model under the Fleet
            Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class,'title title-level-1')]")).click();
            BrowserUtils.sleep(2);

            //WebElement fleetStoreManager = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
            // fleetSlaseManager.click();

            //click Vehicle contract
            Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Vehicle Contracts' and contains(@class, 'title title-level-2')]")).click();
            BrowserUtils.sleep(2);


            //3-Verify managers see 10 columns in the web-table

            //Expected URL: https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract
            //Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System

            String Expectedtitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
            String ActualTitle = Driver.getDriver().getTitle();

            Assert.assertEquals(Driver.getDriver().getTitle(), ActualTitle, Expectedtitle);
            BrowserUtils.sleep(2);
        }



        @Test
        public void Driver_Cannot_Access_V_Contract_Page() {

            //1-Login as a driver
            VytrackUtils.loginAsDriver();
            BrowserUtils.sleep(2);

            // 2-Click the Vehicle contracts under the Fleet
            Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class,'title title-level-1')]")).click();
            BrowserUtils.sleep(2);


            //click Vehicle contract
            Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Vehicle Contracts' and contains(@class, 'title title-level-2')]")).click();
            BrowserUtils.sleep(2);

            //3-Verify users see an error message: “You do not have permission to perform this action.”

            String Expectedtitle = "You do not have permission to perform this action";
            String ActualTitle = Driver.getDriver().getTitle();

            Assert.assertEquals(Driver.getDriver().getTitle(), ActualTitle, Expectedtitle);
             Driver.closeDriver();
        }
    }




