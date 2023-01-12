package com.ESS.Payroll.Runnerfiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/com/ESS/Payroll/features"},
		glue= {"com.ESS.Payroll.stepDefinitions"},
		stepNotifications = true,
		dryRun = false,
		monochrome=true,
		plugin= {"pretty","html:test-output"}
		)
public class JunitRunner {

}
