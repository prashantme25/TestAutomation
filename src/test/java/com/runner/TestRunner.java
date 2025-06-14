package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		  features = "src/test/java/com/features",
		  glue = {"com.StepDefnitions","com.helper"},
		  tags = "@test",
		  plugin = "json:target/jsonReports/testreport.json"
		)


public class TestRunner {

}
