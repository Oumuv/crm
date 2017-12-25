package com.oumuv.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 解析excel 返回一个list
 * @author Administrator
 *
 */
public class ExcelHelper {
    /**
     * Excel 2003
     */
    private final static String XLS = ".xls";
    /**
     * Excel 2007
     */
    private final static String XLSX = ".xlsx";
    /**
     * 分隔符
     */
    private final static String SEPARATOR = "|";

    /**
     * 解析excel
     * @param file 文件流
     * @param sheetNum 第几个sheet开始解析 默认0
     * @param rowNum 第几行开始解析 默认0
     * @param columnCount 导入列的个数
     * @return
     * @throws IOException
     */
    public static List<String[]> exportListFromExcel(File file, int sheetNum,int rowNum,int columnCount)
            throws IOException {

        return exportListFromExcel(new FileInputStream(file),
                file.getName(), sheetNum,rowNum,columnCount);
    }

    /**
     * 由Excel流的Sheet导出至List
     *
     * @param is
     * @param extensionName
     * @param sheetNum
     * @return
     * @throws IOException
     */
    public static List<String[]> exportListFromExcel(InputStream is,
                                                     String extensionName, int sheetNum,int rowNum,int columnCount) throws IOException {

        Workbook workbook = null;
        int index=extensionName.lastIndexOf(".");
        extensionName=extensionName.substring(index);

        if (extensionName.toLowerCase().equals(XLS)) {
            workbook = new HSSFWorkbook(is);
        } else if (extensionName.toLowerCase().equals(XLSX)) {
            workbook = new XSSFWorkbook(is);
        }else{
            return null;
        }

        return exportListFromExcel(workbook, sheetNum,rowNum,columnCount);
    }

    /**
     * 由指定的Sheet导出至List
     *
     * @param workbook
     * @param sheetNum
     * @return
     * @throws IOException
     */
    private static List<String[]> exportListFromExcel(Workbook workbook,
                                                      int sheetNum,int rowNum,int columnCount) {

        Sheet sheet = workbook.getSheetAt(sheetNum);

        // 解析公式结果
        FormulaEvaluator evaluator = workbook.getCreationHelper()
                .createFormulaEvaluator();

        List<String[]> list = new ArrayList<String[]>();

        int minRowIx = rowNum;
        int maxRowIx = sheet.getLastRowNum();
        for (int rowIx = minRowIx; rowIx <= maxRowIx; rowIx++) {
            Row row = sheet.getRow(rowIx);

            if (row!=null) {


                //StringBuilder sb = new StringBuilder();
                String[] sb=new String[columnCount];
                short minColIx = row.getFirstCellNum();
                short maxColIx = row.getLastCellNum();
                for (short colIx = minColIx; colIx < columnCount; colIx++) {
                    Cell cell = row.getCell(new Integer(colIx));

                    CellValue cellValue = evaluator.evaluate(cell);
                    if (cellValue == null) {
                        sb[colIx]="";
                        continue;
                    }
                    // 经过公式解析，最后只存在Boolean、Numeric和String三种数据类型，此外就是Error了
                    // 其余数据类型，根据官方文档，完全可以忽略http://poi.apache.org/spreadsheet/eval.html
                    switch (cellValue.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            //sb.append(SEPARATOR + cellValue.getBooleanValue());

                            sb[colIx]=String.valueOf(cellValue.getBooleanValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            // 这里的日期类型会被转换为数字类型，需要判别后区分处理


                            String cellValues = "";
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {    //判断是日期类型
                                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
                                Date dt = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());//获取成DATE类型
                                cellValues = dateformat.format(dt);
                            }else{
                                DecimalFormat df = new DecimalFormat("0");
                                cellValues = df.format(cell.getNumericCellValue());
                            }
                            sb[colIx]=String.valueOf(cellValues);

                            break;
                        case Cell.CELL_TYPE_STRING:
                            //sb.append(SEPARATOR + cellValue.getStringValue());
                            sb[colIx]=String.valueOf(cellValue.getStringValue());
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            break;
                        case Cell.CELL_TYPE_ERROR:
                            break;
                        default:
                            break;
                    }
                }
                list.add(sb);

            }
            System.out.println(rowIx);
        }
        return list;
    }
}
