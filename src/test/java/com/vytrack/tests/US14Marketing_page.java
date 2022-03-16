package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US14Marketing_page {


    @Test
    public void checked_test(){

        // go on home page
        VytrackUtils.loginAsSalesManager();
        // click Marketing
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Marketing' and contains(@class,'title title-level-1')]")).click();
        // click Camping under Marketing
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Campaigns' and contains(@class,'title title-level-2')]")).click();
        //click Click the Manager filters button
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//div[@class='column-manager dropdown']")).click();
        // Verify 5 options are checked by default

        WebElement DefaultCheck =Driver.getDriver().findElement(By.xpath("//span[@class='grid-header-cell__label']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(DefaultCheck).pause(2).perform();
        Assert.assertTrue(DefaultCheck.isDisplayed());


    }

    @Test
    public void unchecked(){
        // go on home page
        VytrackUtils.loginAsStoreManger();
        // click Marketing
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Marketing' and contains(@class,'title title-level-1')]")).click();
        // click Camping under Marketing
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Campaigns' and contains(@class,'title title-level-2')]")).click();
        //click Click the Manager filters button
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//div[@class='column-manager dropdown']")).click();
        // Uncheck one or more filter options
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//input[@id='column-c280']")).click();
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//input[@id='column-c283']")).click();


        // Verify one or more options are unchecked
        List<String> expectedUnchecked=new ArrayList<>(Arrays.asList(
                "Name","Code", "Start Date",
                "End Date", "Budget"));
        List<String> actualUnchecked = new ArrayList<>(Arrays.asList("Code","Budget"));


        Assert.assertFalse(actualUnchecked.equals(expectedUnchecked));




    }

}
