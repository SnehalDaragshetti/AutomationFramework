package FrameworkPractice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class ReadFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		//Step 1:Open document in java readable file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Navigate to required sheet
		Sheet sheet1 = wb.getSheet("Contacts");
		
		//Step 4: navigate to required row
		Row row1 = sheet1.getRow(1);
		
		//Step 5: Navigate to required cell
		Cell cell1 = row1.getCell(1);
		
		//Step 6: Capture the value in the cell
		String value1 = cell1.getStringCellValue();
		System.out.print(value1);
		
		//Step 7: close the workbook
		wb.close();
		
	
	}

}