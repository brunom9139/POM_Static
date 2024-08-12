package utils.excel;

import java.util.List;
import java.util.Map;

public class SheetData {
    private static String sheet;
    private static List<Map<String, String>> table;

    public SheetData(String sheet, List<Map<String, String>> table) {
        SheetData.sheet =sheet;
        SheetData.table =table;
    }

    public static String getSheet() {
        return sheet;
    }

    public static void setSheet(String sheet) {
        SheetData.sheet = sheet;
    }

    public static List<Map<String, String>> getTable() {
        return table;
    }

    public static void setTable(List<Map<String, String>> table) {
        SheetData.table = table;
    }
}
