package utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcel {
	private static String fileToWorkOn;
	
	public static ReadExcel getInstance(String filePath) {	
		fileToWorkOn=filePath;
		return new ReadExcel();
	}
	
	public List<String> readAttributeValue(String sheetname, String attribute) throws IOException{
		File file=new File(fileToWorkOn);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
	    XSSFSheet sheet=workbook.getSheet(sheetname);
	
	    int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		int rowIndex = -1000;
		String a;
		List<String> data = new ArrayList<>();
		for (int i = 1; i < rowCount; i++) {
			a=sheet.getRow(i).getCell(0).getStringCellValue().trim();
			if (a.equalsIgnoreCase(attribute)) {
				rowIndex = i;
				break;
			}	
		}
		if(rowIndex!=-1000)
		{
			while(attribute.equals(sheet.getRow(rowIndex).getCell(0).getStringCellValue()))
			{
				String asa=sheet.getRow(rowIndex).getCell(1).getStringCellValue();
				data.add(asa);
				rowIndex++;
			}
		}     
	        
	return data;
	   // workbook.close();
       
   }
	public String readAttribute(String sheetname, String attribute) throws IOException{
		File file=new File(fileToWorkOn);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
	    XSSFSheet sheet=workbook.getSheet(sheetname);
	
	    int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		int rowIndex = -1000;
		String a;
		String data = null;
		for (int i = 1; i < rowCount; i++) {
			a=sheet.getRow(i).getCell(0).getStringCellValue().trim();
			if (a.equalsIgnoreCase(attribute)) {
				rowIndex = i;
				break;
			}	
		}
		if(rowIndex!=-1000)
		{
			if(attribute.equals(sheet.getRow(rowIndex).getCell(0).getStringCellValue()))
			{
				 data=sheet.getRow(rowIndex).getCell(0).getStringCellValue();
			}
		}     
	        
	return data;
	   // workbook.close();
       
   }
}
