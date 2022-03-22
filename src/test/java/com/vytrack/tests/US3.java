package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US3 extends TestBase {
    /*
    when users clicks the “Learn how to use this space” link on the homepage,
    users should see: “
    How To Use Pinbar” and
“Use pin icon on the right top corner of the page to create fast access link in the pinbar.”
            */
    @Test
    public void verify_PinBar() {
        //LogIn to a home page as a driver
        VytrackUtils.loginAsDriver();
        BrowserUtils.sleep(2);

        //locate “Learn how to use this space” link on the homepage and click it
        WebElement learnHowToUseThisPage = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space'] "));
        learnHowToUseThisPage.click();

        //Locate How To Use Pinbar heading and confirm the user can see it
        WebElement howToUsePinbar = Driver.getDriver().findElement(By.xpath("//div[@class='clearfix']/h3"));
        String expectedHeading1 = "How To Use Pinbar";
        String actualHeading1 = howToUsePinbar.getText();
        Assert.assertEquals(actualHeading1, expectedHeading1);


       //Locate Use pin icon ... heading and confirm the user can see it
        WebElement usePinIcon = Driver.getDriver().findElement(By.xpath("//div[@class='clearfix']/p"));
        String expectedHeading2 =
                "Use pin icon on the right top corner of page to create fast access link in the pinbar.";
        String actualHeading2 = usePinIcon.getText();
        Assert.assertEquals(actualHeading2, expectedHeading2);

        Driver.closeDriver();
    }
    //AC2: users should see an image on the page.
    //[in automation testing, just verify the image source.]
    //Expected source: /bundles/oronavigation/images/pinbar-location.jpg

    @Test
    public void verifyImage(){
        //LogIn to a home page as a driver
        VytrackUtils.loginAsDriver();
        BrowserUtils.sleep(2);

        //locate “Learn how to use this space” link on the homepage and click it
        WebElement learnHowToUseThisPage = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space'] "));
        learnHowToUseThisPage.click();

        //Locate the image and verify its source
        WebElement image = Driver.getDriver().findElement(By.xpath("//img"));
        String actualSource = image.getAttribute("src").replace("https://qa1.vytrack.com", "");
        String expectedSource = "/bundles/oronavigation/images/pinbar-location.jpg";
        Assert.assertEquals(actualSource, expectedSource);

    }

}
