package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US7_SelectVehicle {

    @Test
    public void verify_allCheckboxesUnchecked_StoreManager() {
        //Log in as sales managers
        //VytrackUtils.loginAsStoreManger();
        VytrackUtils.loginAsSalesManager();

        //Navigate to Fleet tab and click the “Vehicle” under the Fleet
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"))).perform();
        Driver.getDriver().findElement(By.linkText("Vehicles")).click();

        //Verify all the checkboxes are unchecked

        List<WebElement> allCheckboxes = Driver.getDriver().findElements(By.xpath("//input[@data-role = 'select-row-cell']"));


        for (WebElement eachCheckbox : allCheckboxes) {


            Assert.assertTrue(!eachCheckbox.isSelected());

        }


        Driver.closeDriver();
    }

    @Test
    public void verify_allCheckboxesChecked_StoreManager() {
        //Log in as sales managers
        //VytrackUtils.loginAsStoreManger();
        VytrackUtils.loginAsSalesManager();

        //Navigate to Fleet tab and click the “Vehicle” under the Fleet
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"))).perform();
        Driver.getDriver().findElement(By.linkText("Vehicles")).click();

        //Click the 1st checkbox in the web-table
        WebElement mainCheckBox = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[1]"));
        mainCheckBox.click();

        //Verify all the checkboxes also checked

        List<WebElement> allCheckboxes = Driver.getDriver().findElements(By.xpath("//input[@data-role = 'select-row-cell']"));

        for (WebElement eachCheckbox : allCheckboxes) {

            Assert.assertTrue(eachCheckbox.isSelected());

        }

        Driver.closeDriver();


    }

    @Test
    public void verify_anyCheckboxesChecked_StoreManager() {
        //Log in as sales managers
        //VytrackUtils.loginAsStoreManger();
        VytrackUtils.loginAsSalesManager();

        //Navigate to Fleet tab and click the “Vehicle” under the Fleet
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"))).perform();
        Driver.getDriver().findElement(By.linkText("Vehicles")).click();

        //Click one of the checkboxes in the web-table
        WebElement checkBox3 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[4]"));
        checkBox3.click();


        //Verify  the selected checkbox is checked

        Assert.assertTrue(checkBox3.isSelected());



        Driver.closeDriver();


    }

}




/*
        WebElement checkBoxMain = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[1]"));
        WebElement checkBox1 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[2]"));
        WebElement checkBox2 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[3]"));
        WebElement checkBox3 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[4]"));
        WebElement checkBox4 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[5]"));
        WebElement checkBox5 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[6]"));
        WebElement checkBox6 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[7]"));
        WebElement checkBox7 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[8]"));
        WebElement checkBox8 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[9]"));
        WebElement checkBox9 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[10]"));
        WebElement checkBox10 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[11]"));
        WebElement checkBox11 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[12]"));
        WebElement checkBox12 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[13]"));
        WebElement checkBox13 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[14]"));
        WebElement checkBox14 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[15]"));
        WebElement checkBox15 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[16]"));
        WebElement checkBox16 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[17]"));
        WebElement checkBox17 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[18]"));
        WebElement checkBox18 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[19]"));
        WebElement checkBox19 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[20]"));
        WebElement checkBox20 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[21]"));
        WebElement checkBox21 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[22]"));
        WebElement checkBox22 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[23]"));
        WebElement checkBox23 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[24]"));
        WebElement checkBox24 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[25]"));
        WebElement checkBox25 = Driver.getDriver().findElement(By.xpath("(//table//input[@type='checkbox'])[26]"));
*/