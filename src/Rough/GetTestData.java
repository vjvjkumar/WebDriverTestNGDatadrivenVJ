package Rough;

import com.gktech.util.XLS_Reader;

public class GetTestData {
	
	public static void main(String[] args) {
		
		XLS_Reader xls=new XLS_Reader(System.getProperty("user.dir")+"/src/com/gktech/xlsfiles/newcars.xlsx");
		getTestData(xls, "Registration");
		}
	
//To get the test data from the Excel Sheet
	public static String[][] getTestData(XLS_Reader xls, String sheetName){
		if(!xls.isSheetExist(sheetName)){
			System.out.println("Test data sheet not found");
		}
		int rows=xls.getRowCount(sheetName);
		int cols=xls.getColumnCount(sheetName);

	//size declaration
		String[][] data=new String[rows-1][cols-1];

	//values declaration
		for(int rowNum=2;rowNum<=rows;rowNum++) {
		for(int colNum=0;colNum<=cols-2;colNum++) {
			
				System.out.print(xls.getCellData(sheetName, colNum, rowNum)+"==");
				data[rowNum-2][colNum]=xls.getCellData(sheetName, colNum, rowNum);
			}
			System.out.println();
		}		
		return data;
	}

}
