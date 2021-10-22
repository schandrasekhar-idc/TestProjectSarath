package credentials;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public String excelLoc; 

	//public static int tab=0;
	// constructor
	public ExcelData() {
		
		excelLoc = "C:\\Users\\schandrasekhar\\eclipse-workspace\\Genericdatafile\\DataDrivenTestFile.xlsx";
	}

	DataFormatter dataFormatter = new DataFormatter();
	String value;

	public String getExcelData(int tab, int row, int cell) throws IOException {
		// fileInputStream argument
		FileInputStream fis = new FileInputStream(excelLoc);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// EXCEL SHEET
		XSSFSheet sheet = workbook.getSheetAt(tab);
		// ROW NUMBER
		Row rowVar = sheet.getRow(row);

		Cell cellVar = rowVar.getCell(cell);
		// CONVERT TO STRING
		value = dataFormatter.formatCellValue(cellVar);

		return value;
		
	}

	public int excelRowCount(int tab) throws IOException {
		// fileInputStream argument
		FileInputStream fis = new FileInputStream(excelLoc);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// EXCEL SHEET
		XSSFSheet sheet = workbook.getSheetAt(tab);
		// ROW NUMBER

		return sheet.getLastRowNum();
	}

	public int excelColumnCount(int tab) throws IOException {
		// fileInputStream argument
		FileInputStream fis = new FileInputStream(excelLoc);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// EXCEL SHEET
		XSSFSheet sheet = workbook.getSheetAt(tab);
		// COLUMN NUMBER
		// System.out.println(" EXCEL COLUMN COUNT
		// "+sheet.getRow(0).getPhysicalNumberOfCells());

		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
}
