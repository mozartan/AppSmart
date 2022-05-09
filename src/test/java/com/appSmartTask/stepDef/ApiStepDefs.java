package com.appSmartTask.stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;


public class ApiStepDefs {
    String hrurl= "https://hermes-dev.devteam.win/-bremen-2/";
    static Response response;

    @When("Logging Enjoy Pizza Api using url")
    public void logging_enjoy_pizza_api_using_url() {
        response = RestAssured.get(hrurl);
        response.statusCode();
}
    @Then("Status code should be {int}")
    public void status_code_should_be(int statusCode) {
        response = RestAssured.get(hrurl);
        Assert.assertEquals(statusCode,response.statusCode());
        System.out.println(response.statusCode());
    }
    @Then("Response header should be {string}")
    public void response_header_should_be(String header) {
        Response response = RestAssured.get(hrurl);
        Assert.assertEquals(header,response.getHeader("Content-Type"));
        System.out.println(response.getHeader("Content-Type"));
    }
}
