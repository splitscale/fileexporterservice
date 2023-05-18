package com.splitscale.reems;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExporter {

  public static void exportTableToExcel(String[][] tableData, String filePath) {
    try (Workbook workbook = new XSSFWorkbook()) {
      Sheet sheet = workbook.createSheet("Table Data");

      int rowCount = 0;
      for (String[] rowData : tableData) {
        Row row = sheet.createRow(rowCount++);
        int columnCount = 0;
        for (String cellData : rowData) {
          Cell cell = row.createCell(columnCount++);
          cell.setCellValue(cellData);
        }
      }

      try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
        workbook.write(outputStream);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
