package Rough;

import com.gktech.util.XLS_Reader;

public class TestCaseRunnaable {
	
	public static void main(String[] args) {
		XLS_Reader xls=new XLS_Reader(System.getProperty("user.dir")+"/src/com/gktech/xlsfiles/newcars.xlsx");
		System.out.println(isTestCaseRunnable(xls, "Registration"));		
		}
	
	
//To get the Runmode of the TestCase
	public static boolean isTestCaseRunnable(XLS_Reader xls, String testcaseName){
		boolean isExecutable=false;
		
		for(int i=2;i<=xls.getRowCount("Testcases");i++){
		
			String testcase=xls.getCellData("Testcases", "TCID", i);
			String runmode=xls.getCellData("Testcases", "Runmode", i);
			System.out.println(testcase+"==="+runmode);
		
			if(testcase.equalsIgnoreCase(testcaseName)){
			if(runmode.equalsIgnoreCase("Y")){
				isExecutable=true;
				}
				}
		}
		return isExecutable;		
		}

}
