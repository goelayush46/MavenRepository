package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class FetchData {

    public static String getData(String sheetName, int row, int col)
            throws EncryptedDocumentException, IOException {

        FileInputStream fis =
                new FileInputStream("./src/test/resources/TestData/Logindata.xlsx");

        Workbook wb = WorkbookFactory.create(fis);

        Cell cell = wb.getSheet(sheetName).getRow(row).getCell(col);
        String value;

        if (cell.getCellType() == CellType.NUMERIC) {
            value = NumberToTextConverter.toText(cell.getNumericCellValue());
        } else {
            value = cell.getStringCellValue();
        }

        wb.close();
        fis.close();

        return value;
    }
}