package com.appSmartTask.stepDef;

import com.appSmartTask.pages.OrderPage;
import com.appSmartTask.utilities.ConfigurationReader;
import com.appSmartTask.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class OrderSteps {

    boolean isResturantOpen= true;

    OrderPage orderPage = new OrderPage();
    @Given("User should navigate to url")
    public void user_should_navigate_to_url() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @Given("User should be able to click delivery address box")
    public void user_should_be_able_to_click_delivery_address_box() {
        orderPage.addressBox.click();
    }

    @When("User should be able to enter a {string}")
    public void user_should_be_able_to_enter_a(String address) throws InterruptedException {
        orderPage.addressBox.sendKeys(address);
        Thread.sleep(4000);
    }
    @When("User should be able to hit the enter on keyboard and not see error message {string}")
    public void user_should_be_able_to_hit_the_enter_on_keyboard_and_not_see_error_message(String expectedErrorMessage) throws InterruptedException {
        WebElement currentElement = Driver.get().switchTo().activeElement();
        currentElement.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        String actualErrorMessage = orderPage.errorMessage.getText();
       // System.out.println("actualErrorMessage = " + actualErrorMessage);
        if(actualErrorMessage.equals("Diese Adresse liegt außerhalb unseres Liefergebietes.")){
            actualErrorMessage = "This address is outside of our delivery area.";
        }
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
        System.out.println("actualErrorMessage = " + actualErrorMessage);

    }

    @Then("User should be able to see Deliver here button is clickable")
    public void user_should_be_able_to_see_Deliver_here_button_is_clickable() {
        boolean conditionOfDelivery = orderPage.deliveryHereButton.isEnabled();

        System.out.println("conditionOfDelivery = " + conditionOfDelivery);

        Assert.assertTrue(conditionOfDelivery);

    }

    @When("User should click {string} and land {string} page")
    public void user_should_click_and_land_page(String pickUpLocation1, String pickUpLocation2) throws InterruptedException {
        if (pickUpLocation1.equals("Enjoy+Pizza+Bremen")){
            orderPage.bremenPickUpLocation.click();
            String landingPageTitle=orderPage.locationPageTitle.getText();
            Assert.assertEquals(pickUpLocation2,landingPageTitle);
        }else{
            orderPage.delmenhorstPickUpLocation.click();
            String landingPageTitle=orderPage.locationPageTitle.getText();
            Assert.assertEquals(pickUpLocation2,landingPageTitle);
        }
//        Thread.sleep(2000);
//        if (orderPage.closeWarningButton.isDisplayed()){
//            orderPage.closeWarningButton.click();
//            isResturantOpen=false;
//        }
        try {
            if (orderPage.closeWarningButton.isDisplayed()) {
                orderPage.closeWarningButton.click();
                isResturantOpen = false;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        Thread.sleep(2000);
        orderPage.LanguageSwitcher.click();
        orderPage.LanguageEnglish.click();
    }

    @When("User should click {string} and land ingredients page")
    public void user_should_click_and_land_ingredients_page(String pizzaType)  {
        orderPage.selectPizzaType(pizzaType).click();
      String actualIngrediendPageTitle =  orderPage.checkPizzaIngredienTitle(pizzaType).getText();

        System.out.println("actualIngrediendPageTitle = " + actualIngrediendPageTitle);

        Assert.assertEquals(pizzaType,actualIngrediendPageTitle);

    }

    @When("User should select {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_should_select(String size, String freeIngred, String extra1, String extra2, String extra3, String extra4, String cheeseCrust, String dipSouce) {
    orderPage.pizzaSize(size).click();

    orderPage.freeIngredient.click();
    orderPage.extraIngredient(freeIngred).click();

    orderPage.extraIngredient1.click();
    orderPage.extraIngredient(extra1).click();

    orderPage.extraIngredient2.click();
    orderPage.extraIngredient(extra2).click();

    orderPage.extraIngredient3.click();
    orderPage.extraIngredient(extra3).click();

    orderPage.extraIngredient4.click();
    orderPage.extraIngredient(extra4).click();

    orderPage.cheeseCrust.click();
    orderPage.kaserandIngredient(cheeseCrust).click();

    orderPage.dipSouces.click();
    orderPage.extraIngredient(dipSouce).click();

    }
    @When("User should click Confirm")
    public void user_should_click_confirm() {
        orderPage.confirm.click();
    }
    @Then("User should see orders in shopping cart")
    public void user_should_see_orders_in_shopping_cart() {
       String actualResult = orderPage.shoppingCart.getText();
       String expectedResult = "Shopping cart";
       Assert.assertEquals(expectedResult,actualResult);
    }
    @Then("User should click order now")
    public void user_should_click_order_now() {
        if (isResturantOpen){
        orderPage.orderNow.click();
         } else {
        orderPage.preorder.click();
    }
    }
    @Then("User should fill out address form")
    public void user_should_fill_out_address_form() throws InterruptedException {
        orderPage.firstName.sendKeys("Mustafa");
        Thread.sleep(500);
        orderPage.lastName.sendKeys("Ozartan");
        Thread.sleep(500);
        orderPage.street.sendKeys("Millet");
        Thread.sleep(500);
        orderPage.number.sendKeys("34567");
        Thread.sleep(500);
        orderPage.postalCode.sendKeys("45673");
        Thread.sleep(500);
        orderPage.city.sendKeys("Bremen");
        Thread.sleep(500);
        orderPage.email.click();
        orderPage.email.sendKeys("ozzzartan@gmail.com");
        Thread.sleep(500);
        orderPage.phone.sendKeys("09466614544");
        Thread.sleep(500);
        orderPage.additionalDirections.sendKeys("Please Delivery Hot");
        Thread.sleep(500);

    }
    @Then("User should click checkout")
    public void user_should_click_checkout() throws InterruptedException {
        orderPage.checkoutButton.click();
        Thread.sleep(3000);
    }
    @Then("User should select {string}")
    public void user_should_select(String payment) {
        orderPage.selectPaymentMethod(payment);
    }
    @Then("User should click place my order")
    public void user_should_click_place_my_order() {
        orderPage.placeMyOrderButton.click();
    }
    @Then("User should land payment page")
    public void user_should_land_payment_page() throws InterruptedException {
        Thread.sleep(1000);
    }

}
