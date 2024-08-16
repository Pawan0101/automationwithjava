package com.pkg.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".\\FeatureFiles\\parabankloginDataDriven.feature",
		glue = "com.pkg.stepdefinition",
		dryRun = false,
		monochrome = false,
		plugin = {"html:reports/webreport.html","json:reports/jsonreports.json","html:reports/cucumber-reports.html"},
		tags = "@smoke"
		)

public class RunnerClass {

}
