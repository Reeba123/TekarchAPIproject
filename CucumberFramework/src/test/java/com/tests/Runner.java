package com.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features= {"src/test/resources/BasicFeature.feature"},
		glue={"com.tests"}
		
		)

public class Runner extends AbstractTestNGCucumberTests{
	

}
