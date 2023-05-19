package com.splitscale.reems;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileToByteConverterTest {

    @Test
    void testConvertToBytes() {
        List<List<Object>> data = new ArrayList<>();
        List<Object> row1 = new ArrayList<>();
        row1.add("Name");
        row1.add("Age");
        row1.add("Email");
        data.add(row1);
        List<Object> row2 = new ArrayList<>();
        row2.add("John Doe");
        row2.add(30);
        row2.add("john.doe@example.com");
        data.add(row2);

        ExcelExporter excelExporter = new ExcelExporter();
        Workbook workbook = excelExporter.exportToExcel(data);

        FileToByteConverter fileToByteConverter = new FileToByteConverter();
        try {
            byte[] bytes = fileToByteConverter.convertToBytes(workbook);
            Assertions.assertNotNull(bytes);
            Assertions.assertTrue(bytes.length > 0);
        } catch (IOException e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }
}
