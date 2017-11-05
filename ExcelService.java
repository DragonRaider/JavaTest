package com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelService {
	
	private HashMap<String,Boolean> x = new HashMap<String,Boolean>();
	private HashMap<String,Boolean> y = new HashMap<String,Boolean>();
	private HashMap<String,Boolean> z = new HashMap<String,Boolean>();
	private HashMap<String,Boolean> u = new HashMap<String,Boolean>();
	
	private static String[] datas = {"A","B","C","D","E","F","G","H"};
	private static String[] daily = {"A","B","D","E"};
	private static String[] header = {"Batch Jobs","X","Y","Z","U"};
	
	private XSSFWorkbook workbook = new XSSFWorkbook();
    private XSSFSheet sheet = workbook.createSheet("Status");
    private XSSFCellStyle styleYellow = workbook.createCellStyle();
	private XSSFCellStyle styleRed = workbook.createCellStyle();
	private XSSFCellStyle styleGrey = workbook.createCellStyle();
	
	
	public ExcelService(HashMap<String,Boolean> x,HashMap<String,Boolean> y,HashMap<String,Boolean> z,HashMap<String,Boolean> u){
		this.x = x;
		this.y = y;
		this.z = z;
		this.u = u;
		styleYellow.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		styleYellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styleRed.setFillForegroundColor(IndexedColors.RED1.getIndex());
		styleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styleGrey.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		styleGrey.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	}
	
	public void createExcel(){
		
		int rowCount = 0;
		int columnCount = 1;
		for(String head:header){
			if(columnCount == 1){
				Row row = sheet.createRow(rowCount);
				Cell cell = row.createCell(columnCount++);
				cell.setCellValue(head);
			}else{
				Row row = sheet.getRow(rowCount);
				Cell cell = row.createCell(columnCount++);
				cell.setCellValue(head);
			}
		}
		
		rowCount = 1;
		columnCount = 1;
		for(String data:datas){
			Row row = sheet.createRow(rowCount++);
			Cell cell = row.createCell(columnCount);
			cell.setCellValue(data);
		}
		
		rowCount = 1;
		columnCount = 2;
		for(String data:datas){
			Row row = sheet.getRow(rowCount++);
			Cell cell = row.createCell(columnCount);
			if(x.containsKey(data)){
				boolean success = x.get(data);
				if(success)
					cell.setCellValue("Success");
				else{
					cell.setCellValue("Error");
					cell.setCellStyle(styleRed);
				}
			}else{
				if(Arrays.asList(daily).contains(data)){
					cell.setCellValue("Data Not Shared");
					cell.setCellStyle(styleYellow);
				}else{
					cell.setCellValue("Data On Request");
					cell.setCellStyle(styleGrey);
				}
			}
		}
		
		rowCount = 1;
		columnCount = 3;
		for(String data:datas){
			Row row = sheet.getRow(rowCount++);
			Cell cell = row.createCell(columnCount);
			if(y.containsKey(data)){
				boolean success = y.get(data);
				if(success)
					cell.setCellValue("Success");
				else{
					cell.setCellValue("Error");
					cell.setCellStyle(styleRed);
				}
			}else{
				if(Arrays.asList(daily).contains(data)){
					cell.setCellValue("Data Not Shared");
					cell.setCellStyle(styleYellow);
				}else{
					cell.setCellValue("Data On Request");
					cell.setCellStyle(styleGrey);
				}
			}
		}
		
		rowCount = 1;
		columnCount = 4;
		for(String data:datas){
			Row row = sheet.getRow(rowCount++);
			Cell cell = row.createCell(columnCount);
			if(z.containsKey(data)){
				boolean success = z.get(data);
				if(success)
					cell.setCellValue("Success");
				else{
					cell.setCellValue("Error");
					cell.setCellStyle(styleRed);
				}
			}else{
				if(Arrays.asList(daily).contains(data)){
					cell.setCellValue("Data Not Shared");
					cell.setCellStyle(styleYellow);
				}else{
					cell.setCellValue("Data On Request");
					cell.setCellStyle(styleGrey);
				}
			}
		}
		
		rowCount = 1;
		columnCount = 5;
		for(String data:datas){
			Row row = sheet.getRow(rowCount++);
			Cell cell = row.createCell(columnCount);
			if(u.containsKey(data)){
				boolean success = u.get(data);
				if(success)
					cell.setCellValue("Success");
				else{
					cell.setCellValue("Error");
					cell.setCellStyle(styleRed);
				}
			}else{
				if(Arrays.asList(daily).contains(data)){
					cell.setCellValue("Data Not Shared");
					cell.setCellStyle(styleYellow);
				}else{
					cell.setCellValue("Data On Request");
					cell.setCellStyle(styleGrey);
				}
			}
		}
		
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		
		try {
			FileOutputStream outputStream = new FileOutputStream("Temp.xlsx");
			workbook.write(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
