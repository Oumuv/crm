package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.concurrent.Worker;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class TestRunClass {
	
	
	public static void main(String[] args) {
	}
	public void run(){
			
	}
	
	/**
	 * 集合差集运算
	 * @return
	 */
	private List<Long> setDifferenceSet(List<Long> list1,List<Long> list2){
		List<Long> list = new ArrayList<Long>();
		 list.addAll(list1);
		list.removeAll(list2);
		return list;
	}
	
	@Test
	public void excelAction(){
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet();
		for (int i = 0;i<10;i++) {
			HSSFRow sheetRow = sheet.createRow(i);
			for (int j = 0;j<10;j++) {
				HSSFCell cell = sheetRow.createCell(j);
				int i1 = i + 1;
				int j1 = j + 1;
				cell.setCellValue(i1+"行，"+j1+"列");
			}
		}
		try {
			File file = new File("C:/Users/Oumuv/Desktop/test.xls");
			FileOutputStream fos = new FileOutputStream(file);
			workBook.write(fos);
			fos.close();
			workBook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void excelRead(){
		File file = new File("C:/Users/Oumuv/Desktop/test.xls");
		try {
			HSSFWorkbook workBook = new HSSFWorkbook(FileUtils.openInputStream(file));
			HSSFSheet sheetAt = workBook.getSheetAt(0);
			//共行数
			int lastRowNum = sheetAt.getLastRowNum();
			for (int i = 0;i<lastRowNum;i++) {
				HSSFRow row = sheetAt.getRow(i);
				//获取单元格数
				short lastCellNum = row.getLastCellNum();
				for (int j = 0;j<lastCellNum;j++) {
					HSSFCell cell = row.getCell(j);
					System.out.print(cell.getStringCellValue()+"  ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
