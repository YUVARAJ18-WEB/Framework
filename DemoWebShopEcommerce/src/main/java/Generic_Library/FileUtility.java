package Generic_Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public static String getProperty(String key) {

		// step 1:get the java representation object of the physical file using
		// "FileInputStream"
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/test/resources/CommonData.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// step 2:create object of Properties class & load all the keys
		Properties p = new Properties();

		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// step 3:Read the data using getProperty("Key")
		return p.getProperty(key);
	}

	public static String readCellDataFromExcel(String sheet, int row, int cell)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = null;
		// step 1:get the java representation of excel file using "FileInputStream"
		try {

			fis = new FileInputStream("./src/test/resources/TestData.xlsm");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// step 2: get the workbook
		Workbook book = WorkbookFactory.create(fis);

		// step 3: get the sheet
		Sheet sheet1 = book.getSheet(sheet);

		// step 4: get the row
		Row row1 = sheet1.getRow(3);

		// step 5: get the cell from selected row
		System.out.println(row1.getCell(4));

		// reading the data from the cell using method chaining
		return WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell).toString();
	}

	public static String[][] readRowDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis = null;
		// step 1:get the java representation of excel file using "FileInputStream"
		try {

			fis = new FileInputStream("./src/test/resources/TestData.xlsm");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// step 2: get the workbook
		Workbook book = WorkbookFactory.create(fis);

		// step 3: get the sheet
		Sheet sheet = book.getSheet(sheetName);
		
		//step 4; Get the row count having value
		int rowCount=sheet.getPhysicalNumberOfRows();
		
		//step 5: get the cell count having value
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		//step 6: create 2D array 
		String[][] data=new String[rowCount-1][cellCount];
		
		//step 6: read data from excel and store it in 2D array
		for (int i = 1; i < rowCount; i++) {
			
			for (int j = 0; j < cellCount; j++) {
				
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		//return 2D array
		return data;
	}

	//main method
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		readRowDataFromExcel("Register");
	}
}
