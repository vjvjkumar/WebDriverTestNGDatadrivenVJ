package Rough;

import com.gktech.util.XLS_Reader;

public class SuiteRunnable {
	
	public static void main(String[] args) {
		XLS_Reader xls=new XLS_Reader(System.getProperty("user.dir")+"/src/com/gktech/xlsfiles/Suite.xlsx");
		System.out.println(isSuiteRunnable(xls, "sellcars"));
	}
	
	
//To get the Runmode of the Suite
	public static boolean isSuiteRunnable(XLS_Reader xls, String suiteName){
		boolean isExecutable=false;
		
		for(int i=2;i<=xls.getRowCount("Testsuites");i++){
			
			String suite=xls.getCellData("Testsuites", "TSID", i);
			String runmode=xls.getCellData("Testsuites", "Runmode", i);
			System.out.println(suite+"   "+runmode);
			
			if(suite.equalsIgnoreCase(suiteName)) {
			if(runmode.equalsIgnoreCase("Y")) {
				isExecutable=true;
				}
				}
		}
		return isExecutable;
		}
}
