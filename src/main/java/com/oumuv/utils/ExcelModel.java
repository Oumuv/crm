package com.oumuv.utils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将变量绑定到xls
 * 
 * @author Administrator
 * 
 */
public class ExcelModel {
	Map<String, Cell> map = new HashMap<String, Cell>();
	private final HSSFWorkbook wb;
	final String REGEX = "\\$\\!\\{\\w+\\}";
	final String HEADER_REGEX = "\\$\\#\\{\\w+\\}";
	Pattern pattern = Pattern.compile(REGEX);
	Pattern headerPatter = Pattern.compile(HEADER_REGEX);
	final HttpServletResponse response;
	private InputStream fs = null;

	/**
	 * 
	 * @param templateFilePath
	 *            模板文件路径及名称
	 * @param response
	 * @param codedFileName
	 *            下载文件的名
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	// public ExcelModel(String templateFilePath,HttpServletResponse
	// response,String codedFileName) throws FileNotFoundException,
	// IOException {
	// wb = initMap(templateFilePath);
	// this.response = response;
	// response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	// // 进行转码，使其支持中文文件名
	// codedFileName = new String(codedFileName.getBytes("UTF-8"),
	// "ISO-8859-1");//
	// response.setHeader("content-disposition", "attachment;filename=" +
	// codedFileName + ".xls");
	//
	// }
	//返回下载的文件
	public ExcelModel(String templateFilePath) throws FileNotFoundException, IOException {
		wb = initMap(templateFilePath);
		this.response = null;
	}
	public String getExcel(String templateFilePath) throws IOException {
//		OutputStream o = response.getOutputStream();
//		byte b[] = new byte[1024];
//		File fileLoad = new File(templateFilePath,"grades.xls");
//		// the dialogbox of download file.
//		response.setHeader("Content-disposition", "attachment;filename="+ "grades.xls");
//		response.setContentType("application/vnd.ms-excel");
//		
//		long fileLength = fileLoad.length();
//		String length = String.valueOf(fileLength);
//		response.setHeader("Content_Length", length);
//		// download the file.
//		FileInputStream in = new FileInputStream(fileLoad);
//		int n = 0;
//		while ((n = in.read(b)) != -1) {
//		   o.write(b, 0, n);
//		}
		
	   File file = new File(templateFilePath);
	   byte[] b = new byte[(int) file.length()];
  	   if (!file.getParentFile().exists()) {
  	    file.getParentFile().mkdirs();
  	   }
  	   try {
  	     file.createNewFile();
  	   } catch (IOException e) {
  	     e.printStackTrace();
  	   }
  	   try(FileWriter fw = new FileWriter(file, true);BufferedWriter bw = new BufferedWriter(fw)){
  		   int n = 0;
	  	   while ((n = fs.read()) != -1) {		
	  		   //bw.write(b, 0, n);
	  		   //bw.write(n);
	  		   //bw.write(b, 0, n);
	  	   }
	  	   if(fs != null){
				fs.close();
				fs = null;
			}
  	   bw.flush();
  	   bw.close();
  	   fw.close();
  	  } catch (IOException e) {
  	   e.printStackTrace();
  	  }
  	 
	   
	   FileReader fr = new FileReader(file);
	   BufferedReader bReader = new BufferedReader(fr);
	   String string = bReader.readLine();
	   System.out.println("路径为:"+templateFilePath+"\\"+"grades.xls");
	   System.out.println("数据为:"+string);
	   
	   
	   return templateFilePath+"\\"+"grades.xls";

	}
	
	
	public ExcelModel(String templateFilePath, HttpServletResponse response,
                      String codedFileName) throws FileNotFoundException, IOException {
		this(templateFilePath, response, codedFileName, null);
	}
	/*
	 * 支持中文文件名
	 */
	public ExcelModel(String templateFilePath, HttpServletResponse response,
                      String codedFileName, HttpServletRequest request)
			throws FileNotFoundException, IOException {
		wb = initMap(templateFilePath);
		this.response = response;
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		//if (request != null)
		if(null!=request){
			codedFileName = transferFileName(request, codedFileName);
			 response.setHeader("content-disposition", "attachment;filename="
						+ codedFileName + ".xls");
		}else{
			response.setHeader("content-disposition", "attachment;filename="
				+ new String(codedFileName.getBytes("GBK"), "iso8859-1") + ".xls");
		}
	}

	private String transferFileName(HttpServletRequest request, String filename)
			throws UnsupportedEncodingException {
		String agent = request.getHeader("USER-AGENT");
		String downLoadName = null;
		if (null != agent) {
			if (agent.contains("MSIE") || agent.contains("Trident")) { // IE
				downLoadName = new String(filename.getBytes("gb2312"), "iso-8859-1");
			} else {
				downLoadName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
			}
		} else {
			downLoadName = java.net.URLEncoder.encode(filename, "UTF-8");
		}
		return downLoadName;
	}

	/**
	 * 将变量绑定到一个单元格
	 * 
	 * @param para
	 *            xls模板中定义的变量名，在xls中的符号为西文的"！{para}"
	 * @param value
	 *            java中的变量
	 */
	public void bindCell(String para, String value) {
		bindCell(para, value, 0);
	}
	public void bindCell(String para, Number value) {
		bindCell(para, value, 0);
	}

	public void bindCellAttr(String para, String value) {
		bindCell(para, value, 0);
	}

	/**
	 * 将变量绑定到单元格
	 * 
	 * @param para
	 * @param value
	 * @param sheet
	 *            ，从0开始算
	 */
	public void bindCell(String para, String value, int sheet) {
		Cell c = map.get(String.format("$!{%s}@%d", para, sheet));
		
		if (c == null) {
			throw new RuntimeException("XLS模板文件中没有名为【" + para + "】的参数");
		}
		String str = c.getStringCellValue();
		String s = str.replaceAll(REGEX, value == null ? "" : value);
		// try{
		// double d = Double.parseDouble(value);
		// c.setCellValue(d);
		// }catch(Exception e){
		c.setCellValue(s);
		// }
	}
	public void bindCell(String para, Number value, int sheet) {
		Cell c = map.get(String.format("$!{%s}@%d", para, sheet));
		
		if (c == null) {
			throw new RuntimeException("XLS模板文件中没有名为【" + para + "】的参数");
		}
//		String str = c.getStringCellValue();
		if(value==null){
			c.setCellValue(0);
		}
		else if(value instanceof Integer){
			c.setCellValue(value.intValue());
		}else if(value instanceof Double){
			c.setCellValue(value.doubleValue());
		}else if(value instanceof Float){
			c.setCellValue(value.floatValue());
		}else if(value instanceof Long){
			c.setCellValue(value.longValue());
		}else{
			throw new RuntimeException("【"+para + "】的参数不是Number类型");
		}
		
	}

	private HSSFWorkbook initMap(String templateFilePath) throws FileNotFoundException, IOException {
		HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(fs = new FileInputStream(templateFilePath)));
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			HSSFSheet sheet = wb.getSheetAt(i);
			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING: {
						String str = cell.getStringCellValue();
						Matcher m = pattern.matcher(str);
						if (m.find()) {
							// System.out.println("MATCH:" + m.group());
							String key = cellKey(m.group(), i);
							if (map.containsKey(key))
								throw new RuntimeException(String.format("已经包含了占位符[%s]", m.group()));
							map.put(key, cell);
						}
					}
					}
				}
			}
		}
		return wb;
	}

	private String cellKey(String match, int sheet) {
		return String.format("%s@%d", match, sheet);
	}

	/**
	 * 一定要被执行（只能执行一次），否则无法下载
	 * 
	 * @throws IOException
	 */
	private boolean writeOnce = false;

	public void write(OutputStream stream) throws Throwable {
		if (writeOnce) {
			throw new RuntimeException("写文件已经被执行！");
		}
		try {
			clearPlaceholders();
			wb.write(stream);
//		} catch (Throwable t) {
//			throw t;
		}finally{
			if(fs != null){
				fs.close();
				fs = null;
			}
		}
		
		writeOnce = true;
	}

	public void write() throws Throwable {
		write(response.getOutputStream());
	}
	

	public File dumpZipEntry(String entryName,File tempDir){
		File excelFile = new File(tempDir,entryName);
		if(!excelFile.exists()){
			try {
				excelFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try(
			FileOutputStream out = new FileOutputStream(excelFile);
			) {
			wb.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excelFile;
	}

	// 清空未被替换的占位符
	private void clearPlaceholders() {
		HSSFSheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING: {
					String str = cell.getStringCellValue();
					String s = str.replaceAll(REGEX, "").replaceAll(HEADER_REGEX, "");
					cell.setCellValue(s);
				}
				}
			}
		}
		
	}

	public void bindColumns(int headerRow, Object[] objs) {
		bindColumns(headerRow, objs, 0);
	}
	public void bindColumns(int headerRow, Object[] objs,boolean isBorder) {
		bindColumns(headerRow, objs, 0,isBorder);
	}

	/**
	 * 将对象绑定到excel，中添加多行数据
	 * 
	 * @param headerRow
	 *            --变量行 0-based（指示占位符所在行）
	 * @param objs
	 *            --要绑定的对象集合
	 * @param sheetNo
	 *            --要绑定sheet，从0开始，不指定默认为0 模板中的语法为"$#{变量名}"，其中的变量名和objs对象中属性名一致。
	 *            从headerRow开始往下填充objs.length行数据。
	 * 
	 */
	public void bindColumns_(int headerRow, Object[] objs, int sheetNo,boolean isBorder){
		// 找到模板中变量和列标的对应关系，存入map
				wb.setForceFormulaRecalculation(true);
				Map<String, Integer> map = new HashMap<String, Integer>();
				HSSFSheet sheet = wb.getSheetAt(sheetNo);
				//hcs应该放到循环外面创建，否则数据较多时会报cell styles超过4000异常
				HSSFCellStyle hcs = getIntegerContentStyle(wb);
				for (Cell cell : sheet.getRow(headerRow)) {
					// System.out.println(cell.getCellType());
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING: {
						String str = cell.getStringCellValue();
						//System.out.println(str);
						Matcher m = headerPatter.matcher(str);
						if (m.find()) {
							// System.out.println("MATCH:" + m.group());
							String fn = m.group();
							fn = fn.substring(3, fn.length() - 1).trim();
							map.put(fn, cell.getColumnIndex());
							cell.setCellValue("");
						}
					}
					}
				}
				if(map.isEmpty())// 匹配的绑定列为空
					throw new RuntimeException("没有绑定到数据列！");
				// 遍历对象序列，每个对象都找到模板中所指示的属性，取值后设给cell
				int rowIdx = headerRow;
				
				for(Object o : objs){
					Row row = sheet.getRow(rowIdx);
					if(row == null){
						row = sheet.createRow(rowIdx);
					}
					rowIdx++;
					Iterator<String> it = map.keySet().iterator();
					
					while(it.hasNext()){
						String fieldName = it.next();
						//row.setRowStyle(hcs);
						Cell cell = row.getCell(map.get(fieldName));
						if(cell == null)
							cell = row.createCell(map.get(fieldName));
						
						Object val = this.getFieldValueByName(fieldName, o);
						if(val !=null){
							if(val instanceof Double){
								//val = String.format("%,.2f",val);
//								try{
									//double d = Double.parseDouble(val.toString());
									cell.setCellValue((Double)val);
//								}catch(Exception e){
//									cell.setCellValue(val.toString());
//								}
								//cell.setCellStyle(style);
//								if(null!=cell){
//								   double d = Double.parseDouble(val.toString());
//								   cell.setCellStyle(style);
//								   cell.setCellValue(d);
//								}
								//有的是不需要边框线的
								if(isBorder){
									cell.setCellStyle(hcs);	
								}
								continue;
							}else if(val instanceof Integer){
								//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
								//Integer d = Integer.parseInt(val.toString());
								//style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
								cell.setCellValue((Integer)val);
								//有的是不需要边框线的
								if(isBorder){
									cell.setCellStyle(hcs);	
								}
								continue;
								//   cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							}
							// 非数值类型
							
		                    cell.setCellValue(val.toString());
						}	
						//有的是不需要边框线的
						if(isBorder){
							cell.setCellStyle(hcs);//getIntegerContentStyle(wb));	
						}
					}
					
				}
	}
	public void bindColumns(int headerRow, Object[] objs, int sheetNo,boolean isBorder) {
		bindColumns_(headerRow,objs,sheetNo,isBorder);
	}
	public void bindColumns(int headerRow, Object[] objs, int sheetNo) {
		bindColumns_(headerRow,objs,sheetNo,false);
	}
	
	public static HSSFCellStyle getIntegerContentStyle(HSSFWorkbook workbook) {
		HSSFCellStyle contentStyle = workbook.createCellStyle(); // 设置内容行格式
		contentStyle.setAlignment(CellStyle.ALIGN_CENTER);
		contentStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 上下居中
		contentStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//		HSSFDataFormat df = workbook.createDataFormat(); // 此处设置数据格式
//		HSSFFont font=workbook.createFont();
//		font.setFontHeightInPoints((short)10);
//		contentStyle.setDataFormat(df.getFormat("0")); // 数据格式只显示整数，如果是小数点后保留两位，可以写contentStyle.setDataFormat(df.getFormat("#,#0.00"));
		return contentStyle;
	}

	// public void createCellForMoney(Row row,int columnIndex,int
	// cellType,HSSFCellStyle style,def value){
	// Cell cell = row.createCell(columnIndex)
	// style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00")); //
	// 两位小数，只加了一个格式的自定义，反应到Excle上面为自定义的金额，其他格式类似
	// cell.setCellStyle(style)
	// cell.setCellType(cellType)
	// cell.setCellValue(value)
	// }

	/**
	 * 获取对象属性，返回一个字符串数组
	 * 
	 * @param o
	 *            对象
	 * @return String[] 字符串数组
	 */
	private String[] getFiledName(Object o) {
		try {
			Field[] fields = o.getClass().getDeclaredFields();
			String[] fieldNames = new String[fields.length];
			for (int i = 0; i < fields.length; i++) {
				fieldNames[i] = fields[i].getName();
			}
			return fieldNames;
		} catch (SecurityException e) {
			e.printStackTrace();
			// System.out.println(e.toString());
		}
		return null;
	}

	/**
	 * 使用反射根据属性名称获取属性值
	 * 
	 * @param fieldName
	 *            属性名称
	 * @param o
	 *            操作对象
	 * @return Object 属性值
	 */

	private Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(fieldName+"属性不存在");
			return null;
		}
	}

	public HSSFWorkbook getWb() {
		return wb;
	}

}
