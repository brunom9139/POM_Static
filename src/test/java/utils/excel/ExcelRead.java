package utils.excel;


import factory.Session;
import io.qameta.allure.Allure;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import utils.ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ExcelRead {
    private static XSSFWorkbook workBook;
    private static XSSFSheet sheet;
    private static ExcelRead instance = null;
    private static List<Map<String, String>> table = new LinkedList<>();
    private static List<Map<String, String>> tableOutLine = new LinkedList<>();
    private static  final Logger logger = Logger.getLogger(ConfigReader.class.getName());
    public ExcelRead() {

    }
    public static ExcelRead getInstance() {
        if (instance == null) {
            instance = new ExcelRead();
        }
        return instance;
    }
    private void setDataSource(String path) {

        File excelFile = new File(path);
        try {
            FileInputStream inputStream = new FileInputStream(excelFile);
            workBook = new XSSFWorkbook(inputStream);
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }

    }
    private void selectSheet(String sheetName) {
        sheet = workBook.getSheet(sheetName);
    }

    private String ConvertIntDoubleToString(double value) {
        double number = value;
        long iPart = (long) number;
        double fPart = number - iPart;
        if (fPart > 0) {
            return String.valueOf(number);
        } else {
            return String.valueOf(iPart);
        }
    }
    private String readCell(int rowIndex, int colIndex) {
        if (sheet.getRow(rowIndex).getCell(colIndex) == null) return "";

        if ((sheet.getRow(rowIndex).getCell(colIndex).getCellType()) == CellType.NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(sheet.getRow(rowIndex).getCell(colIndex))) {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date date = sheet.getRow(rowIndex).getCell(colIndex).getDateCellValue();
                return df.format(date);
            } else {
                return ConvertIntDoubleToString(sheet.getRow(rowIndex).getCell(colIndex).getNumericCellValue());
            }
        } else {
            return sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
        }
    }
    private int getPosition(String value) {
        if (table != null) {
            for (int i = 0; i < table.size(); i++) {
                if (table.get(i).get(Common.columnNameId).equals(value.toUpperCase())) {
                    return i;
                }
            }
        }
        return 0;
    }
    public void cargarDatosSyncronized(){
        //SessionId sessionId = ((RemoteWebDriver) Session.getInstance().getWebDriver()).getSessionId();
        String sessionId = GlobalData.getSessionId();
        DataParallel data= Data.getDataParallel(sessionId.toString());
        int positionSheet=Data.existSheet(data.getModulo());
        if (positionSheet>=0){
            table= SheetData.getTable();
        }else{
            //setDataSource(Data.getProperties().getProperty("path.file").trim() + Data.getProperties().getProperty("name.file").trim());
            setDataSource(ConfigReader.obtenerRutaDescarga().trim() + ConfigReader.obtenerNombreExcel().trim());
            selectSheet(data.getModulo());
            table = loadData();
            Common.listSheet.add(new SheetData(data.getModulo(),table));
        }
    }

    public Boolean isOutLine() {
        //SessionId sessionId = ((RemoteWebDriver) Session.getInstance().getWebDriver()).getSessionId();
        String sessionId = GlobalData.getSessionId();
        DataParallel data= Data.getDataParallel(sessionId.toString());
        List<Map<String, String>> result = table.stream().filter(item -> item.get(Common.columnNameId).equals(data.getTestCaseId()))
                .collect(Collectors.toList());
        if (result == null || result.size() <= 1) {
            return false;
        }
        tableOutLine=result;
        return true;
    }

    public String getValue(String columnName) {
        int position=-1;
        SessionId sessionId;
        //String sessionId;
        try{
            cargarDatosSyncronized();
            sessionId = ((RemoteWebDriver) Session.getInstance().getWebDriver()).getSessionId();
            //sessionId = GlobalData.getSessionId();
            DataParallel data= Data.getDataParallel(sessionId.toString());
            if (table != null && !isOutLine()) {
                position = getPosition(data.getTestCaseId());
                Allure.addAttachment(columnName,table.get(position).get(columnName.toUpperCase()).trim());
                return table.get(position).get(columnName.toUpperCase()).trim();
            }
            if (table != null && isOutLine()) {
                sessionId = ((RemoteWebDriver) Session.getInstance().getWebDriver()).getSessionId();
                //sessionId = GlobalData.getSessionId();
                position=Data.getPositionOutline(data.getTestCaseId(),sessionId.toString());
                Allure.addAttachment(columnName,tableOutLine.get(position).get(columnName.toUpperCase()).trim());
                return tableOutLine.get(position).get(columnName.toUpperCase()).trim();
            }
        }catch (Exception e){
            Assert.fail("La posicion= "+position+" o columna= "+columnName+" no existe en el excel");
            logger.severe("La posicion= "+position+" o columna= "+columnName+" no existe en el excel");
        }
        return "";
    }

    private List<Map<String, String>> loadData() {
        List<Map<String, String>> testData = new ArrayList<>();

        int rows = sheet.getLastRowNum() + 1;
        int columns = sheet.getRow(0).getLastCellNum();

        List<String> heads = new ArrayList<>();
        for (int j = 0; j < columns; j++) {
            heads.add(readCell(0, j).toUpperCase());
        }

        for (int i = 1; i < rows; i++) {
            Map<String, String> mapRow = new HashMap<>();
            for (int j = 0; j < heads.size(); j++) {
                mapRow.put(heads.get(j), readCell(i, j));
            }
            testData.add(mapRow);
        }

        return testData;
    }
}
