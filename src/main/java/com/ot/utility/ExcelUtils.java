package com.ot.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ot.constants.FrameworkConstants;
import com.ot.exceptions.FrameworkException;
import com.ot.exceptions.InvalidPathForExcelException;


public final class ExcelUtils {

	
	private ExcelUtils() {};

	public static List<Map<String, String>> getTestDetails(String sheetName){


		List<Map<String,String>> list = null;

		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath())){
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);

		

			int lastRowNum = sheet.getLastRowNum();
			int colNum = sheet.getRow(0).getLastCellNum();

			Map<String, String> map = null ;
			list = new ArrayList<>();
			for (int i =1; i<=lastRowNum;i++) {
				map = new HashMap<>();
				for(int j=0; j<colNum;j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map); 
			}

		} catch (FileNotFoundException e) {
			throw new InvalidPathForExcelException("Excel File path is invalid, Please check on it");
		} catch (IOException e) {
			throw new FrameworkException("We have Input Output excpetion while reading excel file");
		} 


		return list;

	}
}
