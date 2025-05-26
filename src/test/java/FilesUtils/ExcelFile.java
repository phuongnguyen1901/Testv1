package FilesUtils;

import Common.Constans;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class ExcelFile {
    private static XSSFWorkbook workBook;
    private static XSSFSheet sheetName;
    private static XSSFRow row;
    private static XSSFCell cell;

    public static void getSetUp(String excelFilePath) {
        String[] excelSetUp = excelFilePath.split(">");
        Constans.fileExcelName = excelSetUp[0].trim();
        Constans.sheetName = excelSetUp[1].trim();
        Constans.testCaseName = excelSetUp[2].trim();
    }
    public static void setExcelInfo(String file, String sheet) {
        try {
            //File fileExcel = new File(file);
            FileInputStream excelFile = new FileInputStream(file);
            workBook = new XSSFWorkbook(excelFile);
            sheetName = workBook.getSheet(sheet);
            cell = sheetName.getRow(0).getCell(0);
            //System.out.println(String.valueOf(cell.getStringCellValue()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static String getCellData(int rowNum, int colNum) {
        String cellData;
        try {
            cell = sheetName.getRow(rowNum).getCell(colNum);
            if (cell != null) {
                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                    Object object = cell.getRawValue();
                    cellData = String.valueOf(object);
                }
                else {
                    cellData = cell.getStringCellValue();
                }
            }
            else {
                cellData = "";
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.err.println(e.getMessage());
            cellData = "";
        }
        return cellData;
    }
    public static int getLastRowIndex() {
        return sheetName.getLastRowNum();
    }
    public static ArrayList<Integer> getRowByTCNameIndex(String tcName, int colIndex){
        int lastRow = getLastRowIndex();
        ArrayList<Integer> listRow = new ArrayList<>();
        for (int i = 0; i <= lastRow; i++) {
            if (getCellData(i,colIndex).contains(tcName)) {
                listRow.add(i);
            }
        }
        return listRow;
    }
    public static String[][] getData(String testcase, int totalCol,int colIndex){
        String[][] data = null;
        ArrayList<Integer> allRows = getRowByTCNameIndex(testcase, colIndex);
        try {
            data = new String[allRows.size()][totalCol];
            for (int i = 0; i < allRows.size(); i++) {
                data[i][0] = allRows.get(i).toString();
                for(int j = 0; j< totalCol ; j++) {
                    data[i][j] = getCellData(allRows.get(i), j);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return data;
    }
    public static void setCellDataResult(int colIndex,int rowIndex, String fileName, String result) {
        try {
            row = sheetName.getRow(rowIndex);
            cell = row.getCell(colIndex);
            CellStyle style = workBook.createCellStyle();
            XSSFFont font = workBook.createFont();
            font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            if (result.equals(Constans.fail)) {
                style.setFillBackgroundColor(IndexedColors.RED1.getIndex());
                style.setFillPattern(FillPatternType.LESS_DOTS);
            }
            else if (result.equals(Constans.pass)) {
                style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
                style.setFillPattern(FillPatternType.LESS_DOTS);
            }
            style.setBorderBottom(BorderStyle.MEDIUM);
            style.setBorderTop(BorderStyle.MEDIUM);
            style.setBorderLeft(BorderStyle.MEDIUM);
            style.setBorderRight(BorderStyle.MEDIUM);
            if (cell == null) {
                cell = row.createCell(colIndex);
                cell.setCellStyle(style);
                cell.setCellValue(result);
            }
            else {
                cell.setCellStyle(style);
                cell.setCellValue(result);
            }

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            workBook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

    }
    public static void setPass(int colPass, int row, int colFail) {
        setCellDataResult(colPass,row, Constans.dataFolder+Constans.fileExcelName,Constans.pass);
        setCellDataResult(colFail,row,Constans.dataFolder+Constans.fileExcelName,"");
    }
    public static void setFail(int colPass, int row, int colFail) {
        setCellDataResult(colFail,row,Constans.dataFolder+Constans.fileExcelName,Constans.fail);
        setCellDataResult(colPass,row,Constans.dataFolder+Constans.fileExcelName,"");
    }

    public static void insertDataToExcelFile(Map<String, Object> data, List<String> coloumnName, String filePath) {
        try {
            String[] excelSetUp = filePath.split(">");
            String fileExcelNameItem = Constans.dataFolder + excelSetUp[0].trim();
            String sheetName = excelSetUp[1].trim();
            String testCaseName = excelSetUp[2].trim();
            FileInputStream excelFile = new FileInputStream(fileExcelNameItem);
            XSSFWorkbook workBookItem = new XSSFWorkbook(excelFile);
            XSSFSheet sheetItem = workBookItem.getSheet(sheetName);
            int lastRownum = sheetItem.getLastRowNum();
            Integer rowNum = null;
            for (int i = lastRownum; i > 0; i--) {
                XSSFRow row = sheetItem.getRow(i);
                XSSFCell cellTestcase = row.getCell(1);
                if (cellTestcase.getStringCellValue().contains(testCaseName)) {
                    rowNum = i;
                    break;
                }
            }
            XSSFRow rowTestcase = sheetItem.getRow(rowNum);
            for (int i = 0; i < coloumnName.size(); i++) {
                XSSFCell cellItem = rowTestcase.getCell(i);
                Object dataWithColoumn = data.get(coloumnName.get(i));
                if (!Objects.isNull(dataWithColoumn)) {
                    if (cellItem == null) {
                        cellItem = rowTestcase.createCell(i);
                        cellItem.setCellValue(dataWithColoumn.toString());
                    } else {
                        cellItem.setCellValue(dataWithColoumn.toString());
                    }
                }
            }
            FileOutputStream fileOutputStreamItem = new FileOutputStream(fileExcelNameItem);
            workBookItem.write(fileOutputStreamItem);
            fileOutputStreamItem.flush();
            fileOutputStreamItem.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "SaveJob.xlsx>data>Save_Job";
        Map<String, Object> data = new HashMap<>();
        data.put("TitleJob", "datatest");
        insertDataToExcelFile(data, MapData.saveJobColoumn, filePath);
    }
}
