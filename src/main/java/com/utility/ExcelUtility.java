package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelUtility {

    public static Object[][] getExcelData(String filepath, String sheetname) {
        Object[][] data = null;

        try (FileInputStream file = new FileInputStream(filepath); Workbook workbook = new XSSFWorkbook(file)) {
            
            Sheet sheet = workbook.getSheet(sheetname);
            int totalRows = sheet.getPhysicalNumberOfRows(); // Excludes empty rows
            int totalColumns = sheet.getRow(0).getLastCellNum();

            data = new Object[totalRows - 1][totalColumns]; // Exclude header row

            for (int i = 1; i < totalRows; i++) { // Start from 1 to skip header
                Row row = sheet.getRow(i);
                for (int j = 0; j < totalColumns; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = (cell == null) ? "" : cell.toString();
                }
            }

        } catch (FileNotFoundException e) {
            Assert.fail("Excel file not found: " + filepath);
        } catch (IOException e) {
            Assert.fail("Error reading Excel file: " + e.getMessage());
        }

        return data;
    }
}

