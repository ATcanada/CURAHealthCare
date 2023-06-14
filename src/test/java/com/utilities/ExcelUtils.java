package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	@DataProvider(name="Data")
	public Object[][] getchangePwdData(Method m) throws IOException {

		File src=new File("C:\\Anu\\HealthProject\\CURA Healthcare Service\\src\\test\\java\\com\\testData\\HealthInvalid.xlsx");
		//load the excel file
		FileInputStream fis=new FileInputStream(src);
		//load the workbook from the above excel file 
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//load the sheet from above excel workbook
		XSSFSheet sheet=wb.getSheetAt(0);
		
		// how many total rows in my excel sheet
		int rowCount=sheet.getLastRowNum();
		System.out.println("Total Row Count: " +rowCount);
		
		int rows = rowCount + 1;
		System.out.println("Total No Of Rows: "+rows);
	
		int cellCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Total Cell count: "+cellCount);

		//String data[][] = new String [rowCount][cellCount];
		Object data[][] = new Object [rowCount][cellCount];
		for(int i=1; i<=rowCount; i++) {
				Row r=sheet.getRow(i);
				
			for(int j=0; j<cellCount; j++) {
				Cell cell=r.getCell(j);
				if(cell.getCellTypeEnum()==CellType.NUMERIC) {
					
				data[i-1][j]=String.valueOf(cell.getNumericCellValue());
				}else if(cell.getCellTypeEnum()==CellType.STRING) {
					data[i-1][j]=cell.getStringCellValue();
					//data[i-1][j]=String.valueOf(cell.getNumericCellValue());
				}
				else {
					data[i][j]=" ";
				}
				System.out.println(data[i-1][j]);
				}
			}
		wb.close();
		fis.close();
			return data;
			
			
		}

}
