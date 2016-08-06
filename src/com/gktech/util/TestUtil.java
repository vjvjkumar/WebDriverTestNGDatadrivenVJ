package com.gktech.util;

public class TestUtil {
//To get the Runmode of the Suite
	public static boolean isSuiteRunnable(XLS_Reader xls, String suiteName){
		boolean isExecutable=false;		
		
		for(int i=2;i<=xls.getRowCount("Testsuites");i++){
			String suite=xls.getCellData("Testsuites", "TSID", i);
			String runmode=xls.getCellData("Testsuites", "Runmode", i);
			System.out.println(suite+"==="+runmode);
			
			if(suite.equalsIgnoreCase(suiteName)){
			if(runmode.equalsIgnoreCase("Y")){
			isExecutable=true;
			}
			}
		}
		return isExecutable;
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
	
//To get the Runmodes of the Test Data 
	public static String[] getTestDataRunmodes(XLS_Reader xls, String sheetName){
		String[] runmodes;
		if(!xls.isSheetExist(sheetName)){
		System.out.println("Test data sheet not found");
		}
	//size declaration
		runmodes=new String[xls.getRowCount(sheetName)-1];
	//values declaration
		for(int i=2;i<=xls.getRowCount(sheetName);i++){
		System.out.println(xls.getCellData(sheetName, "Runmode", i));
		runmodes[i-2]=xls.getCellData(sheetName, "Runmode", i);
		}		
		return runmodes;		
		}


//To get the TestData from the Excel Sheet
	public static String[][] getTestData(XLS_Reader xls, String sheetName){
		if(!xls.isSheetExist(sheetName)){
			System.out.println("Test data sheet not found");
		}
		int rows=xls.getRowCount(sheetName);
		int cols=xls.getColumnCount(sheetName);
	//size declaration
		String[][] data=new String[rows-1][cols-1];
	//values declaration
		for(int rowNum=2;rowNum<=rows;rowNum++){
		for(int colNum=0;colNum<=cols-2;colNum++){
				System.out.print(xls.getCellData(sheetName, colNum, rowNum)+"==");
				data[rowNum-2][colNum]=xls.getCellData(sheetName, colNum, rowNum);
			}
			System.out.println();
			}		
		return data;
	}
	

}
