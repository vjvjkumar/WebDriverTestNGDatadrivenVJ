package com.gktech.usedcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class SearchUsedCars extends TestSuiteBase{
	static int count=-1;
	
@BeforeTest
	public void checkTestCaseSkip(){
		if(!TestUtil.isTestCaseRunnable(usedcarsxls, "SearchUsedCars")){
		throw new SkipException("Runmode of the SearchUsedCars test case is set as no, so skipping SearchUsedCars testcase");
		}
		runmodes=TestUtil.getTestDataRunmodes(usedcarsxls, "SearchUsedCars");
		}
	
@Test(dataProvider="getData")
	public void searchUsedCars(String Uname, String Pass){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of the test data is set as no, so skipping Rownumber: "+(count+1));
		}
	//executing test case:
		System.out.println("Executing test case SearchUsedCars with parameter: "+Uname+"=="+Pass);
	//webdriver code
		OpenBrowser();
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("logLocation").sendKeys("Hyderabad Central, Hyderabad, Telangana");
		getObject("logLink").click();
		getObject("logEmail").sendKeys("Uname");
		getObject("logPass").sendKeys("Pass");
		getObject("logbuttonLOGIN").click();
	}
@DataProvider
	public String[][] getData(){
		return TestUtil.getTestData(usedcarsxls, "SearchUsedCars");
	}
}
