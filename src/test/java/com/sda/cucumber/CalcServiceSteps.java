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

    @And("^I pass text value to compute$")
    public void I_pass_text_value_to_compute() {
        text = "2;3;4";
    }

    @And("^I pass null text value$")
    public void I_pass_null_text_value() {
        text = null;
    }

    @And("^I pass blank value$")
    public void I_pass_blank_value() {
        text = "";
    }

    @And("^I pass text with letters$")
    public void I_pass_text_with_letters() {
        text = "3a;2;4;5b";
    }

    @When("^I execute Calculate method$")
    public void I_execute_Calculate_method() {
        actual = calcService.calculate(text);
    }

    @Then("^I get correct result$")
    public void I_get_correct_result() {
        Assert.assertEquals(9, actual);
    }

    @Then("^I get 0 as a result$")
    public void I_get_0_as_a_result() {
        Assert.assertEquals(0, actual);
    }

    @Then("^I get result for text with letters$")
    public void I_get_result_for_text_with_letters() {
        Assert.assertEquals(14, actual);
    }
}
