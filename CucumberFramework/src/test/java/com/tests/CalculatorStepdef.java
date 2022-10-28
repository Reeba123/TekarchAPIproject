package com.tests;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorStepdef {
	   int a,b;
	   int res=0;
	   
	@When("I enter two value of a and b")
	public void i_enter_two_value_of_a_and_b() {
	   a=10;
	   b=10;
	}

	@When("add it")
	public void add_it() {
	res=a+b;
	}

	@Then("I should get the result")
	public void i_should_get_the_result() {
	   System.out.println(res);
	}
	@When("I enter two value of a as {string} and b as {string}")
	public void i_enter_two_value_of_a_as_and_b_as(String value1, String value2) {
	   a=Integer.parseInt(value1);
	   b=Integer.parseInt(value2);
	}

	@Then("I should get the result as {int}")
	public void i_should_get_the_result_as(int expected) {
	 //System.out.println(res);
		Assert.assertEquals(res,expected );
		System.out.println("passed");
	}


}
