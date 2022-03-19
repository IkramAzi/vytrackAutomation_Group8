package com.vytrack;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VytrackCheckFilters {
    public VytrackCheckFilters() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "prependedInput")
    public WebElement userName;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement submitButton;

    public void login(){
        //Driver.getDriver().
    }

    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement customersTabForDriver;

    @FindBy(xpath = "//span[.='Accounts']")
    public WebElement accountsTabForDriver;

    @FindBy(xpath = "//a[@href='#' and @title='Grid Settings']")
    public WebElement settingGear;

    @FindBy(xpath = "(//tbody[@class='ui-sortable']//td[contains(@id,column)])[3]")
    public WebElement idCheck;

    @FindBy(xpath = "(//tbody[@class='ui-sortable']//td[contains(@id,column)])[6]")
    public WebElement accountNameCheck;

    @FindBy(xpath = "(//tbody[@class='ui-sortable']//td[contains(@id,column)])[9]")
    public WebElement contactNameCheck;

    @FindBy(xpath = "(//tbody[@class='ui-sortable']//td[contains(@id,column)])[12]")
    public WebElement contactEmailCheck;

    @FindBy(xpath = "(//tbody[@class='ui-sortable']//td[contains(@id,column)])[15]")
    public WebElement contactPhoneCheck;

    @FindBy(xpath = "(//tbody[@class='ui-sortable']//td[contains(@id,column)])[18]")
    public WebElement ownerCheck;

    @FindBy(xpath = "(//tbody[@class='ui-sortable']//td[contains(@id,column)])[21]")
    public WebElement createdCheck;

    @FindBy(xpath = "(//tbody[@class='ui-sortable']//td[contains(@id,column)])[24]")
    public WebElement updatedCheck;

    @FindBy(xpath = "//thead[@class='grid-header']")
    public WebElement selectedList;



}
