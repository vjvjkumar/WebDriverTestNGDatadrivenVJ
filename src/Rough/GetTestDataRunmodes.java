package Rough;

import com.gktech.util.XLS_Reader;

public class GetTestDataRunmodes {
	public static void main(String[] args) {
		XLS_Reader xls=new XLS_Reader(System.getProperty("user.dir")+"/src/com/gktech/xlsfiles/newcars.xlsx");
		getTestDataRunmodes(xls, "Login");
		}
	
//To get the Runmodes of the TestData
		public static String[] getTestDataRunmodes(XLS_Reader xls, String sheetName){
		String[] runmodes;
	
		if(!xls.isSheetExist(sheetName)){
			System.out.println("Test data sheet not found");
		}
		
	//size declaration
		runmodes=new String[xls.getRowCount(sheetName)-1];
		
	//values declaration
		for(int i=2;i<=xls.getRowCount(sheetName);i++) {
		System.out.println(xls.getCellData(sheetName, "Runmode", i));
    		 runmodes[i-2]=xls.getCellData(sheetName, "Runmode", i);
		}		
		return runmodes;		
	}

}
