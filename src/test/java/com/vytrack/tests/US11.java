package com.vytrack.tests;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US11 {


    @Test
    public void verify_sales_manager_access_to_vehicle_odometer(){
        //Log in as sales managers
        VytrackUtils.loginAsSalesManager();

        //Click the “Vehicle Odometers” under the Fleet
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"))).pause(1000).perform();
        Driver.getDriver().findElement(By.linkText("Vehicle Odometer")).click();

        //Verify the managers see “You do not have permission to perform this action.”
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div[2]/div")).isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void verify_store_manager_access_to_vehicle_odometer(){
        //Log in as store managers
        VytrackUtils.loginAsStoreManger();

        //Click the “Vehicle Odometers” under the Fleet
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"))).pause(1000).perform();
        Driver.getDriver().findElement(By.linkText("Vehicle Odometer")).click();

        //Verify the managers see “You do not have permission to perform this action.”
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div[2]/div")).isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void verify_driver_defaultPageNumber_is_one(){
        //Log in as drivers
        VytrackUtils.loginAsDriver();

        //Click the “Vehicle Odometers” under the Fleet
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"))).pause(2).perform();
        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Vehicle Odometer' and contains(@class, 'title title-level-2')]")).click();

        //Verify the default page number is 1
        WebElement pageNumber = Driver.getDriver().findElement(By.xpath("//input[@class='input-widget']"));
        Actions action1=new Actions(Driver.getDriver());
        action1.moveToElement(pageNumber).pause(2).perform();
        Assert.assertTrue(pageNumber.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void verify_driver_defaultViewPerPage_is_twentyFive(){
        //Log in as drivers
        VytrackUtils.loginAsDriver();

        //Click the “Vehicle Odometers” under the Fleet
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"))).pause(2).perform();
        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Vehicle Odometer' and contains(@class, 'title title-level-2')]")).click();

        //Verify the default view per page is 25
        WebElement defaultPageNumber = Driver.getDriver().findElement(By.xpath("//div[@id='container']/div[@class='disable-scroll']/div[2]/div[@class='toolbar']/div/div[3]/div[2]//button"));
        Assert.assertTrue(defaultPageNumber.isDisplayed());

        Driver.closeDriver();
    }



}
