package com.appSmartTask.pages;

import com.appSmartTask.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage (){
        PageFactory.initElements(Driver.get(),this);
    }



    @FindBy (xpath = "//input[@id]")
    public WebElement addressBox;

    @FindBy (xpath = "(//button)[1]")
    public WebElement deliveryHereButton;


    @FindBy (xpath = "(//button)[2]")
    public WebElement bremenPickUpLocation;


    @FindBy (xpath = "(//button)[3]")
    public WebElement delmenhorstPickUpLocation;


}
