package com.gktech.usedcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.gktech.util.TestUtil;

public class UsedCarValuation extends TestSuiteBase{
	static int count=-1;

@BeforeTest
	public void checkTestCaseSkip(){
		if(!TestUtil.isTestCaseRunnable(usedcarsxls, "UsedCarValuation")){
		throw new SkipException("Runmode of the UsedCarValuation test case is set as no, so skipping UsedCarValuation testcase");
		}
		runmodes=TestUtil.getTestDataRunmodes(usedcarsxls, "UsedCarValuation");
		}
	
@Test(dataProvider="getData")
	public void usedCarValuation(String Name, String EmailAddress, String Mobile, String Password, String ConfirmPass){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of the test data is set as no, so skipping Rownumber: "+(count+1));
		}
	//executing test case:
		System.out.println("Executing test case UsedCarValuation with parameter: "+Name+"=="+EmailAddress+"=="+Mobile+"=="+Password+"=="+ConfirmPass);
	//webdriver code
		OpenBrowser();
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("logLocation").sendKeys("Hyderabad Central, Hyderabad, Telangana");
		getObject("logLink").click();
		getObject("regSignUp").click();
		getObject("regName").sendKeys("Name");
		getObject("regEmail").sendKeys("EmailAddress");
		getObject("regMobile").sendKeys("Mobile");
		getObject("regPassword").sendKeys("Password");
		getObject("regConfPass").sendKeys("ConfirmPass");
		getObject("regSignUpButton").click();
}
		
@DataProvider
	public String[][] getData(){
		return TestUtil.getTestData(usedcarsxls, "UsedCarValuation");
		
	}

}
