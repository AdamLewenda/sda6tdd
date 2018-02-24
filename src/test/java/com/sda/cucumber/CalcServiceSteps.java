package com.sda.cucumber;

import com.sda.CalcService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CalcServiceSteps {

    private String text;

    private CalcService calcService;

    private int actual;

    @Given("^I initialize CalcService$")
    public void I_initialize_CalcService() {
        calcService = new CalcService();
    }

    @And("^I pass null$")
    public void I_pass_null() {
        text = null;
    }

    @And("^I pass blank$")
    public void I_pass_blank() {
        text = "";
    }

    @And("^I pass (.*) value$")
    public void I_pass_text_value(String text) {
        this.text = text;
    }

    @When("^I execute Calculate method$")
    public void I_execute_Calculate_method() {
        actual = calcService.calculate(text);
    }

    @Then("^I get (.*) as a result$")
    public void I_get_value_as_a_result(int result) {
        Assert.assertEquals(result, actual);
    }
}
