package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WebTableUtils {
    //Method #1 info:
    //.Name: returnOrderDate()
    //.Return type:String
    //.Arg1: Webdriver driver
    //.Arg2: String costumerName
    //This method should accept a costumerName and return the costumer order date
    //as String.

    public static  String returnOrderData(WebDriver driver,String costumerName){
        String locator ="//td[.='"+costumerName+"']/following-sibling::td[3]";
        WebElement customerDateCell = driver.findElement(By.xpath(locator));

        return customerDateCell.getText();


    }
    //Method #2 info:
    //• Name: orderVerify ()
    //• Return type: void
    //• Arg1: WebDriver driver
    //• Arg2: String costumerName
    //• Arg3: String expectedOrderDate
    //This method should accept above - mentioned arguments and internally assert
    //expectedOrderDate matching actualOrderDate.

    public static void orderVerify(WebDriver driver, String costomerName, String expectedOrderDate){


        String locator ="//td[.='"+costomerName+"']/following-sibling::td[3]";
        WebElement customerDateCell = driver.findElement(By.xpath(locator));

        String actualOrderDate = customerDateCell.getText();

        Assert.assertEquals(actualOrderDate,expectedOrderDate);


    }


}




