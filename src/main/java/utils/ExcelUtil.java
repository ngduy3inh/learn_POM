package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static XSSFWorkbook excelWBook;
	private static XSSFSheet excelWSheet;
	private static XSSFCell cell;
	private static XSSFRow row;

	// Global test data excel file
	public static final String excelFileName = "testdata.xlsx";

	// Main Directory of the project
	public static final String projectPath = System.getProperty("user.dir");

	// Location of Test data excel file
	public static String excelFilePath = null;

	public static void setExcelFile(String sheetName) throws IOException {
		excelFilePath = projectPath + "\\src\\main\\resources\\";
		// Mở file Excel
		FileInputStream excelFile = new FileInputStream(excelFilePath + excelFileName);

		// Truy cập vào Sheet chứa data
		excelWBook = new XSSFWorkbook(excelFile);
		excelWSheet = excelWBook.getSheet(sheetName);
	}

	// Đọc dữ liệu từ file excel
	public static String getCellData(int rowNum, int colNum) {
		cell = excelWSheet.getRow(rowNum).getCell(colNum);
//			return cell.getStringCellValue();
		DataFormatter format = new DataFormatter();
		return format.formatCellValue(cell);
	}

	// Ghi dữ liệu vào file excel
	public static void setCellData(String result, int rowNum, int colNum) throws IOException {
		row = excelWSheet.getRow(rowNum);
		cell = row.getCell(colNum);
		if (cell == null) {
			cell = row.createCell(colNum);
			cell.setCellValue(result);
		} else {
			cell.setCellValue(result);
		}
		FileOutputStream fileOut = new FileOutputStream(excelFilePath + excelFileName);
		excelWBook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
}