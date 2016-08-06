package com.gktech.sellcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class LocateDealer extends TestSuiteBase{
	static int count=-1;

@BeforeTest
	public void checkTestCaseSkip(){
		if(!TestUtil.isTestCaseRunnable(sellcarsxls, "LocateDealer")){
		throw new SkipException("Runmode of the LocateDealer test case is set as no, so skipping LocateDealer testcase");
		}
		runmodes=TestUtil.getTestDataRunmodes(sellcarsxls, "LocateDealer");
		}
	
@Test(dataProvider="getData")
	public void locateDealer(String Uname, String Pass){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of the test data is set as no, so skipping Rownumber: "+(count+1));
		}
	//executing test case:
		System.out.println("Executing test case LocateDealer with parameter: "+Uname+"=="+Pass);
	//webdriver code
		OpenBrowser();
		
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("logLocation").sendKeys("Hyderabad Central, Hyderabad, Telangana");
		getObject("logLink").click();
		getObject("logEmail").sendKeys(Uname);
		getObject("logPass").sendKeys(Pass);
		getObject("logbuttonLOGIN").click();
		
		CloseBrowser();
	}
	
@DataProvider
	public String[][] getData(){
		return TestUtil.getTestData(sellcarsxls, "LocateDealer");
		
	}

}
