package com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
	
	private static ArrayList<Model> models = new ArrayList<Model>();
	private static HashMap<String, Boolean> x = new HashMap<String,Boolean>();
//	private static String[] data = {"A","B","C","D","E","F","G","H"};
//	private static String[] daily = {"A","B","D","E"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = Util.getConnection();
		QueryService queryService = new QueryService();
		if(connection == null){
			System.out.println("Sorry Couldn't Connect to the Database!!1");
		}else{
			System.out.println("Connection established!!!");
			models = queryService.getModel(connection);
			for(Model model:models){
				String task = model.getTask();
				if(x.containsKey(task)){
					String error = model.getOutput();
					String input = model.getInput();
					if(error != null && input != null){
						if(Integer.parseInt(error) > 0){
							x.put(task, false);
						}
					}
				}else{
					String error = model.getOutput();
					String input = model.getInput();
					if(error != null && input != null){
						if(Integer.parseInt(error) > 0){
							x.put(task, false);
						}else{
							x.put(task, true);
						}
					}else{
						x.put(task, true);
					}
				}
			}
			
			ExcelService excelService = new ExcelService(x,x,x,x);
			excelService.createExcel();
			
			
//			XSSFWorkbook workbook = new XSSFWorkbook();
//	        XSSFSheet sheet = workbook.createSheet("Batch Job Status");
//	        XSSFCellStyle styleYellow = workbook.createCellStyle();
//			styleYellow.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
//			styleYellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//			XSSFCellStyle styleRed = workbook.createCellStyle();
//			styleRed.setFillForegroundColor(IndexedColors.RED1.getIndex());
//			styleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//			XSSFCellStyle styleGrey = workbook.createCellStyle();
//			styleGrey.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
//			styleGrey.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//			
//			int rowCount = 1;
//			int columnCount = 1;
//			for(String temp:data){
//				Row row = sheet.createRow(rowCount++);
//				Cell cell = row.createCell(columnCount);
//				cell.setCellValue(temp);
//			}
//			
//			rowCount = 1;
//			columnCount = 2;
//			for(String temp:data){
//				Row row = sheet.getRow(rowCount++);
//				Cell cell = row.createCell(columnCount);
//				if(x.containsKey(temp)){
//					boolean success = x.get(temp);
//					if(success)
//						cell.setCellValue("Success");
//					else{
//						cell.setCellValue("Error");
//						cell.setCellStyle(styleRed);
//					}
//				}else{
//					if(Arrays.asList(daily).contains(temp)){
//						cell.setCellValue("Data Not Shared");
//						cell.setCellStyle(styleYellow);
//					}else{
//						cell.setCellValue("Data On Request");
//						cell.setCellStyle(styleGrey);
//					}
//				}
//			}
//			sheet.autoSizeColumn(2);
//	        
//			try {
//				FileOutputStream outputStream = new FileOutputStream("Temp.xlsx");
//				workbook.write(outputStream);
//				outputStream.close();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		
		
//		Set set = x.entrySet();
//		Iterator i = set.iterator();
//		while(i.hasNext()) {
//	         Map.Entry me = (Map.Entry)i.next();
//	         System.out.print(me.getKey() + ": ");
//	         System.out.println(me.getValue());
//	     }
	}

}
