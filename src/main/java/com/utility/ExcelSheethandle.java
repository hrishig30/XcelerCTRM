package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.base.baseClass;



public class ExcelSheethandle extends baseClass
{
	public FileInputStream excel;
	Sheet sh = null;
	String sheetname = null;

	//Select Files
			public void excelUserAccount() throws FileNotFoundException {
				excel = new FileInputStream(projectPath+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testData"+File.separator+"DataSheet.xlsx");
				
			}
				
				
		//Select Sheet	
			public void getSheet() throws EncryptedDocumentException, IOException 
			{
				excelUserAccount();
				sh = WorkbookFactory.create(excel).getSheet(sheetname);
				
			}
			
		//Return Data in Hash Map
			public HashMap<String, Object> getExcelSheetData(String sheetName, int row) 
			{
				sheetname = sheetName;
				try {
					getSheet();
				} catch (EncryptedDocumentException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				DataFormatter formatter = new DataFormatter();
				int getRow = sh.getLastRowNum();
				int column = sh.getRow(0).getLastCellNum();
				
				
				HashMap<String, Object> data = new HashMap();
							
					
					
					for(int j=0; j<column; j++) {
						
						data.put(sh.getRow(0).getCell(j).getStringCellValue(), 
								formatter.formatCellValue(sh.getRow(row).getCell(j)));
			
					}
				return data;
			}
			 
	
	
	

}
