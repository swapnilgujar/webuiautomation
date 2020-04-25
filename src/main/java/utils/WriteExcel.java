package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	private static String fileToWorkOn;
	private WriteExcel() {}
	public static WriteExcel getInstance(String filePath) {	
		fileToWorkOn=filePath;
		return new WriteExcel();
	}
	
	public WriteExcel setAttributeValue(String sheetname, String attribute, String dataToWrite) throws IOException
	{
		File file=new File(fileToWorkOn);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
	    XSSFSheet sheet=workbook.getSheet(sheetname);
	
	    int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		int rowIndex = -1000;
		String a;
		for (int i = 1; i < rowCount; i++) {
			a=sheet.getRow(i).getCell(0).getStringCellValue().trim();
			if (a.equalsIgnoreCase(attribute)) {
				rowIndex = i;
				break;
			}	
		}
		if(rowIndex!=-1000)
		{
			Row row=sheet.getRow(rowIndex);
			Cell cell = row.getCell(1);
			cell.setCellValue(dataToWrite);
		}     
	        inputStream.close();
	        FileOutputStream out = new FileOutputStream(file); 
            workbook.write(out); 
            out.close();
	
	   // workbook.close();
            return this;
	}
}
