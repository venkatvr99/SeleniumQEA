package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider {

	
	public void testDataFromExcel() {
		File file = new File("src/test/resources/dataProvider/datasheet.xlsx");
		XSSFWorkbook book;
		
		try {
			book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheet("Sheet1");
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {

//					System.out.println(sheet.getRow(i).getCell(j).getStringCellValue() + "\t");
					CellType cellType = sheet.getRow(i).getCell(j).getCellType();
					if (cellType == CellType.STRING) {
						System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
					}
					if (cellType == CellType.NUMERIC) {
						System.out.println(sheet.getRow(i).getCell(j).getNumericCellValue());
					}
					if (cellType == CellType.BOOLEAN) {
						System.out.println(sheet.getRow(i).getCell(j).getBooleanCellValue());
					}
					if (cellType == CellType.BLANK) {
						System.out.println("Value is Blank");
					}
				}
				System.out.println();
			}
			book.close();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}