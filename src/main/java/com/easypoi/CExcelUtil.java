package com.easypoi;


import lombok.Cleanup;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class CExcelUtil {
    private static DecimalFormat df = new DecimalFormat("0");             //数字格式，防止长数字成为科学计数法形式，或者int变为double形式

    //获取excel解析引擎
    public static Workbook getExcelEngine(String fileName, File file){
        if (StringUtils.isEmpty(fileName) || file == null) {
            return null;
        }
        try {
            @Cleanup InputStream in = new FileInputStream(file);
            return getExcelEngine(fileName, in);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //获取excel解析引擎
    public static Workbook getExcelEngine(String fileName, InputStream in){
        Workbook workbook = null;
        try {
            if(fileName.endsWith("xls")){
                workbook=new HSSFWorkbook(in);
            }else {
                workbook=new XSSFWorkbook(in);
            }
            return workbook;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //判断单元格类型,返回指定值
    public static String getCellValue(Cell cell, boolean timeFlag){
        int cellType = cell.getCellType();
        String res;
        switch (cellType){
            case 0:
                if(HSSFDateUtil.isCellDateFormatted(cell)){
                    Date date = cell.getDateCellValue();
                    if(timeFlag) {
                        res = DateFormatUtils.format(date, "yyyyMMdd");
                    }else {
                        res = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
                    }
                }else {
                    cell.setCellType(0);
                    res =df.format(cell.getNumericCellValue());
                }

                break;
            case 1:
            case 2://公式---也强转为string
                cell.setCellType(1);
                res = cell.getStringCellValue();
                break;
            case 3://空值
                cell.setCellType(3);
                res = "";
            case 4://布尔值
                cell.setCellType(4);
                res = String.valueOf( cell.getBooleanCellValue());
                break;
            default:
                res="";
                break;
        }
        return res;
    }
    /**
     * 获取指定行列的值
     * @param sheet
     * @param rowNum 行--- 0表示第一行
     * @param colNum 列--- 0表示第一列
     * @return
     */
    public static String getRowCell(Sheet sheet, int rowNum, int colNum, boolean timeFlag){
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        return  getCellValue(cell,timeFlag);
    }

    /**
     * execl解析----统一封装到list<String[]>
     * @param sheet
     * @param rowBegin 起始行
     * @param colBegin 起始列
     * @param maxRows   最大行
     * @param maxCols  最大列
     * @return
     * @throws IOException
     */
    public static List<String[]>  adjustExcelParse(Sheet sheet, int rowBegin, int colBegin, int maxRows, int maxCols, boolean flag) {
        //将每一个单元格，设置为 String类型
        //解析
        try {
            Row row;
            Cell cell;
            String[] arr;
            List<String[]> datas = new ArrayList<String[]>();
            //判断最大行数是否为-1，若为-1，则取最大行值
            int endRows=sheet.getLastRowNum()+1;
            if(-1!=maxRows){
                endRows=maxRows;
            }
            for(int i=rowBegin-1;i<endRows;i++){
                arr = new String[maxCols-colBegin+1];//封装每一列的结果
                row = sheet.getRow(i);
                if(null == row) continue;
                for(int j=colBegin-1;j<maxCols;j++){
                    cell = row.getCell(j);
                    //if (null==cell) continue;
                    if(cell==null||cell.equals("")||cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){
                        continue;
                    }
                    String cellValue = getCellValue(cell,flag);
                    arr[j-colBegin+1] = cellValue;
                }
                datas.add(arr);
            }
            return datas;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 特殊情况，走特殊逻辑
     */

    /**
     * 日期格式转换
     */
    public static String formatDateCell(int nums){
        Calendar c = new GregorianCalendar(1900,0,-1);
        Date d = c.getTime();
        Date nd = DateUtils.addDays(d,nums); //42605是距离1900年1月1日的天数
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(nd);
        return format;
    }


    /**
     * 返回单元格合并的数据
     *
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public static String getMergedRegionValue(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();

        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if (row >= firstRow && row <= lastRow) {

                if (column >= firstColumn && column <= lastColumn) {
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return CExcelUtil.getCellValue(fCell, true);
                }
            }
        }

        return null;
    }


    /**
     * 判断指定的单元格是否是合并单元格
     *
     * @param sheet
     * @param row    行下标
     * @param column 列下标
     * @return
     */
    public static boolean isMergedRegion(Sheet sheet, int row, int column) {

        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {

            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    return true;
                }
            }
        }
        return false;
    }

}

