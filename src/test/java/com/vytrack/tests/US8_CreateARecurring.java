package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytractUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US8_CreateARecurring {
    /*
    US8
    As a user, I want to create a recurring(repetitive) calendar event
    ---------------------------------------------------------------------
    AC #1: user should see the number “1” by default.
    AC #2: user should see an error message “This value should not be blank.”
    when the Calendar event repeat field is cleared(delete the number 1).
     */

    public void test() {
        BrowserUtils.sleep(2);

        WebElement activitites = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Activities' and @class='title title-level-1']"));
        Actions hovertotheactivitites = new Actions(Driver.getDriver());
        hovertotheactivitites.moveToElement(activitites).perform();

        BrowserUtils.sleep(2);
        WebElement activities_calendarEvent = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events' and @class='title title-level-2']"));
        BrowserUtils.sleep(1);
        activities_calendarEvent.click();

        BrowserUtils.sleep(2);
        WebElement create_calendarEventBtn = Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));
        create_calendarEventBtn.click();
        BrowserUtils.sleep(2);

        WebElement repeatInput = Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeatInput.click();
        BrowserUtils.sleep(2);
        WebElement repeatValueBox = Driver.getDriver().findElement(By.xpath("//div[@data-name='control-sections']//input[@class='recurrence-subview-control__number']"));

        int defaultValue = Integer.parseInt(repeatValueBox.getAttribute("value"));
        Assert.assertEquals(defaultValue, 1);

        BrowserUtils.sleep(2);
        repeatValueBox.clear();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[.='This value should not be blank.']")).isDisplayed());
    }

    @Test
    public void testWithDriverLogin() {
        VytractUtils.loginAsDriver();
        test();
    }

    @Test
    public void testWithStoreManagerLogin() {
        VytractUtils.loginAsStoreManger();
        test();
    }

    @Test
    public void testWithSalesManagerLogin() {
        VytractUtils.loginAsSalesManager();
        test();
    }

    @AfterMethod
    public void closeDriver() {
        Driver.closeDriver();
    }
}

