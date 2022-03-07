package com.vytrack.tests.base;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US9_Incorrect_Integer {
    @Test
    public void invalidInteger() throws InterruptedException {
        //Navigate to VTrack.com
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        //login to page
        Driver.getDriver().findElement(By.xpath("//input[@name='_username']")).sendKeys(ConfigurationReader.getProperty("driver_username"));
        Driver.getDriver().findElement(By.xpath("//input[@name='_password']")).sendKeys(ConfigurationReader.getProperty("driver_password"));
        Driver.getDriver().findElement(By.xpath("//button[@id='_submit']")).click();
        //click Activities
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[3]")).click();
        //click Calender Event
        Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']")).click();
        Thread.sleep(2000);
        //Click create Calendar Events
        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        //Check  Repeat check box
        Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();
        //clear and input -3
        Driver.getDriver().findElement(By.xpath("(//input[@value='1'])[2]")).sendKeys(Keys.BACK_SPACE+"-3"+Keys.ENTER);
        //get the warning message:"The value have not to be less than 1."
        String actualText = Driver.getDriver().findElement(By.xpath("(//span[.='The value have not to be less than 1.'])[3]")).getText();
        String expectedText="The value have not to be less than 1.";
        Thread.sleep(2000);
        //clean repeat check box
        Driver.getDriver().findElement(By.xpath("(//input[@value='1'])[2]")).sendKeys(Keys.BACK_SPACE);
        //clear and input 125
        Driver.getDriver().findElement(By.xpath("(//input[@value='1'])[2]")).sendKeys(Keys.BACK_SPACE+"125"+Keys.ENTER);
        //get text
        String actualText1 = Driver.getDriver().findElement(By.xpath("(//span[.='The value have not to be more than 99.'])[3]")).getText();
        String expectedText1 ="The value have not to be more than 99.";
        Assert.assertEquals(actualText1, expectedText1);
        Assert.assertEquals(actualText,expectedText);
        Driver.closeDriver();
    }

}
