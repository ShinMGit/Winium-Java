package com.pri.cucumberOption;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(
		features = {"src/test/resource/features/"},
		plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"},
		glue = {"com.pri.stepDef"},
		monochrome = true,
		tags = {"@smk"}
		)

public class TestRunner {

}
