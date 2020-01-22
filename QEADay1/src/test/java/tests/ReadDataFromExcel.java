package tests;



import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static Object[][] readDataFromExcel() {
		File file = new File("src/test/resources/dataProvider/datasheet.xlsx");
		Object[][] obj = null;
		XSSFWorkbook book;

		try {
			book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheet("Sheet1");
			obj = new Object[sheet.getLastRowNum()][];
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				obj[i - 1] = new Object[sheet.getRow(i).getPhysicalNumberOfCells()];
				for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {

//						System.out.println(sheet.getRow(i).getCell(j).getStringCellValue() + "\t");
					CellType cellType = sheet.getRow(i).getCell(j).getCellType();
					if (cellType == CellType.STRING) {
						obj[i - 1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					}
					if (cellType == CellType.NUMERIC) {
						obj[i - 1][j]=sheet.getRow(i).getCell(j).getNumericCellValue();
					}
					if (cellType == CellType.BOOLEAN) {
						obj[i - 1][j]=sheet.getRow(i).getCell(j).getBooleanCellValue();
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
		return obj;
	}

}
