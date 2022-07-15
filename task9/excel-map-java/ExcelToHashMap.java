import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class ExcelToHashMap {

    String pathToTheSheet = "C:\\Users\\YOUR\\PATH\\HERE";
    String extensionOfTheSheet = "xlsx";

    String nameOfTheSheetWorkBook = "Task9Workbook";

    @Test
    public void excelToHashMapGenerator() throws IOException
    {

        FileInputStream file = new FileInputStream(
                pathToTheSheet + "." + extensionOfTheSheet);
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sh = wb.getSheet(nameOfTheSheetWorkBook);

        HashMap<Integer, String> map
                = new HashMap<Integer, String>();

        for (int r = 0; r <= sh.getLastRowNum(); r++) {
            int key = (int)sh.getRow(r)
                    .getCell(0)
                    .getNumericCellValue();
            String value;
            value = sh.getRow(r)
                    .getCell(1)
                    .getStringCellValue();
            map.put(key, value);
        }

        for (Entry<Integer, String> new_Map : map.entrySet()) {
            System.out.println(new_Map.getKey() + "|"
                    + new_Map.getValue());
        }
        wb.close();
        file.close();
    }
}
