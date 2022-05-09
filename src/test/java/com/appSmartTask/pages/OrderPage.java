package com.appSmartTask.pages;

import com.appSmartTask.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage {


    @FindBy(xpath = "//h1[@class='BranchSelector_title__2TXoP']")
    public WebElement locationPageTitle;


    @FindBy(xpath = "//div[@class='button-standard']")
    public WebElement closeWarningButton;

    @FindBy(xpath = "//span[@class='LanguageSwitcher__title']")
    public WebElement LanguageSwitcher;

    @FindBy(xpath = "//li[contains(text(),'English')]")
    public WebElement LanguageEnglish;

    @FindBy(xpath = "//div[contains(text(),'Gratis-Zutaten')]")
    public WebElement freeIngredient;

    @FindBy(xpath = "//div[contains(text(),'Extrazutaten 1')]")
    public WebElement extraIngredient1;

    @FindBy(xpath = "//div[contains(text(),'Extrazutaten 2')]")
    public WebElement extraIngredient2;

    @FindBy(xpath = "//div[contains(text(),'Extrazutaten 3')]")
    public WebElement extraIngredient3;

    @FindBy(xpath = "//div[contains(text(),'Extrazutaten 4')]")
    public WebElement extraIngredient4;

    @FindBy(xpath = "//div[contains(text(),'Käserand')]")
    public WebElement cheeseCrust;

    @FindBy(xpath = "//div[contains(text(),'Dip nach Wahl')]")
    public WebElement dipSouces;


    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    public WebElement confirm;

    @FindBy(xpath = "//div[contains(text(),'Shopping cart')]")
    public WebElement shoppingCart;

    @FindBy(xpath = "//button[contains(text(),'Order now')]")
    public WebElement orderNow;

    @FindBy(xpath = "//button[contains(text(),'Preorder')]")
    public WebElement preorder;



// fill out address form
    @FindBy(xpath = "//input[@placeholder='First name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement company;

    @FindBy(xpath = "//input[@placeholder='Street']")
    public WebElement street;

    @FindBy(xpath = "//input[@placeholder='Number']")
    public WebElement number;

    @FindBy(xpath = "//input[@placeholder='Postal Code']")
    public WebElement postalCode;

    @FindBy(xpath = "//input[@placeholder='City']")
    public WebElement city;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@placeholder='Phone']")
    public WebElement phone;

    @FindBy(xpath = "//textarea[@data-testid='comment-input-basket']")
    public WebElement additionalDirections;

    @FindBy(xpath = "//button[@data-testid='basket-order-btn']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//p[@class='error']")
    public WebElement errorMessage;


    //Place my order

    @FindBy(xpath = "//button[contains(text(),'Place my order for')]")
    public WebElement placeMyOrderButton;

    public WebElement selectPizzaType(String pizzaType) {
        String pizza = "//h5[contains(text(),'" + pizzaType + "')]";
        WebElement selectedPizzaType = Driver.get().findElement(By.xpath(pizza));

        return selectedPizzaType;
    }

    public WebElement checkPizzaIngredienTitle(String pizzaType) {
        String pizza = "//h5[contains(text(),'" + pizzaType + "')]";
        WebElement selectedIngrediendsTitle = Driver.get().findElement(By.xpath(pizza));

        return selectedIngrediendsTitle;
    }


    public WebElement extraIngredient(String ingredient) {
        String extraIngredi = "//div[contains(@class,'ingredients') and text()='"+ingredient+"']";
        WebElement selectedIngredient = Driver.get().findElement(By.xpath(extraIngredi));

        return selectedIngredient;
    }

    public WebElement kaserandIngredient(String ingredient) {
        String extraIngredi = "//div[contains(text(),'"+ingredient+"')]";
        WebElement selectedIngredient = Driver.get().findElement(By.xpath(extraIngredi));

        return selectedIngredient;
    }

    public WebElement pizzaSize(String size) {
        String pizzaSize = "//div[contains(text(),'" + size + "')]";
        WebElement selectedSize = Driver.get().findElement(By.xpath(pizzaSize));

        return selectedSize;


    }


    public WebElement selectPaymentMethod (String payment) {
        String paymentMethod = "//span[contains(text(),'" + payment + "')]";
        WebElement selectedPaymentMethod= Driver.get().findElement(By.xpath(paymentMethod));

        return selectedPaymentMethod;


    }





    //span[contains(text(),'Cash')]


}