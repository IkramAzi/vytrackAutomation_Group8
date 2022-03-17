package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class US6_ViewEditCarInfoIcons {
    @Test
    public void truck_driver_viewCarInfoIcons() {
        //Log in as driver
        VytrackUtils.loginAsDriver();

        //Navigate to Fleet tab and click the “Vehicle” under the Fleet
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"))).perform();
        Driver.getDriver().findElement(By.linkText("Vehicles")).click();

        //User hovers the three dots at the end of the row.
        BrowserUtils.sleep(2);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@class = 'dropdown-toggle'])[4]"))).pause(2000).perform();


        //Verify user can see  “view, edit, delete” icons
        BrowserUtils.sleep(2);
        WebElement viewIcon = Driver.getDriver().findElement(By.xpath("//a[@href=\"/entity/view/Extend_Entity_Carreservation/item/17\"]"));
        WebElement editIcon = Driver.getDriver().findElement(By.xpath("//a[@href=\"/entity/update/Extend_Entity_Carreservation/item/17\"]"));
        WebElement deleteIcon = Driver.getDriver().findElement(By.xpath("(//a[@title='Delete'])[1]"));
       // WebElement deleteIcon = Driver.getDriver().findElement(By.xpath("/html/body/ul/li/ul//a[@title='Delete']"));

        Assert.assertTrue(viewIcon.isDisplayed());
        Assert.assertTrue(editIcon.isDisplayed());
        Assert.assertTrue(deleteIcon.isDisplayed());

          Driver.closeDriver();
    }

    @Test
    public void verify_store_manager_viewCarInfoIcons() {
        //Log in as sales managers
        VytrackUtils.loginAsStoreManger();

        //Navigate to Fleet tab and click the “Vehicle” under the Fleet
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"))).perform();
        Driver.getDriver().findElement(By.linkText("Vehicles")).click();

        //User hovers the three dots at the end of the row.
        BrowserUtils.sleep(2);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@class = 'dropdown-toggle'])[4]"))).pause(2000).perform();


        //Verify user can see  “view, edit, delete” icons
        BrowserUtils.sleep(2);
        WebElement viewIcon = Driver.getDriver().findElement(By.xpath("//a[@href=\"/entity/view/Extend_Entity_Carreservation/item/17\"]"));
        WebElement editIcon = Driver.getDriver().findElement(By.xpath("//a[@href=\"/entity/update/Extend_Entity_Carreservation/item/17\"]"));
        WebElement deleteIcon = Driver.getDriver().findElement(By.xpath("(//a[@title='Delete'])[3]"));

        Assert.assertTrue(viewIcon.isDisplayed());
        Assert.assertTrue(editIcon.isDisplayed());
        Assert.assertTrue(deleteIcon.isDisplayed());

        Driver.closeDriver();
    }
    @Test
    public void verify_sales_manager_viewCarInfoIcons() {
        //Log in as sales managers
        VytrackUtils.loginAsSalesManager();

        //Navigate to Fleet tab and click the “Vehicle” under the Fleet
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"))).perform();
        Driver.getDriver().findElement(By.linkText("Vehicles")).click();

        //User hovers the three dots at the end of the row.
        BrowserUtils.sleep(2);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@class = 'dropdown-toggle'])[4]"))).pause(2000).perform();


        //Verify user can see  “view, edit, delete” icons
        BrowserUtils.sleep(2);
        WebElement viewIcon = Driver.getDriver().findElement(By.xpath("//a[@href=\"/entity/view/Extend_Entity_Carreservation/item/17\"]"));
        WebElement editIcon = Driver.getDriver().findElement(By.xpath("//a[@href=\"/entity/update/Extend_Entity_Carreservation/item/17\"]"));
        WebElement deleteIcon = Driver.getDriver().findElement(By.xpath("(//a[@title='Delete'])[3]"));

        Assert.assertTrue(viewIcon.isDisplayed());
        Assert.assertTrue(editIcon.isDisplayed());
        Assert.assertTrue(deleteIcon.isDisplayed());

        Driver.closeDriver();
    }
}



