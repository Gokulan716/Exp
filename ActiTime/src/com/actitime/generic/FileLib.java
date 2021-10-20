package com.actitime.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * Genric class for data driven testing
 * @author Gokul
 */
public class FileLib {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/Data.property");
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
	}
	public String getExcelData(String sheetname,int row,int cloumn) throws EncryptedDocumentException, IOException {
		FileInputStream fs=new FileInputStream("./data/testscripts.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		String data = wb.getSheet(sheetname)).getRow(row).getCell(cloumn).getStringCellValue();
		return data;

	}
}
