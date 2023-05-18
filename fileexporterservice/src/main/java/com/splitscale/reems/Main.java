package com.splitscale.reems;

public class Main {
    public static void main(String[] args) {
        String[][] tableData = {
                {"Name", "Age", "City"},
                {"Jerome", "25", "New York"},
                {"Jiv", "30", "London"},
                {"Candace", "40", "Paris"}
        };

        String filePath = "C:/Users/User/OneDrive/Desktop/trial.xlsx";
        ExcelExporter.exportTableToExcel(tableData, filePath);
        System.out.println("Table exported to Excel successfully!");
    }
}

