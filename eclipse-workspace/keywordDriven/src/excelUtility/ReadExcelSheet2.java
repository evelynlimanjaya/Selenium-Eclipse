package excelUtility;
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet2 
{ 
	   public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException{


		    //Create an object of File class to open xlsx file

		    File file =    new File(filePath+"\\"+fileName);

		    //Create an object of FileInputStream class to read excel file

		    FileInputStream inputStream = new FileInputStream(file);

		    Workbook testWorkbook = null;

		    //Find the file extension by splitting file name in substring  and getting only extension name

		    String fileExtensionName = fileName.substring(fileName.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    testWorkbook = new XSSFWorkbook(inputStream);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of HSSFWorkbook class

		        testWorkbook = new HSSFWorkbook(inputStream);

		    }

		    //Read sheet inside the workbook by its name

		    Sheet testSheet = testWorkbook.getSheet(sheetName);

		    //Find number of rows in excel file

//		    int rowCount = testSheet.getLastRowNum()-testSheet.getFirstRowNum();
////
////		    //Create a loop over all the rows of excel file to read it
//
//		    for (int i = 0; i < rowCount+1; i++) {
//
//		        Row row = testSheet.getRow(i);
//
//		        //Create a loop to print cell values in a row
//
//		        for (int j = 0; j < row.getLastCellNum(); j++) {
//
//		            //Print Excel data in console
//
//		            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
//
//		        }
//
//		        System.out.println();
//		    }
			return testSheet; 

		    }  

//		    //Main function is calling readExcel function to read data from excel file
//
//		    public static void main(String...strings) throws IOException{
////
//		    //Create an object of ReadGuru99ExcelFile class
//
//		    ReadExcelSheet objExcelFile = new ReadExcelSheet();
//
//		    //Prepare the path of excel file
//
//		    String filePath = "C:\\Users\\Eien\\Selenium-Eclipse\\eclipse-workspace\\keywordDriven\\src\\excelData";
//
//		    //Call read file method of the class to read data
//
//		    objExcelFile.readExcel(filePath,"DemoFile.xlsx","Sheet1");
//
//		    }
}