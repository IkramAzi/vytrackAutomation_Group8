package com.vytrack.tests;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US5_VehiclesModelPage {

    @Test(priority = 1)
    public void driver_User_Access(){
        //Navigate to VTrack.com
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        //login to page
        Driver.getDriver().findElement(By.xpath("//input[@name='_username']")).sendKeys(ConfigurationReader.getProperty("driver_username"));
        Driver.getDriver().findElement(By.xpath("//input[@name='_password']")).sendKeys(ConfigurationReader.getProperty("driver_password"));
        Driver.getDriver().findElement(By.xpath("//button[@id='_submit']")).click();
        //click Fleet
        Driver.getDriver().findElement(By.xpath("//a[@href='#'] //span[@class='title title-level-1']")).click();
        //click Vehicle
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[9]/a/span")).click();

        // Driver login access error message
        String actualErrorMessage = Driver.getDriver().findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div[2]/div")).getText();
        String expectedErrorMessage = "You do not have permission to perform this action.";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        //Driver.closeDriver();

    }

    @Test(priority = 2)
    public void sales_manager_Access(){
        //Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        //Navigate to VTrack.com
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        //login to page
        Driver.getDriver().findElement(By.xpath("//input[@name='_username']")).sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        Driver.getDriver().findElement(By.xpath("//input[@name='_password']")).sendKeys(ConfigurationReader.getProperty("sales_manager_password"));
        Driver.getDriver().findElement(By.xpath("//button[@id='_submit']")).click();
        //click Fleet
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();
        //click Vehicle Model
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[9]/a/span")).click();

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//span[@class='grid-header-cell__label']"));

        //All Vehicle Model List
        ArrayList<String> expectedAllVehicleModelList = new ArrayList<>(Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED", "CVVI", "CO2 FEE (/MONTH)", "COST (DEPRECIATED)", "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS",
                "FUEL TYPE", "VENDORS"));

        ArrayList<String> actualAllVehicleModelList = new ArrayList<>();
        for (WebElement element : elements) {
            actualAllVehicleModelList.add(element.getText());
        }
        boolean verification = actualAllVehicleModelList.equals(expectedAllVehicleModelList);
        Assert.assertTrue(verification);

        Driver.closeDriver();
    }

    @Test(priority = 3)
    public void store_manager_Access(){
        //Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        //Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        //Navigate to VTrack.com
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        //login to page
        Driver.getDriver().findElement(By.xpath("//input[@name='_username']")).sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        Driver.getDriver().findElement(By.xpath("//input[@name='_password']")).sendKeys(ConfigurationReader.getProperty("store_manager_password"));
        Driver.getDriver().findElement(By.xpath("//button[@id='_submit']")).click();
        //click Fleet
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();
        //click Vehicle Model
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[9]/a/span")).click();

        List<WebElement> elements2 = Driver.getDriver().findElements(By.xpath("//span[@class='grid-header-cell__label']"));

        //All Vehicle Model List
        ArrayList<String> expectedAllVehicleModelList2 = new ArrayList<>(Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED", "CVVI", "CO2 FEE (/MONTH)", "COST (DEPRECIATED)", "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS",
                "FUEL TYPE", "VENDORS"));

        ArrayList<String> actualAllVehicleModelList2 = new ArrayList<>();
        for (WebElement element : elements2) {
            actualAllVehicleModelList2.add(element.getText());
        }

        boolean verification2 = actualAllVehicleModelList2.equals(expectedAllVehicleModelList2);
        Assert.assertTrue(verification2);

        Driver.closeDriver();
    }


}
