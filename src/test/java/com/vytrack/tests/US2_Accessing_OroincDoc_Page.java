package com.vytrack.tests;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;
public class US2_Accessing_OroincDoc_Page extends TestBase {
    @Test
    public void verify_page(){
        //VytrackUtils.loginAsDriver();
        VytrackUtils.loginAsSalesManager();
       // VytrackUtils.loginAsStoreManger();
        Driver.getDriver().findElement(By.xpath("//i[@title='Get help']")).click();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        String currentTitle="";
        String expectedTitle="Welcome to Oro Documentation";
        for (String each : windowHandles) {
            Driver.getDriver().switchTo().window(each);
            if(!Driver.getDriver().getCurrentUrl().contains("qa")){
               currentTitle= Driver.getDriver().getTitle();
               break;
            }
        }
        Assert.assertEquals(currentTitle,expectedTitle);
    }
}
