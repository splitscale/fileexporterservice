package com.splitscale.reems;

import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExporter {

    ExcelExporter() {
        // default
    }

  public Workbook exportToExcel(List<List<Object>> data) {
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Sheet1");

    int rowNum = 0;
    for (List<Object> rowData : data) {
      Row row = sheet.createRow(rowNum++);
      int colNum = 0;
      for (Object field : rowData) {
        Cell cell = row.createCell(colNum++);
        if (field instanceof String) {
          cell.setCellValue((String) field);
        } else if (field instanceof Integer) {
          cell.setCellValue((Integer) field);
        } else if (field instanceof Double) {
          cell.setCellValue((Double) field);
        }
      }
    }
    return workbook;
  }
}
