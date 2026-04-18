package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFetching {
	
	public String[] methodA() throws EncryptedDocumentException, IOException {
		FileInputStream f1 = new FileInputStream("./src/test/resources/TestData/LoginData.xlsx");// location
		Workbook wb = WorkbookFactory.create(f1);
		String username = wb.getSheet("login").getRow(1).getCell(0).getStringCellValue();
		String password = wb.getSheet("login").getRow(1).getCell(1).getStringCellValue();
		String invalid_username = wb.getSheet("login").getRow(2).getCell(0).getStringCellValue();
		String invalid_password = wb.getSheet("login").getRow(2).getCell(1).getStringCellValue();
		wb.close();
		f1.close();
		return new String[]{
			    username, password,
			    invalid_username, invalid_password
			};
	}
}